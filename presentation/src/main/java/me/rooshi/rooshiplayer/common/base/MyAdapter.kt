package me.rooshi.rooshiplayer.common.base

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import me.rooshi.rooshiplayer.common.util.extensions.setVisible

abstract class MyAdapter<T, Binding: ViewBinding> : RecyclerView.Adapter<MyViewHolder<Binding>>() {

    var data: List<T> = ArrayList()
    set(value) {
        if (field == value) return

        val diff = DiffUtil.calculateDiff(getDiffUtilCallback(field, value))
        field = value
        diff.dispatchUpdatesTo(this)
        onDatasetChanged()

        emptyView?.setVisible(value.isEmpty())
    }

    var emptyView: View? = null
    set(value) {
        field = value
        field?.isVisible = data.isEmpty()
    }

    fun getItem(position: Int) : T {
        return data[position]
    }

    open fun onDatasetChanged() {}

    private fun getDiffUtilCallback(oldData: List<T>, newData: List<T>): DiffUtil.Callback {
        return object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldData.size

            override fun getNewListSize(): Int = newData.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition] == newData[newItemPosition]
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldData[oldItemPosition] == newData[newItemPosition]
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
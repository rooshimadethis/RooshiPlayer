package me.rooshi.rooshiplayer.common.base

import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import io.realm.*
import me.rooshi.rooshiplayer.common.util.extensions.setVisible

abstract class MyRealmAdapter<T: RealmModel, Binding: ViewBinding>
    : RealmRecyclerViewAdapter<T, MyViewHolder<Binding>>(null, true) {

    override fun getItem(index: Int): T? {
        if (index < 0) {
            Log.e("MyRealmAdapter", "getItem index must be >= 0")
            return null
        }
        return super.getItem(index)
    }

    override fun updateData(data: OrderedRealmCollection<T>?) {
        if (getData() === data) return

        removeListener(getData())
        addListener(data)

        data?.run(emptyListener)

        super.updateData(data)
    }

    var emptyView: View? = null
        set(value) {
            if (field === value) return

            field = value
            value?.setVisible(data?.isLoaded == true && data?.isEmpty() == true)
        }

    private val emptyListener: (OrderedRealmCollection<T>) -> Unit = { data ->
        emptyView?.setVisible(data.isLoaded && data.isEmpty())
    }

    private fun addListener(data: OrderedRealmCollection<T>?) {
        when (data) {
            is RealmResults<T> -> data.addChangeListener(emptyListener)
            is RealmList<T> -> data.addChangeListener(emptyListener)
        }
    }

    private fun removeListener(data: OrderedRealmCollection<T>?) {
        when (data) {
            is RealmResults<T> -> data.removeChangeListener(emptyListener)
            is RealmList<T> -> data.removeChangeListener(emptyListener)
        }
    }
}
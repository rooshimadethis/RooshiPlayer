package me.rooshi.rooshiplayer.common.base

import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import io.realm.OrderedRealmCollection
import io.realm.RealmModel
import io.realm.RealmRecyclerViewAdapter

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

    private fun addListener(data: OrderedRealmCollection<T>?)
}
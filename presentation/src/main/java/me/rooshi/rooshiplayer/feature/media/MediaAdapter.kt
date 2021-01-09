package me.rooshi.rooshiplayer.feature.media

import android.view.ViewGroup
import me.rooshi.domain.model.RpFile
import me.rooshi.rooshiplayer.common.base.MyRealmAdapter
import me.rooshi.rooshiplayer.common.base.MyViewHolder
import me.rooshi.rooshiplayer.databinding.MediaItemBinding
import javax.inject.Inject

class MediaAdapter @Inject constructor(

) : MyRealmAdapter<RpFile, MediaItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<MediaItemBinding> {
        return MyViewHolder(parent, MediaItemBinding::inflate)
    }

    override fun onBindViewHolder(holder: MyViewHolder<MediaItemBinding>, position: Int) {
        val menuItem = getItem(position)

    }

}
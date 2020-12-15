package me.rooshi.rooshiplayer.feature.media

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import autodispose2.androidx.lifecycle.scope
import autodispose2.autoDispose
import me.rooshi.domain.manager.PermissionManager
import me.rooshi.rooshiplayer.common.base.MyViewModel

class MediaViewModel @ViewModelInject constructor(
    private val permissionManager: PermissionManager
): MyViewModel<MediaView, MediaState>(MediaState()) {

    override fun bindView(view: MediaView) {
        super.bindView(view)

        view.addMediaIntent
            .filter { permissionManager.hasReadExternalStorage().also { if (!it) view.requestReadExternalMedia() } }
            .doOnNext {
                view.selectMediaFiles()
            }
            .autoDispose(view.scope())
            .subscribe()

        //TODO: autodispose does not work here. It disposes before returning from the file intent
        view.filesSelectedIntent
            .doOnNext {
                Log.e("result", "kjhgkjhgkjh")
            }
            .subscribe()

    }

    override fun onCleared() {
        super.onCleared()

    }

}
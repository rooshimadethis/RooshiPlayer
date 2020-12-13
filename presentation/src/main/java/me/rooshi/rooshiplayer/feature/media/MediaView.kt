package me.rooshi.rooshiplayer.feature.media

import io.reactivex.rxjava3.core.Observable
import me.rooshi.rooshiplayer.common.base.MyView

interface MediaView : MyView<MediaState> {
    val addMediaIntent: Observable<Unit>

    fun requestReadExternalMedia()
}
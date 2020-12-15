package me.rooshi.rooshiplayer.feature.media

import android.net.Uri
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.Subject
import me.rooshi.rooshiplayer.common.base.MyView

interface MediaView : MyView<MediaState> {
    val addMediaIntent: Observable<Unit>
    val filesSelectedIntent: Subject<Uri>

    fun requestReadExternalMedia()
    fun selectMediaFiles()
}
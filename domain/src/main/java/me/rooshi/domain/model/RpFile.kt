package me.rooshi.domain.model

import android.graphics.Bitmap
import android.net.Uri
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class RpFile(
    @PrimaryKey @Required var id: Int = 0,
    var name: String = "",
    var location: Uri = Uri.EMPTY,
    var thumbnail: Bitmap? = null
) : RealmObject()
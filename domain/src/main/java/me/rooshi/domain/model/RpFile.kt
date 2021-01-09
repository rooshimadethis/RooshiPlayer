package me.rooshi.domain.model

import android.graphics.Bitmap
import android.net.Uri
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required


open class RpFile: RealmObject() {

    @PrimaryKey var id: Long = 0
    var name: String = ""
    var location: String = ""
    //var thumbnail: Bitmap? = null

}
package me.rooshi.domain.repository

import android.net.Uri
import io.realm.RealmResults
import me.rooshi.domain.model.RpFile

interface MediaStorageRepository {

    fun getAllFiles() : RealmResults<RpFile>

    fun saveFile(uri: Uri)
}
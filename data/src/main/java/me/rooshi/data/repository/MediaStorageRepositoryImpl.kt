package me.rooshi.data.repository

import android.app.Application
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import io.realm.Realm
import io.realm.RealmResults
import me.rooshi.domain.manager.KeyManager
import me.rooshi.domain.model.RpFile
import me.rooshi.domain.repository.MediaStorageRepository
import javax.inject.Inject


class MediaStorageRepositoryImpl @Inject constructor(
    private val keyManager: KeyManager
) : MediaStorageRepository {

    override fun getAllFiles() : RealmResults<RpFile> {
        return Realm.getDefaultInstance().use { realm ->
            realm.where(RpFile::class.java)
                .sort("id")
                .findAll()
        }
    }

    override fun saveFile(uri: Uri) {
        Realm.getDefaultInstance().use { realm ->
            realm.refresh()

            val newFile = RpFile()
            newFile.id = keyManager.newId()
            newFile.location = uri.toString()
            realm.executeTransactionAsync(
                { bgRealm -> bgRealm.insertOrUpdate(newFile)},
                {realm.close()}, {realm.close()})
        }
    }

}
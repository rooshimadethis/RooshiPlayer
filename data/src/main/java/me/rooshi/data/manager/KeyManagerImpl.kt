package me.rooshi.data.manager

import io.realm.Realm
import me.rooshi.domain.manager.KeyManager
import me.rooshi.domain.model.RpFile
import javax.inject.Inject

class KeyManagerImpl @Inject constructor(): KeyManager {

    private var initialized = false
    private var maxValue: Long = 0

    override fun reset() {
        initialized = true
        maxValue = 0
    }

    override fun newId(): Long {
        if (!initialized) {
            maxValue = Realm.getDefaultInstance().use { realm ->
                realm.where(RpFile::class.java).max("id")?.toLong() ?: 0
            }
            initialized = true
        }

        maxValue++
        return maxValue
    }
}
package me.rooshi.rooshiplayer.migration

import io.realm.DynamicRealm
import io.realm.RealmMigration
import javax.inject.Inject

class MyRealmMigration @Inject constructor() : RealmMigration {

    companion object {
        const val latestVersion:Long = 0L
    }

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        var currentVersion = oldVersion

        //update when changing schema only when people are using the app
        //if (version == 0L) {
        // move around stuff
    }
}
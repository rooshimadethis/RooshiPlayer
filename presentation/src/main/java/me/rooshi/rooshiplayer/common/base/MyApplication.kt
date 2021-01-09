package me.rooshi.rooshiplayer.common.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration
import me.rooshi.rooshiplayer.migration.MyRealmMigration
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject lateinit var realmMigration: MyRealmMigration

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder()
            .compactOnLaunch()
            .deleteRealmIfMigrationNeeded() //TODO remove for prod version
            .migration(realmMigration)
            .schemaVersion(MyRealmMigration.latestVersion)
            .build())
    }
}
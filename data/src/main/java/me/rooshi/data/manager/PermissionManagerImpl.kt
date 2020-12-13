package me.rooshi.data.manager

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import me.rooshi.domain.manager.PermissionManager
import javax.inject.Inject

class PermissionManagerImpl @Inject constructor(
    @ApplicationContext private val context : Context
): PermissionManager {
    override fun hasReadExternalStorage() : Boolean {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED
    }
}
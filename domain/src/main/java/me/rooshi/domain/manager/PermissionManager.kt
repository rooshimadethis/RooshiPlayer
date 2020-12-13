package me.rooshi.domain.manager

interface PermissionManager {
    fun hasReadExternalStorage() : Boolean
}
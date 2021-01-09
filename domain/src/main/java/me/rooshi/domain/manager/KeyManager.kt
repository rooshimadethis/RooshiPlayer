package me.rooshi.domain.manager

interface KeyManager {

    fun reset()

    fun newId(): Long
}
package me.rooshi.data.manager

import me.rooshi.domain.manager.KeyManager

class KeyManagerImpl : KeyManager {

    private var maxValue: Int = 0

    override fun reset() {
        maxValue = 0
    }

    override fun newId(): Int {
        maxValue++
        return maxValue
    }
}
package me.rooshi.rooshiplayer.common.base

import androidx.lifecycle.LifecycleOwner

interface MyView<in State> : LifecycleOwner {
    fun render(state: State)
}
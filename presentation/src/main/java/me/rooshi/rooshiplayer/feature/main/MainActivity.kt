package me.rooshi.rooshiplayer.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.rooshi.rooshiplayer.common.base.MyThemedActivity
import me.rooshi.rooshiplayer.common.util.extensions.viewBinding
import me.rooshi.rooshiplayer.databinding.MainActivityBinding

@AndroidEntryPoint
class MainActivity : MyThemedActivity(), MainView {



    private val binding by viewBinding(MainActivityBinding::inflate)
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        viewModel.bindView(this)
    }

    override fun render(state: MainState) {
    }

}
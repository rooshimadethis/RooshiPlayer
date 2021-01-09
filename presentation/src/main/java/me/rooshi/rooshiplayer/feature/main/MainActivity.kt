package me.rooshi.rooshiplayer.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.rooshi.rooshiplayer.R
import me.rooshi.rooshiplayer.common.base.MyThemedActivity
import me.rooshi.rooshiplayer.common.util.extensions.viewBinding
import me.rooshi.rooshiplayer.databinding.MainActivityBinding
import me.rooshi.rooshiplayer.feature.media.MediaFragment

@AndroidEntryPoint
class MainActivity : MyThemedActivity(), MainView {

    private var mediaFragment = MediaFragment()

    private val binding by viewBinding(MainActivityBinding::inflate)
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        viewModel.bindView(this)

        setSupportActionBar(findViewById(R.id.toolbar))

        setupContainers()

    }

    override fun render(state: MainState) {
    }

    private fun setupContainers() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_fragment_container, mediaFragment, "media")
                .commit()
    }
}
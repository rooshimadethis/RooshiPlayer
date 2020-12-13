package me.rooshi.rooshiplayer.feature.media

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.jakewharton.rxbinding4.view.clicks
import dagger.hilt.android.AndroidEntryPoint
import me.rooshi.rooshiplayer.R
import me.rooshi.rooshiplayer.common.base.MyFragment
import me.rooshi.rooshiplayer.common.util.extensions.viewBinding
import me.rooshi.rooshiplayer.databinding.MediaFragmentBinding

@AndroidEntryPoint
class MediaFragment : MyFragment(R.layout.media_fragment), MediaView {

    override val addMediaIntent by lazy { binding.addMediaButton.clicks() }

    private val binding by viewBinding(MediaFragmentBinding::bind)
    private val viewModel : MediaViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.media_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.bindView(this)
    }

    override fun render(state: MediaState) {

    }

    override fun requestReadExternalMedia() {
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 0)
    }
}
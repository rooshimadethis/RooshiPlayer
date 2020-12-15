package me.rooshi.rooshiplayer.feature.media

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.jakewharton.rxbinding4.view.clicks
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import me.rooshi.rooshiplayer.R
import me.rooshi.rooshiplayer.common.base.MyFragment
import me.rooshi.rooshiplayer.common.util.extensions.viewBinding
import me.rooshi.rooshiplayer.databinding.MediaFragmentBinding

@AndroidEntryPoint
class MediaFragment : MyFragment(R.layout.media_fragment), MediaView {

    companion object {
        private const val SelectFilesRequestCode = 0
    }

    override val addMediaIntent by lazy { binding.addMediaButton.clicks() }
    override val filesSelectedIntent: Subject<Uri> = PublishSubject.create()

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

    override fun selectMediaFiles() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        val mimeTypes = arrayOf("audio/*", "video/*")
        intent.setType("*/*")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, SelectFilesRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when {
                requestCode == SelectFilesRequestCode -> {
                    data?.clipData?.itemCount
                        ?.let { count -> 0 until count }
                        ?.mapNotNull { i -> data.clipData?.getItemAt(i)?.uri }
                        ?.forEach {
                            filesSelectedIntent::onNext}
                        ?: data?.data?.let(filesSelectedIntent::onNext)
                }
            }
        }
    }
}
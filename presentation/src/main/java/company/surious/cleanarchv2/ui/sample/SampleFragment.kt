package company.surious.cleanarchv2.ui.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import company.surious.cleanarchv2.R
import company.surious.cleanarchv2.databinding.FragmentSampleBinding
import company.surious.cleanarchv2.sample.SampleViewModel
import org.koin.android.ext.android.inject

class SampleFragment : Fragment() {
    private val sampleViewModel: SampleViewModel by inject()
    private lateinit var binding: FragmentSampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sample,
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sampleViewModel = sampleViewModel
        binding.eventHandler = SampleEventHandler()
    }

    inner class SampleEventHandler {
        fun onUpdateButtonClicked() {
            sampleViewModel.update()
        }
    }
}

package xyz.gozdzik.serfadesignexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import xyz.gozdzik.serfadesignexample.databinding.DemoFragmentBinding
import xyz.gozdzik.serfadesignexample.demochoice.TestChoice

class DemoFragment : Fragment() {

    private lateinit var binding: DemoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DemoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.apply {
            sbvLoading.setOnClickListener {
                lvLoadingView.visibility = View.VISIBLE
            }
            sbvBottomSheet.setOnClickListener {
                findNavController().navigate(
                    DemoFragmentDirections.navigateToDemoChoiceBottomSheet(
                        TestChoice.TEST_CHOICE_1
                    )
                )
            }
            lvLoadingView.setOnClickListener {
                lvLoadingView.visibility = View.GONE
            }
        }

    }

}
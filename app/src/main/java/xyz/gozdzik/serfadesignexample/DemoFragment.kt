package xyz.gozdzik.serfadesignexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import xyz.gozdzik.serfadesignexample.databinding.DemoFragmentBinding
import xyz.gozdzik.serfadesignexample.demochoice.DemoChoiceBottomSheetFragment
import xyz.gozdzik.serfadesignexample.demochoice.TestChoice

class DemoFragment : Fragment() {

    private lateinit var binding: DemoFragmentBinding
    private var testChoice = TestChoice.TEST_CHOICE_1

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
                setFragmentResultListener(DemoChoiceBottomSheetFragment.REQUEST_KEY) { _, bundle ->
                    (bundle.get(DemoChoiceBottomSheetFragment.CHOICE) as? TestChoice)?.let { testChoice ->
                        this@DemoFragment.testChoice = testChoice
                    }
                }
                findNavController().navigate(
                    DemoFragmentDirections.navigateToDemoChoiceBottomSheet(
                        testChoice
                    )
                )
            }
            lvLoadingView.setOnClickListener {
                lvLoadingView.visibility = View.GONE
            }
            stvToolbar.setMenuButtons(
                TestSearchToolbarMenuItem.values().toList()
            ) {
                when (it) {
                    TestSearchToolbarMenuItem.SORT -> showNotImplementedToast()
                    TestSearchToolbarMenuItem.DELETE -> showNotImplementedToast()
                    TestSearchToolbarMenuItem.FILTER -> showNotImplementedToast()
                }
            }
            stvToolbar.leftButtonCallback { showNotImplementedToast() }
            stvToolbar.rightButtonCallback { showNotImplementedToast() }
            stvToolbar.setSearchCallback { showNotImplementedToast() }
        }
    }

    private fun showNotImplementedToast() = Toast.makeText(
        context,
        getString(R.string.not_implemented), Toast.LENGTH_SHORT
    ).show()

}
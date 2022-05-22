package xyz.gozdzik.serfadesignexample.demochoice

import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceBottomSheetFragment
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceItem
import xyz.gozdzik.serfadesignexample.R

class DemoChoiceBottomSheetFragment : SingleChoiceBottomSheetFragment<TestChoice>() {

    private val args: DemoChoiceBottomSheetFragmentArgs by navArgs()

    override fun getPreselectedItem(): SingleChoiceItem<TestChoice>? = args.preselectedChoiceItem

    override fun getChoiceItems(): List<SingleChoiceItem<TestChoice>> = TestChoice.values().toList()

    override fun setNavigationResult(choice: SingleChoiceItem<TestChoice>) {
        setFragmentResult(
            REQUEST_KEY, bundleOf(
                CHOICE to choice.enum
            )
        )
    }

    override fun getTitle(): String = getString(R.string.test_choice_title)

    companion object {

        const val REQUEST_KEY = "SortBottomSheetRequestKey"
        const val CHOICE = "Choice"

    }

}
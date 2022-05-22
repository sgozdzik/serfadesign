package xyz.gozdzik.serfadesignexample.demochoice

import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceBottomSheetFragment
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceItem
import xyz.gozdzik.serfadesignexample.R

class DemoChoiceBottomSheetFragment : SingleChoiceBottomSheetFragment<TestChoice>() {

    override fun getPreselectedItem(): SingleChoiceItem<TestChoice>? = null

    override fun getChoiceItems(): List<SingleChoiceItem<TestChoice>> = TestChoice.values().toList()

    override fun setNavigationResult(choice: SingleChoiceItem<TestChoice>) {
        TODO("Not yet implemented")
    }

    override fun getTitle(): String = getString(R.string.test_choice_title)
}
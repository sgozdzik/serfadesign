package xyz.gozdzik.serfadesignexample.demochoice

import androidx.annotation.StringRes
import xyz.gozdzik.serfadesign.bottomsheets.SingleChoiceItem
import xyz.gozdzik.serfadesignexample.R

enum class TestChoice(@StringRes val displayName: Int) : SingleChoiceItem<TestChoice> {
    TEST_CHOICE_1(R.string.test_choice_1),
    TEST_CHOICE_2(R.string.test_choice_2),
    TEST_CHOICE_3(R.string.test_choice_3);

    override val displayNameResId: Int
        get() = displayName

    override val enum: Enum<TestChoice>
        get() = this

}
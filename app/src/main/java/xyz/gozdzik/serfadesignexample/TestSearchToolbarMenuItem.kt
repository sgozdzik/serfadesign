package xyz.gozdzik.serfadesignexample

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import xyz.gozdzik.serfadesign.searchtoolbar.SearchToolbarMenuItem

enum class TestSearchToolbarMenuItem(
    @StringRes val displayName: Int,
    @DrawableRes val icon: Int
) : SearchToolbarMenuItem<TestSearchToolbarMenuItem> {
    SORT(
        R.string.test_menu_sort, R.drawable.ic_sort
    ),
    DELETE(
        R.string.test_menu_delete, R.drawable.ic_delete
    ),
    FILTER(
        R.string.test_menu_filter, R.drawable.ic_filter
    );

    override val displayNameResId: Int
        get() = displayName

    override val iconResId: Int
        get() = icon

    override val enum: Enum<TestSearchToolbarMenuItem>
        get() = this
}

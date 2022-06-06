![Screenshot](https://github.com/sgozdzik/serfadesign/blob/master/screenshots/screenshot_demo_fragment.jpg?raw=true)

# Serfa Design

## About library

This library contains some useful common UI components. You can check them on example app. 

You can download apk here:

[**Download APK**](https://google.pl)

## How to use

### How to add library to your project
// Description in progress

### How to change colors
You can change default colors overriding this values:

    <color name="serfaDesignDarkAccent">#FF000000</color>
    <color name="serfaDesignPrimaryDark">#263238</color>
    <color name="serfaDesignPrimaryDark_alpha_50">#80263238</color>
    <color name="serfaDesignAccent">#FFFFFF</color>
    <color name="serfaDesignAccent_alpha_50">#80FFFFFF</color>

## Available views

### Search Menu Toolbar
![Screenshot](https://github.com/sgozdzik/serfadesign/blob/master/screenshots/screenshot_toolbar.jpg?raw=true)

This view can be used instead of default toolbar. It contains features as: search, left & right buttons, menu. 

**Methods**

* `setTitle(title: String)`
* `setSearchCallback(searchCallback: (String) -> Unit)`
* `leftButtonCallback(clickCallback: () -> Unit)`
* `rightButtonCallback(clickCallback: () -> Unit)`
* `setRightButtonIcon(iconResId: Int)`
* `setMenuButtons(menuButtons: List<SearchToolbarMenuItem<T>>, clickListener: (Enum<T>) -> Unit)`

**How to add menu**

To add menu to toolbar you need to create enum class that will implement `SearchToolbarMenuItem` (it should contain icon and string resource to display) and then call method `setMenuButtons` on SearchToolbar.

Example:

```
enum class CurrencyListMenuItem(
    @StringRes val displayName: Int,
    @DrawableRes val icon: Int
) : SearchToolbarMenuItem<CurrencyListMenuItem> {
    SORT(
        R.string.sort, R.drawable.ic_sort
    );

    override val displayNameResId: Int
        get() = displayName

    override val iconResId: Int
        get() = icon

    override val enum: Enum<CurrencyListMenuItem>
        get() = this
}
```

**XML parameters**

- `app:toolbar_title="@string/toolbar_title"` - title displayed in toolbar
- `app:right_button="@drawable/ic_menu"` - drawable for right button (if empty then it is not shown) 
- `app:show_back_button="true"` - indicates if left back button should be shown
- `app:show_search="true"` - indicates if search view should be shown

**Example usage**

```
<xyz.gozdzik.serfadesign.searchtoolbar.SearchToolbarView
android:id="@+id/search_toolbar"
android:layout_width="match_parent"
android:layout_height="wrap_content"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent"
app:show_back_button="false"
app:show_search="true"
app:toolbar_title="@string/app_name" />
```

### Loading View

This view can be used as full screen loader.

**XML parameters:**

- `app:animationRawRes="@raw/"` - json lottie animation

**Example usage:**

```
<xyz.gozdzik.serfadesign.common.LoadingView
android:layout_width="match_parent"
android:layout_height="0dp"
android:visibility="@{viewModel.isLoading().booleanValue() ? View.VISIBLE :View.INVISIBLE}"
app:animationRawRes="@raw/cryptocoins"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/search_toolbar" />
```

### Single Choice Bottom Sheet
![Screenshot](https://github.com/sgozdzik/serfadesign/blob/master/screenshots/screenshot_bottom_sheet_choice.jpg?raw=true)

This view is used when you want the user to select some single option. For example in filtering or sorting. 

**How to implement**

1. Create enum class that will implement `SingleChoiceItem` interface. It should contain resource id for string that should be displayed.

Example:

```
enum class SortParameter(@StringRes val displayName: Int) : SingleChoiceItem<SortParameter> {
    BY_NAME_ASC(R.string.sort_by_asc),
    BY_NAME_DESC(R.string.sort_by_desc),
    BY_MARKET_CAP(R.string.sort_by_market_cap);

    override val displayNameResId: Int
        get() = displayName

    override val enum: Enum<SortParameter>
        get() = this

}
```

2. Create Fragment that will extend `SortBottomSheetFragment` as base class. It should override functions below:

- `getChoiceItems()` - here you pass list of enum values that implement `SingleChoiceItem`
- `setNavigationResult(choice: SingleChoiceItem<*>)"` - this function is called after user will make a choice - you can setup navigation result in this function
- `getTitle()` - title displayed in header
- `getPreselectedItem()` - you can pass here item that was selected before by the user

Example:

```
class SortBottomSheetFragment : SingleChoiceBottomSheetFragment<SortParameter>() {

    private val args: SortBottomSheetFragmentArgs by navArgs()

    override fun getChoiceItems(): List<SingleChoiceItem<SortParameter>> = SortParameter
        .values()
        .toList()

    override fun setNavigationResult(choice: SingleChoiceItem<SortParameter>) {
        setFragmentResult(
            REQUEST_KEY, bundleOf(
                CHOICE to choice.enum
            )
        )
    }

    override fun getTitle(): String = getString(R.string.sort)

    override fun getPreselectedItem(): SingleChoiceItem<SortParameter> = args.preselectedChoiceItem

    companion object {

        val REQUEST_KEY = "SortBottomSheetRequestKey"
        val CHOICE = "Choice"

    }}
```

### Shadow Button
![Screenshot](https://github.com/sgozdzik/serfadesign/blob/master/screenshots/screenshot_button.jpg?raw=true)

SingleChoiceBottomSheetFragment

// Description in progress

**XML parameters:**

- `app:animationRawRes="@raw/"` - json lottie animation

**Example usage:**


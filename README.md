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
// Description in progress

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

// Description in progress

### Shadow Button
![Screenshot](https://github.com/sgozdzik/serfadesign/blob/master/screenshots/screenshot_button.jpg?raw=true)

// Description in progress


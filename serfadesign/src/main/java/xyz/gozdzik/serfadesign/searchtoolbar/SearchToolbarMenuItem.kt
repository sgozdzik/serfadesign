package xyz.gozdzik.serfadesign.searchtoolbar

interface SearchToolbarMenuItem<T : Enum<T>> {
    val displayNameResId: Int
    val iconResId: Int
    val enum: Enum<T>
}

package xyz.gozdzik.serfadesign.bottomsheets

interface SingleChoiceItem<T : Enum<T>> {
    val displayNameResId: Int
    val enum: Enum<T>
}
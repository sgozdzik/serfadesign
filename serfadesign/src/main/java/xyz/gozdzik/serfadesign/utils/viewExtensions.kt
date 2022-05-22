package xyz.gozdzik.serfadesign.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.addOnTextChangedListener(changedText: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int, before: Int,
            count: Int
        ) {
        }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int,
            after: Int
        ) {
        }

        override fun afterTextChanged(s: Editable) {
            changedText(s.toString())
        }
    })
}
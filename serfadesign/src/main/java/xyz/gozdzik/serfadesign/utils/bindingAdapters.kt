package xyz.gozdzik.serfadesign.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun ImageView.setResIdText(value: Int?) {
    value?.let {
        setImageResource(value)
    }
}
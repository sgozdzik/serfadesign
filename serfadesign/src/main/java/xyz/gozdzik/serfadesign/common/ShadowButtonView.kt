package xyz.gozdzik.serfadesign.common

import xyz.gozdzik.serfadesign.databinding.ViewShadowButtonBinding

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import xyz.gozdzik.serfadesign.R

class ShadowButtonView : ConstraintLayout {

    private lateinit var binding: ViewShadowButtonBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet? = null) {
        binding = ViewShadowButtonBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
        val attrs = attrs ?: return
        context.obtainStyledAttributes(attrs, R.styleable.ShadowButtonView).apply {
            if (hasValue(R.styleable.ShadowButtonView_button_title)) {
                binding.buttonTitle.text = getString(R.styleable.ShadowButtonView_button_title)
            }
            if (hasValue(R.styleable.ShadowButtonView_button_color)) {
                binding.rootView.backgroundTintList =
                    ColorStateList.valueOf(
                        getColor(R.styleable.ShadowButtonView_button_color, 0)
                    )
            }
            recycle()
        }
    }

}
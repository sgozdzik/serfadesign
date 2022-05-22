package xyz.gozdzik.serfadesign.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import xyz.gozdzik.serfadesign.R
import xyz.gozdzik.serfadesign.databinding.ViewLoadingBinding

class LoadingView : ConstraintLayout {

    private lateinit var binding: ViewLoadingBinding

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
        binding = ViewLoadingBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
        val attrs = attrs ?: return
        context.obtainStyledAttributes(attrs, R.styleable.LoadingView).apply {
            if (hasValue(R.styleable.LoadingView_animationRawRes)) {
                binding.animationView.setAnimation(
                    getResourceId(R.styleable.LoadingView_animationRawRes, 0)
                )
            }
        }
    }

}
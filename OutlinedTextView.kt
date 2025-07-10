package com.russia.common.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.russia.online.R

class OutlinedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var strokeColor: Int = Color.BLACK
    private var strokeWidth: Float = 4f

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.OutlinedTextView)
            strokeColor = a.getColor(R.styleable.OutlinedTextView_strokeColor, Color.BLACK)
            strokeWidth = a.getDimension(R.styleable.OutlinedTextView_strokeWidth, 4f)
            a.recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (strokeWidth > 0) {
            val textColor = textColors.defaultColor
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = strokeWidth
            setTextColor(strokeColor)
            super.onDraw(canvas)

            paint.style = Paint.Style.FILL
            setTextColor(textColor)
        }
        super.onDraw(canvas)
    }
}
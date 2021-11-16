package com.jmanrique.lolproject.utils.extensions

import android.content.Context
import android.util.TypedValue
import android.view.View

fun View.dpToPx(dp: Float?): Int = if(dp != null) context.dpToPx(dp) else 0

fun Context.dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
        .toInt()

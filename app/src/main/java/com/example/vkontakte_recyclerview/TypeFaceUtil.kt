package com.example.vkontakte_recyclerview

import android.content.Context
import android.graphics.Typeface

object TypeFaceUtil {
    fun overrideFont(context: Context, defaultFontNameToOverride: String?, customFontFileNameInAssets: String?) {
        try {
            val customFontTypeface = Typeface.createFromAsset(context.assets, customFontFileNameInAssets)
            val defaultFontTypefaceField = Typeface::class.java.getDeclaredField(defaultFontNameToOverride!!)
            defaultFontTypefaceField.isAccessible = true
            defaultFontTypefaceField[null] = customFontTypeface
        } catch (e: Exception) {
        }
    }
}
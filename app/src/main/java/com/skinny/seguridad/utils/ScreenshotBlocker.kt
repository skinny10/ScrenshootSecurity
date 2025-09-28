package com.skinny.seguridad.utils

import android.app.Activity
import android.view.WindowManager

object ScreenshotBlocker {

    /**
     * Bloquea la captura de pantalla para la actividad actual
     */
    fun blockScreenshot(activity: Activity) {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )


    }

    /**
     * Permite la captura de pantalla (para el login)
     */
    fun allowScreenshot(activity: Activity) {
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}
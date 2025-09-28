package com.skinny.seguridad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skinny.seguridad.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Redirigir directamente al login
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
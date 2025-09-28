package com.skinny.seguridad.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.skinny.seguridad.R
import com.skinny.seguridad.ui.login.LoginActivity
import com.skinny.seguridad.ui.profile.ProfileActivity
import com.skinny.seguridad.utils.ScreenshotBlocker

class HomeActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var btnProfile: MaterialButton
    private lateinit var btnLogout: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // BLOQUEAR CAPTURAS DE PANTALLA
        ScreenshotBlocker.blockScreenshot(this)

        // Inicializar vistas
        initViews()

        // Configurar datos
        setupUserData()

        // Configurar eventos
        setupClickListeners()
    }

    private fun initViews() {
        tvWelcome = findViewById(R.id.tvWelcome)
        btnProfile = findViewById(R.id.btnProfile)
        btnLogout = findViewById(R.id.btnLogout)
    }

    private fun setupUserData() {
        val username = intent.getStringExtra("USERNAME") ?: "Usuario"
        tvWelcome.text = "¡Hola $username!"
    }

    private fun setupClickListeners() {
        btnProfile.setOnClickListener {
            navigateToProfile()
        }

        btnLogout.setOnClickListener {
            performLogout()
        }
    }

    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("USERNAME", intent.getStringExtra("USERNAME"))
        startActivity(intent)
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
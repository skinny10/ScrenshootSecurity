package com.skinny.seguridad.ui.profile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.skinny.seguridad.R
import com.skinny.seguridad.utils.ScreenshotBlocker

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvUsername: TextView
    private lateinit var btnBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

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
        tvUsername = findViewById(R.id.tvUsername)
        btnBack = findViewById(R.id.btnBack)
    }

    private fun setupUserData() {
        val username = intent.getStringExtra("USERNAME") ?: "Usuario"
        tvUsername.text = "Usuario: $username"
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }
}
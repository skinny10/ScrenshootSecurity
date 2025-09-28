package com.skinny.seguridad.models

data class User(
    val username: String,
    val email: String,
    val isLoggedIn: Boolean = false
)
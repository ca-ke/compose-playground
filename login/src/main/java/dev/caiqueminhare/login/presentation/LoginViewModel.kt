package dev.caiqueminhare.login.presentation

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun onTextChanged(typedText: String, textFieldType: String) {
        when (textFieldType) {
            "login" -> {
            }
            "password" -> {
            }
            else -> throw NoSuchFieldException(textFieldType)
        }
    }

}
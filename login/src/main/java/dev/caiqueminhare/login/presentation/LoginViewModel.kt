package dev.caiqueminhare.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var _passwordFieldState = MutableLiveData("")
    val passwordFieldState: LiveData<String> = _passwordFieldState

    private var _userFieldState = MutableLiveData("")
    val userFieldState: LiveData<String> = _userFieldState

    private var _userFieldErrorState = MutableLiveData(false)
    val userFieldErrorState: LiveData<Boolean> = _userFieldErrorState

    private var _passwordFieldErrorState = MutableLiveData(false)
    val passwordFieldErrorState: LiveData<Boolean> = _passwordFieldErrorState


    fun doLogin() {
        when {
            _passwordFieldState.value.isNullOrBlank() -> _passwordFieldErrorState.value = true
            _userFieldState.value.isNullOrBlank() -> _userFieldErrorState.value = true
            else -> println("Deu bom")
        }
    }

    fun onTextChanged(typedText: String, textFieldType: String) {
        when (textFieldType) {
            "user" -> {
                if(!typedText.isNullOrEmpty()) {
                    _userFieldErrorState.value = false
                }
                _userFieldState.value = typedText
            }
            "password" -> {
                if(!typedText.isNullOrEmpty()) {
                    _passwordFieldErrorState.value = false
                }
                _passwordFieldState.value = typedText
            }
            else -> throw NoSuchFieldException(textFieldType)
        }
    }

}
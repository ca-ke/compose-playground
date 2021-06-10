package dev.caiqueminhare.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.caiqueminhare.login.domain.model.ButtonState
import kotlinx.coroutines.launch
import java.util.*

class LoginViewModel : ViewModel() {
    private var _passwordFieldState = MutableLiveData("")
    val passwordFieldState: LiveData<String> = _passwordFieldState

    private var _userFieldState = MutableLiveData("")
    val userFieldState: LiveData<String> = _userFieldState

    private var _userFieldErrorState = MutableLiveData(false)
    val userFieldErrorState: LiveData<Boolean> = _userFieldErrorState

    private var _passwordFieldErrorState = MutableLiveData(false)
    val passwordFieldErrorState: LiveData<Boolean> = _passwordFieldErrorState

    private var _buttonState: MutableLiveData<ButtonState> = MutableLiveData(ButtonState.Enabled)
    val buttonState: LiveData<ButtonState> = _buttonState


    fun doLogin() {
        when {
            _passwordFieldState.value.isNullOrBlank() -> _passwordFieldErrorState.value = true
            _userFieldState.value.isNullOrBlank() -> _userFieldErrorState.value = true
            else -> {
                viewModelScope.launch {
                    val timer = Timer()
                    timer.schedule(object : TimerTask() {
                        var counter = 0f

                        override fun run() {
                            if (counter == 50f) {
                                _buttonState.postValue(ButtonState.Enabled)
                                counter = 0f
                                timer.cancel()
                            } else {
                                counter++
                                _buttonState.postValue(ButtonState.Loading)
                            }
                        }
                    }, 1, 100)
                }
            }
        }
    }

    fun onTextChanged(typedText: String, textFieldType: String) {
        when (textFieldType) {
            "user" -> {
                if (!typedText.isNullOrEmpty()) {
                    _userFieldErrorState.value = false
                }
                _userFieldState.value = typedText
            }
            "password" -> {
                if (!typedText.isNullOrEmpty()) {
                    _passwordFieldErrorState.value = false
                }
                _passwordFieldState.value = typedText
            }
            else -> throw NoSuchFieldException(textFieldType)
        }
    }

}
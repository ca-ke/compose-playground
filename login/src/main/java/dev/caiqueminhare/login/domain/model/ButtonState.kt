package dev.caiqueminhare.login.domain.model

sealed class ButtonState {
    object Enabled : ButtonState()
    object Loading : ButtonState()
}
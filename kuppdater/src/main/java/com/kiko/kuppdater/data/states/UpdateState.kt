package com.kiko.kuppdater.data.states

sealed class UpdateState {
    object UpdateSuccess : UpdateState()
    object UpdateLoading : UpdateState()
    data class UpdateFailed(val errorMsg: String) : UpdateState()
}
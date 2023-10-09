package com.kiko.kuppdater.data.states

data class UpdateSheetFailedState(
    val dialogTitle: String,
    val dialogContent: String,
    val dialogRetryButton: String,
    val dialogExitButton: String,
    val dialogOkButton: String,
)


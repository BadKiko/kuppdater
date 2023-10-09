package com.kiko.kuppdater.data.states

data class UpdateSheetState(
    val descriptionState: UpdateSheetDescriptionState,
    val loadingState: UpdateSheetLoadingState,
    val failedState: UpdateSheetFailedState
)


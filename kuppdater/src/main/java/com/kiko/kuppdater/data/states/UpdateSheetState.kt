package com.kiko.kuppdater.data.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kiko.kuppdater.ui.sheet.UpdateSheet

data class UpdateSheetState(
    val descriptionState: UpdateSheetDescriptionState,
    val loadingState: UpdateSheetLoadingState,
    val failedState: UpdateSheetFailedState
)


@Composable
fun rememberUpdateSheet(
    descriptionState: UpdateSheetDescriptionState = rememberUpdateSheetDescription(),
    loadingState: UpdateSheetLoadingState = rememberUpdateSheetLoading(),
    failedState: UpdateSheetFailedState = rememberUpdateSheetFail()
): UpdateSheetState {
    return remember(
        descriptionState, loadingState, failedState
    ) {
        UpdateSheetState(
            descriptionState, loadingState, failedState
        )
    }
}
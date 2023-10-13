package com.kiko.kuppdater.data.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kiko.kuppdater.ui.sheet.UpdateSheet

data class UpdateSheetState(
    val url: String,
    val descriptionState: UpdateSheetDescriptionState,
    val loadingState: UpdateSheetLoadingState,
    val failedState: UpdateSheetFailedState,
)


@Composable
fun rememberUpdateSheet(
    jsonUrl: String,
    descriptionState: UpdateSheetDescriptionState = rememberUpdateSheetDescription(),
    loadingState: UpdateSheetLoadingState = rememberUpdateSheetLoading(),
    failedState: UpdateSheetFailedState = rememberUpdateSheetFail()
): UpdateSheetState {
    return remember(
        descriptionState, loadingState, failedState
    ) {
        UpdateSheetState(
            jsonUrl, descriptionState, loadingState, failedState
        )
    }
}
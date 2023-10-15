package com.kiko.kuppdater.data.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

data class UpdateSheetLoadingState(
    val dialogTitle: String,
    val dialogContent: String
)

@Composable
fun rememberUpdateSheetLoading(
    dialogTitle: String = "Установка",
    dialogContent: String = "Производится установка"
): UpdateSheetLoadingState {
    return remember(
        dialogTitle,
        dialogContent
    ) {
        UpdateSheetLoadingState(
            dialogTitle,
            dialogContent
        )
    }
}
package com.kiko.kuppdater.data.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

data class UpdateSheetFailedState(
    val dialogTitle: String,
    val dialogContent: String,
    val dialogRetryButton: String,
    val dialogCancelButton: String,
    val isRetrieving: Boolean,
    val isCancelable: Boolean
)

@Composable
fun rememberUpdateSheetFail(
    dialogTitle: String = "Не удалось установить",
    dialogContent: String = "Список изменений:",
    dialogRetryButton: String = "Повторить",
    dialogCancelButton: String = "Отмена",
    isRetrieving: Boolean = false,
    isCancelable: Boolean = false
): UpdateSheetFailedState {
    return remember(
        dialogTitle,
        dialogContent,
        dialogRetryButton,
        dialogCancelButton,
        isRetrieving,
        isCancelable
    ) {
        UpdateSheetFailedState(
            dialogTitle,
            dialogContent,
            dialogRetryButton,
            dialogCancelButton,
            isRetrieving,
            isCancelable
        )
    }
}
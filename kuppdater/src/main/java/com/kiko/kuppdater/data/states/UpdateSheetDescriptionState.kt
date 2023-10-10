package com.kiko.kuppdater.data.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

data class UpdateSheetDescriptionState(
    val dialogTitle: String,
    val dialogContent: String,
    val dialogInstallButton: String,
    val dialogCancelButton: String,
    val isCancelable: Boolean
)

@Composable
fun rememberUpdateSheetDescription(
    dialogTitle: String = "Обновление",
    dialogContent: String = "Список изменений:",
    dialogInstallButton: String = "Установить",
    dialogCancelButton: String = "Отмена",
    isCancelable: Boolean = false
): UpdateSheetDescriptionState {
    return remember(
        dialogTitle,
        dialogContent,
        dialogInstallButton,
        dialogCancelButton,
        isCancelable
    ) {
        UpdateSheetDescriptionState(
            dialogTitle,
            dialogContent,
            dialogInstallButton,
            dialogCancelButton,
            isCancelable
        )
    }
}
package com.kiko.kuppdater.ui.sheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kiko.kuppdater.data.states.UpdateSheetState
import com.kiko.kuppdater.data.states.UpdateState
import com.kiko.kuppdater.data.states.rememberUpdateSheetDescription
import com.kiko.kuppdater.ui.viewmodel.UpdateSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateSheet(
    updateSheetState: UpdateSheetState,
    updateSheetViewModel: UpdateSheetViewModel = UpdateSheetViewModel()
) {
    val context = LocalContext.current
    updateSheetViewModel.getUpdateData(updateSheetState.url, context)

    if (updateSheetViewModel.needUpdate) {
        AlertDialog(onDismissRequest = {}) {
            Card(
                shape = RoundedCornerShape(
                    16.dp
                )
            ) {
                when (updateSheetViewModel.updateState) {
                    is UpdateState.UpdateFailed -> UpdateDescriptionSheet(
                        updateSheetDescriptionState = rememberUpdateSheetDescription(
                            dialogTitle = "Ошибка",
                            dialogContent = (updateSheetViewModel.updateState as UpdateState.UpdateFailed).errorMsg,
                            dialogInstallButton = "Ок",
                        ),
                        onClickInstall = {
                            updateSheetViewModel.updateSheetState(UpdateState.UpdateIdle)
                        }
                    )

                    UpdateState.UpdateIdle -> UpdateDescriptionSheet(
                        updateSheetDescriptionState = updateSheetState.descriptionState.copy(
                            dialogContent = updateSheetState.descriptionState.dialogContent + "\n\n${
                                updateSheetViewModel.updateJsonEntity.releaseNotes.joinToString("\n")
                            }"
                        ),
                        onClickInstall = {
                            updateSheetViewModel.updateSheetState(UpdateState.UpdateLoading)

                            updateSheetViewModel.downloadApk(
                                updateSheetViewModel.updateJsonEntity.url,
                                context
                            )

                        })

                    UpdateState.UpdateLoading -> UpdateProcessSheet(
                        updateSheetLoadingState = updateSheetState.loadingState,
                        updateSheetViewModel.downloadProgress
                    )

                    is UpdateState.UpdateSuccess -> UpdateInstallingSheet(updateSheetLoadingState = updateSheetState.loadingState)
                }
            }
        }
    }
}


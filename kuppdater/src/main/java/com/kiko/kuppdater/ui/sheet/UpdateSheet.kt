package com.kiko.kuppdater.ui.sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kiko.kuppdater.data.states.UpdateSheetState
import com.kiko.kuppdater.data.states.UpdateState
import com.kiko.kuppdater.data.states.rememberUpdateSheet
import com.kiko.kuppdater.data.states.rememberUpdateSheetLoading
import com.kiko.kuppdater.ui.viewmodel.UpdateSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateSheet(
    updateSheetState: UpdateSheetState,
    updateSheetViewModel: UpdateSheetViewModel = hiltViewModel()
) {
    updateSheetViewModel.getUpdateData(updateSheetState.url) {

    }

    AlertDialog(onDismissRequest = {}) {
        Card(
            shape = RoundedCornerShape(
                16.dp
            )
        ) {
            if (updateSheetViewModel.updateState is UpdateState.UpdateIdle) {
                UpdateDescriptionSheet(updateSheetState.descriptionState)
            }
        }
    }
}


package com.kiko.kuppdater.ui.sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.kiko.kuppdater.data.states.UpdateSheetState
import com.kiko.kuppdater.data.states.UpdateState
import com.kiko.kuppdater.data.states.rememberUpdateSheet
import com.kiko.kuppdater.data.states.rememberUpdateSheetLoading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateSheet(updateSheetState: UpdateSheetState) {
    var updateState by remember { mutableStateOf(UpdateState.UpdateIdle) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.5f)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        ) {
            if (updateState is UpdateState.UpdateIdle) {
                UpdateDescriptionSheet(updateSheetState.descriptionState)
            }
        }
    }
}


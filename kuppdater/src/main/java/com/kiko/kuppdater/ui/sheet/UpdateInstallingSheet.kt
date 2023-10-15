package com.kiko.kuppdater.ui.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kiko.kuppdater.data.states.UpdateSheetLoadingState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateInstallingSheet(updateSheetLoadingState: UpdateSheetLoadingState) {
    Column(
        modifier = Modifier.padding(16.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(updateSheetLoadingState.dialogTitle, style = MaterialTheme.typography.titleLarge)
        Text(updateSheetLoadingState.dialogContent)
        Spacer(modifier = Modifier.padding(16.dp))
        LinearProgressIndicator(modifier = Modifier.padding(24.dp, 0.dp))
    }
}
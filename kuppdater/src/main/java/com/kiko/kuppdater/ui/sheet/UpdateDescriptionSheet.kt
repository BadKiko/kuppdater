package com.kiko.kuppdater.ui.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiko.kuppdater.data.states.UpdateSheetDescriptionState
import com.kiko.kuppdater.data.states.rememberUpdateSheetDescription

@Composable
fun UpdateDescriptionSheet(updateSheetDescriptionState: UpdateSheetDescriptionState) {
    Column(
        modifier = Modifier.padding(16.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(updateSheetDescriptionState.dialogTitle, style = MaterialTheme.typography.titleLarge)
        Text(updateSheetDescriptionState.dialogContent)
        Spacer(modifier = Modifier.padding(8.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            if (updateSheetDescriptionState.isCancelable) {
                Button(modifier = Modifier.weight(1f), onClick = {}) {
                    Text(updateSheetDescriptionState.dialogCancelButton)
                }
            }

            Button(modifier = Modifier.weight(1f), onClick = {}) {
                Text(updateSheetDescriptionState.dialogInstallButton)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpdateDescriptionSheetPreview() {
    UpdateDescriptionSheet(updateSheetDescriptionState = rememberUpdateSheetDescription())
}

@Preview(showBackground = true)
@Composable
fun UpdateDescriptionSheetPreviewCancable() {
    UpdateDescriptionSheet(updateSheetDescriptionState = rememberUpdateSheetDescription(isCancelable = true))
}
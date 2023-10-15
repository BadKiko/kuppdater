package com.kiko.kuppdater.data.states

import com.kiko.kuppdater.domain.update.json.entity.UpdateJsonEntity

internal sealed class UpdateState {
    data class UpdateSuccess(val updatedJson: UpdateJsonEntity) : UpdateState()
    object UpdateIdle : UpdateState()
    object UpdateLoading : UpdateState()
    data class UpdateFailed(val errorMsg: String) : UpdateState()
}
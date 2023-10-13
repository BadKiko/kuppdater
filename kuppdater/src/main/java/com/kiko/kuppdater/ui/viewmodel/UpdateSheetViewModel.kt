package com.kiko.kuppdater.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiko.kuppdater.data.states.UpdateState
import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.kiko.kuppdater.domain.update.json.entity.UpdateJsonEntity
import com.kiko.kuppdater.domain.update.json.repository.UpdateJsonRepository
import com.kiko.kuppdater.domain.update.json.usecase.UpdateJsonUseCase
import com.skydoves.sandwich.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class UpdateSheetViewModel @Inject constructor() : ViewModel() {
    var updateState by mutableStateOf<UpdateState>(UpdateState.UpdateIdle)
        private set

    fun getUpdateData(url: String, onSuccess: (UpdateJsonEntity) -> Unit) {
       /* viewModelScope.launch {

            updateState = UpdateState.UpdateLoading

            UpdateJsonUseCase(updateJsonRepository).getUpdateData(url).collect { response ->
                when (response) {
                    is ApiResponse.Failure -> TODO()
                    is ApiResponse.Success -> {
                        response.data.let {
                            onSuccess(
                                UpdateJsonEntity(
                                    it.latestVersion,
                                    it.latestVersionCode,
                                    it.url,
                                    it.releaseNotes
                                )
                            )
                        }
                    }
                }
            }
        }*/
    }
}
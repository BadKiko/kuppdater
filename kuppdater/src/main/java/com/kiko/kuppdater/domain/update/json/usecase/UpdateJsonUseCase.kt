package com.kiko.kuppdater.domain.update.json.usecase

import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.kiko.kuppdater.domain.update.json.repository.UpdateJsonRepository
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateJsonUseCase @Inject constructor(private val updateJsonRepository: UpdateJsonRepository) {
    fun getUpdateData(url:String): Flow<ApiResponse<UpdateJsonResponse>> {
        return updateJsonRepository.getUpdate(url)
    }
}
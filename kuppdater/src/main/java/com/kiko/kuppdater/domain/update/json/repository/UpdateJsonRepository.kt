package com.kiko.kuppdater.domain.update.json.repository

import com.kiko.kuppdater.data.update.json.remote.api.UpdateJsonApi
import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

internal interface UpdateJsonRepository {
    fun getUpdate(url: String, updateJsonApi: UpdateJsonApi) : Flow<ApiResponse<UpdateJsonResponse>>
}
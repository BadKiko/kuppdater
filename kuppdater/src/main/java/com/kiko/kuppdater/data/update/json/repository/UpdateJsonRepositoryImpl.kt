package com.kiko.kuppdater.data.update.json.repository

import com.kiko.kuppdater.data.update.json.remote.api.UpdateJsonApi
import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.kiko.kuppdater.domain.update.json.repository.UpdateJsonRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UpdateJsonRepositoryImpl :
    UpdateJsonRepository {
    override fun getUpdate(url: String, updateJsonApi: UpdateJsonApi): Flow<ApiResponse<UpdateJsonResponse>> {
        return flow {
            emit(suspendCoroutine { continuation ->
                updateJsonApi.getUpdateJsonApi(url.substringAfterLast("/")).request {
                    continuation.resume(it)
                }
            })
        }
    }
}
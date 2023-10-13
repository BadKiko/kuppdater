package com.kiko.kuppdater.data.update.json.repository

import com.kiko.kuppdater.data.update.json.remote.api.UpdateJsonApi
import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.kiko.kuppdater.domain.update.json.entity.UpdateJsonEntity
import com.kiko.kuppdater.domain.update.json.repository.UpdateJsonRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UpdateJsonRepositoryImpl @Inject constructor(private val updateJsonApi: UpdateJsonApi) :
    UpdateJsonRepository {
    override fun getUpdate(url: String): Flow<ApiResponse<UpdateJsonResponse>> {
        return flow {
            emit(suspendCoroutine { continuation ->
                updateJsonApi.getUpdateJsonApi(url).request {
                    continuation.resume(it)
                }
            })
        }
    }
}
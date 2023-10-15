package com.kiko.kuppdater.domain.update.json.usecase

import com.kiko.kuppdater.data.update.json.remote.api.UpdateJsonApi
import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import com.kiko.kuppdater.data.update.json.repository.UpdateJsonRepositoryImpl
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UpdateJsonUseCase {
    fun getUpdateData(url: String): Flow<ApiResponse<UpdateJsonResponse>> {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(url.substringBeforeLast("/"))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()

        val api = retrofit.create(UpdateJsonApi::class.java)
        return UpdateJsonRepositoryImpl().getUpdate(url, api)
    }
}
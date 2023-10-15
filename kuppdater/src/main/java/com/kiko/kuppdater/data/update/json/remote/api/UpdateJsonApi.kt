package com.kiko.kuppdater.data.update.json.remote.api

import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

internal interface UpdateJsonApi {
    @GET
    fun getUpdateJsonApi(@Url url: String): Call<UpdateJsonResponse>
}
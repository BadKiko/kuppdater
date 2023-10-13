package com.kiko.kuppdater.data.update.json.remote.api

import com.kiko.kuppdater.data.update.json.remote.dto.UpdateJsonResponse
import retrofit2.Call
import retrofit2.http.GET

interface UpdateJsonApi {
    @GET("article/getallarticles")
    fun getUpdateJsonApi(): Call<UpdateJsonResponse>
}
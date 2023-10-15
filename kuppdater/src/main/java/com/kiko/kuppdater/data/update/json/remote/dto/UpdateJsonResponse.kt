package com.kiko.kuppdater.data.update.json.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class UpdateJsonResponse(
    @Json val latestVersion: String,
    @Json val latestVersionCode: Long,
    @Json val url: String,
    @Json val releaseNotes: List<String>,
)

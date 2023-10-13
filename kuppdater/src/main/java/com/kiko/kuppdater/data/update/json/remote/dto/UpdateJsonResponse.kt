package com.kiko.kuppdater.data.update.json.remote.dto

import com.squareup.moshi.Json

@Json
data class UpdateJsonResponse(
    val latestVersion: String,
    val latestVersionCode: Long,
    val url: String,
    val releaseNotes: List<String>,
)

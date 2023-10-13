package com.kiko.kuppdater.data.update.json.remote.dto

data class UpdateJsonResponse(
    val latestVersion: String,
    val latestVersionCode: Long,
    val url: String,
    val releaseNotes: List<String>,
)

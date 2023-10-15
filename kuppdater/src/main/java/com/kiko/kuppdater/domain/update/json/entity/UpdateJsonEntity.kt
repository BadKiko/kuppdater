package com.kiko.kuppdater.domain.update.json.entity

data class UpdateJsonEntity(
    val latestVersion: String,
    val latestVersionCode: Long,
    val url: String,
    val releaseNotes: List<String>,
)
{
    companion object{
        fun create() : UpdateJsonEntity{
            return UpdateJsonEntity("", 0L, "", listOf(""))
        }
    }
}
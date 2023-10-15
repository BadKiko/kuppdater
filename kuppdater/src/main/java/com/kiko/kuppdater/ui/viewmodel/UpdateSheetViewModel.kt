package com.kiko.kuppdater.ui.viewmodel

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdownloader.KDownloader
import com.kiko.kuppdater.data.states.UpdateState
import com.kiko.kuppdater.domain.update.json.entity.UpdateJsonEntity
import com.kiko.kuppdater.domain.update.json.usecase.UpdateJsonUseCase
import com.kiko.kuppdater.utils.ApkInstaller
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import kotlinx.coroutines.launch
import java.io.File


class UpdateSheetViewModel() : ViewModel() {
    var updateState by mutableStateOf<UpdateState>(UpdateState.UpdateIdle)
        private set

    var downloadProgress by mutableFloatStateOf(0f)
        private set

    var updateJsonEntity = UpdateJsonEntity.create()

    fun getUpdateData(url: String, context: Context) {
        viewModelScope.launch {

            updateState = UpdateState.UpdateLoading

            UpdateJsonUseCase().getUpdateData(url).collect { response ->
                when (response) {
                    is ApiResponse.Failure -> {
                        updateState = UpdateState.UpdateFailed(response.message())
                    }

                    is ApiResponse.Success -> {
                        downloadApk(response.data.url, context)
                        response.data.let {
                            updateJsonEntity = UpdateJsonEntity(
                                it.latestVersion, it.latestVersionCode, it.url, it.releaseNotes
                            )
                        }
                    }
                }
            }
        }
    }

    private fun downloadApk(url: String, context: Context) {
        val kDownloader = KDownloader.create(context)
        val file =
            File(
                context.externalCacheDir!!.path, url.substringAfterLast("/")
            )

        val downloadRequest = kDownloader.newRequestBuilder(
            url, context.externalCacheDir!!.path, url.substringAfterLast("/")
        ).build()

        kDownloader.enqueue(downloadRequest, onProgress = {
            downloadProgress = it.toFloat() / 100
        }, onCompleted = {
            updateState = UpdateState.UpdateSuccess(updateJsonEntity)

            ApkInstaller.installApplication(context, file)
        }, onError = { UpdateState.UpdateFailed(it) })
    }
}
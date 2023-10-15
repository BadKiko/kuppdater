package com.kiko.kuppdater.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File


internal object ApkInstaller {
    fun installApplication(context: Context, file: File) {
        val fileUri = FileProvider.getUriForFile(
            context,
            context.packageName + ".provider", file
        )
        val intent = Intent(Intent.ACTION_VIEW, fileUri)
        intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true)
        intent.setDataAndType(
            fileUri,
            "application/vnd.android" + ".package-archive"
        )
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(intent)
    }
}
package com.tattoshaman.core.utils

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import java.io.File
import java.util.UUID

class FileManager(private val applicationContext: Context) {

    fun copyFileToStorage(
        oldUri: Uri,
        filename: String = UUID.randomUUID().toString()
    ): Uri {
        val fileName = "$filename.${getExtension(oldUri)}"
        val file = File(applicationContext.filesDir, fileName)

        applicationContext.contentResolver.openInputStream(oldUri).use { inputStream ->
            if (inputStream != null) {
                val imageBytes = ByteArray(inputStream.available())
                inputStream.buffered().read(imageBytes)

                file.outputStream().use { outputStream ->
                    outputStream.write(imageBytes)
                }
            } else {
                throw Exception("")
            }
        }

        //val uri = FileProvider.getUriForFile(applicationContext, getProviderAuthority(applicationContext), file)
        return file.toUri()
    }

    private fun getExtension(sourceUri: Uri): String {
        val contentResolver = applicationContext.contentResolver
        val typeUri = contentResolver.getType(sourceUri)
        var extension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(typeUri)

        if (extension.isNullOrEmpty()) {
            val cursor = contentResolver.query(
                sourceUri,
                arrayOf(MediaStore.MediaColumns.DISPLAY_NAME),
                null,
                null,
                null
            )

            try {
                if (cursor != null && cursor.moveToFirst()) {
                    val displayNameIndex =
                        cursor.getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME)
                    val displayName = cursor.getString(displayNameIndex)

                    extension = displayName.split(".").last()
                }
            } finally {
                cursor?.close()
            }
        }

        if (extension != null) {
            return extension
        }

        throw Exception("Extension not found")
    }

    companion object{
        fun getProviderAuthority(context: Context): String{
            return context.packageName + ".sketchesProvider"
        }
    }
}
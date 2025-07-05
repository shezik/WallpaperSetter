package com.shezik.wallpapersetter

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class WallpaperUtils {

    companion object {
        fun handleSharedImage(context: Context, intent: Intent, wallpaperFlag: Int) {
            if (intent.action != Intent.ACTION_SEND)
                return

            if (intent.type?.startsWith("image/") == true) {
                (intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM))?.let { imageUri ->
                    var inputStream: java.io.InputStream? = null
                    try {
                        inputStream = context.contentResolver.openInputStream(imageUri)
                        val wallpaperManager = WallpaperManager.getInstance(context)
                        wallpaperManager.setStream(inputStream, null, true, wallpaperFlag)

                        Toast.makeText(context, if (wallpaperFlag == WallpaperManager.FLAG_SYSTEM)
                            context.getString(R.string.image_set_as_desktop_wallpaper)
                            else context.getString(R.string.image_set_as_lockscreen_wallpaper), Toast.LENGTH_SHORT).show()

                    } catch (e: java.io.IOException) {
                        e.printStackTrace()
                        Toast.makeText(context,
                            context.getString(R.string.failed_to_set_wallpaper, e.message), Toast.LENGTH_LONG).show()
                    } catch (e: SecurityException) {
                        e.printStackTrace()
                        Toast.makeText(context,
                            context.getString(R.string.permission_denied_to_set_wallpaper, e.message), Toast.LENGTH_LONG).show()
                    } finally {
                        inputStream?.close()
                    }
                } ?: run {
                    Toast.makeText(context,
                        context.getString(R.string.no_uri_found_in_intent), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context,
                    context.getString(R.string.unsupported_mime_type, intent.type), Toast.LENGTH_LONG).show()
            }
        }
    }
}
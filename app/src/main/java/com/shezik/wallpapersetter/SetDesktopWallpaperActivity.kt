package com.shezik.wallpapersetter

import android.app.Activity
import android.app.WallpaperManager
import android.os.Bundle

class SetDesktopWallpaperActivity : Activity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        WallpaperUtils.handleSharedImage(this, intent, WallpaperManager.FLAG_SYSTEM)
        finish()
    }
}
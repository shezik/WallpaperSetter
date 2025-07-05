package com.shezik.wallpapersetter

import android.app.Activity
import android.app.WallpaperManager
import android.os.Bundle

class SetLockscreenWallpaperActivity : Activity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        WallpaperUtils.handleSharedImage(this, intent, WallpaperManager.FLAG_LOCK)
        finish()
    }
}
package com.mpconnection.app

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.util.concurrent.TimeUnit

object ConfigSync {
    private const val CONFIG_URL = "https://raw.githubusercontent.com/MPconnection/clash_config/main/clash_auto.yaml"
    private const val CACHE_FILENAME = "clash_config.yaml"
    private const val SYNC_INTERVAL_HOURS = 24L

    private val client = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .build()

    fun shouldSync(context: Context): Boolean {
        val prefs = context.getSharedPreferences("sync", Context.MODE_PRIVATE)
        val lastSync = prefs.getLong("last_sync", 0L)
        val now = System.currentTimeMillis()
        return now - lastSync > SYNC_INTERVAL_HOURS * 60 * 60 * 1000
    }

    fun downloadAndCacheConfig(context: Context): Boolean {
        return try {
            val request = Request.Builder().url(CONFIG_URL).build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val configText = response.body?.string() ?: return false
                val file = File(context.filesDir, CACHE_FILENAME)
                file.writeText(configText)

                val prefs = context.getSharedPreferences("sync", Context.MODE_PRIVATE)
                prefs.edit().putLong("last_sync", System.currentTimeMillis()).apply()
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    fun getCachedConfig(context: Context): String? {
        val file = File(context.filesDir, CACHE_FILENAME)
        return if (file.exists()) file.readText() else null
    }
}

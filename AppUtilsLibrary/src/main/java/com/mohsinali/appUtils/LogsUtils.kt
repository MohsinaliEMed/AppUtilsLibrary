package com.mohsinali.appUtils

import android.content.Context
import android.util.Log
import android.widget.Toast


object LogsUtils {
    private const val DEFAULT_LOG_TAG = "@***@***@"

    fun showError(string: String, buildType: String) {
        if (buildType.equals("DEBUG", ignoreCase = true)) {
            Log.e(DEFAULT_LOG_TAG, string)
        }
    }

    fun showError(string: String, logTag: String, buildType: String) {
        if (buildType.equals("DEBUG", ignoreCase = true)) {
            Log.e(logTag, string)
        }
    }

    fun showError(string: Int, buildType: String) {
        if (buildType.equals("DEBUG", ignoreCase = true)) {
            Log.e(DEFAULT_LOG_TAG, string.toString())
        }
    }

    fun showToast(context: Context, string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

}

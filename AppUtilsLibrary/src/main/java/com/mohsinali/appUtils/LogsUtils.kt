package com.mohsinali.appUtils

import android.content.Context
import android.util.Log
import android.widget.Toast


object LogsUtils {
    private const val MY_LOG_TAG = "@***@***@"

    fun showError(string: String) {
        if (BuildConfig.DEBUG) {
            Log.e(MY_LOG_TAG, string)
        }
    }

    fun showError(string: Int) {
        if (BuildConfig.DEBUG) {
            Log.e(MY_LOG_TAG, string.toString())
        }
    }

    fun showToast(context: Context, string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

}

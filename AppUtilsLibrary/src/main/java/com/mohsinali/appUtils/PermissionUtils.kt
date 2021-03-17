package com.mohsinali.appUtils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {
    val mPermissionArrayCameraGallery = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    fun hasCameraAndStoragePermissions(context: Context, requestCode: Int): Boolean {
        val permissionCamera: Int = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
        val permissionWriteExternal: Int =
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionReadExternal: Int =
                ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)

        val listPermissionsNeeded = ArrayList<String>()
        if (permissionWriteExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (permissionReadExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(context as Activity,
                    listPermissionsNeeded.toArray(arrayOf(listPermissionsNeeded.size.toString())), requestCode)
            return false
        }
        return true
    }

    fun hasAudioPermissions(context: Context, requestCode: Int): Boolean {
        val permissionAudio: Int = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
        val permissionWriteExternal: Int =
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionReadExternal: Int =
                ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)

        val listPermissionsNeeded = ArrayList<String>()
        if (permissionWriteExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (permissionAudio != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECORD_AUDIO)
        }
        if (permissionReadExternal != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(context as Activity,
                    listPermissionsNeeded.toArray(arrayOf(listPermissionsNeeded.size.toString())), requestCode)
            return false
        }
        return true
    }

    fun isAllPermissionsGranted(grantResults: IntArray): Boolean {
        for (grantResult in grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun shouldShowAnyRequestPermissionRationale(activity: Activity, permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                return true
            }
        }
        return false
    }
}
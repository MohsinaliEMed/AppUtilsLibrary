package com.mohsinali.appUtils

import android.widget.EditText

fun showEditTextCursor(editText: EditText) {
    editText.isCursorVisible = true
    editText.requestFocus()
}
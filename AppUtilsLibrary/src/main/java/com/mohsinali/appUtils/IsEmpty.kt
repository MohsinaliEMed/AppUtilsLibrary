package com.mohsinali.appUtils

import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView


fun isEmpty(textView: TextView, stringValue: String) {
    textView.text = if (!TextUtils.isEmpty(stringValue)) stringValue else ""
    textView.visibility = if (!TextUtils.isEmpty(stringValue)) View.VISIBLE else View.GONE
}

fun isEmpty(stringValue: String?): String {
    return if (!TextUtils.isEmpty(stringValue)) stringValue!! else ""
}

fun isEmptyGone(textView: TextView, stringValue: String) {
    textView.text = if (!TextUtils.isEmpty(stringValue)) stringValue else ""
    textView.visibility = if (!TextUtils.isEmpty(stringValue)) View.VISIBLE else View.GONE
}

fun isEmptyInvisible(textView: TextView, stringValue: String) {
    textView.text = if (!TextUtils.isEmpty(stringValue)) stringValue else ""
    textView.visibility = if (!TextUtils.isEmpty(stringValue)) View.VISIBLE else View.INVISIBLE
}

fun isEmptyViewGone(textView: TextView, stringValue: String, ll: LinearLayout) {
    textView.text = if (!TextUtils.isEmpty(stringValue)) stringValue else ""
    ll.visibility = if (!TextUtils.isEmpty(stringValue)) View.VISIBLE else View.GONE
}

fun isEmptyViewInvisible(textView: TextView, stringValue: String, ll: LinearLayout) {
    textView.text = if (!TextUtils.isEmpty(stringValue)) stringValue else ""
    ll.visibility = if (!TextUtils.isEmpty(stringValue)) View.VISIBLE else View.GONE
}
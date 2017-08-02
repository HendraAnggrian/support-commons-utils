package com.hendraanggrian.kota.view

import android.app.Activity
import android.content.Context
import android.os.ResultReceiver
import android.view.inputmethod.InputMethodManager
import com.hendraanggrian.kota.annotation.InputHideFlags
import com.hendraanggrian.kota.annotation.InputShowFlags

@JvmOverloads
fun Activity.showInput(@InputShowFlags flags: Int = InputMethodManager.SHOW_IMPLICIT, receiver: ResultReceiver? = null): Boolean {
    val focus = currentFocus
    return focus != null && (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(focus, flags, receiver)
}

@JvmOverloads
fun Activity.hideInput(@InputHideFlags flags: Int = InputMethodManager.HIDE_NOT_ALWAYS, receiver: ResultReceiver? = null): Boolean {
    val focus = currentFocus
    return focus != null && (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(focus.windowToken, flags, receiver)
}
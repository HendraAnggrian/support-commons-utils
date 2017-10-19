package kota.dialogs

import android.R.string.*
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.support.annotation.StringRes
import kota.internal.DialogButton

open class PositiveButton : DialogButton {
    @JvmOverloads constructor(text: CharSequence, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_POSITIVE, text, action)
    @JvmOverloads constructor(@StringRes text: Int, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_POSITIVE, text, action)
}

open class NegativeButton : DialogButton {
    @JvmOverloads constructor(text: CharSequence, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_NEGATIVE, text, action)
    @JvmOverloads constructor(@StringRes text: Int, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_NEGATIVE, text, action)
}

open class NeutralButton : DialogButton {
    @JvmOverloads constructor(text: CharSequence, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_NEUTRAL, text, action)
    @JvmOverloads constructor(@StringRes text: Int, action: ((DialogInterface) -> Unit)? = null) : super(BUTTON_NEUTRAL, text, action)
}

open class OkButton(action: ((DialogInterface) -> Unit)?) : PositiveButton(ok, action) {
    companion object : OkButton(null)
}

open class CancelButton(action: ((DialogInterface) -> Unit)?) : NegativeButton(cancel, action) {
    companion object : CancelButton(null)
}

open class YesButton(action: ((DialogInterface) -> Unit)?) : PositiveButton(yes, action) {
    companion object : YesButton(null)
}

open class NoButton(action: ((DialogInterface) -> Unit)?) : NegativeButton(no, action) {
    companion object : NoButton(null)
}
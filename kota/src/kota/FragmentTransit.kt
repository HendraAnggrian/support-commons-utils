package kota

import android.app.FragmentTransaction
import android.support.annotation.AnimatorRes
import android.support.annotation.StyleRes

const val TYPE_CUSTOM: Int = 0
const val TYPE_CONSTANT: Int = 1
const val TYPE_STYLE: Int = 2

open class FragmentTransit @PublishedApi internal constructor(
        val type: Int,
        vararg val value: Int
)

open class CustomTransit : FragmentTransit {
    constructor(@AnimatorRes enter: Int, @AnimatorRes exit: Int) : super(TYPE_CUSTOM, enter, exit)
    constructor(@AnimatorRes enter: Int, @AnimatorRes exit: Int, @AnimatorRes popEnter: Int, @AnimatorRes popExit: Int) : super(TYPE_CUSTOM, enter, exit, popEnter, popExit)

    val hasPop: Boolean get() = value.size == 4
}

open class NoneTransit : FragmentTransit(TYPE_CONSTANT, FragmentTransaction.TRANSIT_NONE) {
    companion object : NoneTransit()
}

open class OpenTransit : FragmentTransit(TYPE_CONSTANT, FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
    companion object : OpenTransit()
}

open class CloseTransit : FragmentTransit(TYPE_CONSTANT, FragmentTransaction.TRANSIT_FRAGMENT_CLOSE) {
    companion object : CloseTransit()
}

open class FadeTransit : FragmentTransit(TYPE_CONSTANT, FragmentTransaction.TRANSIT_FRAGMENT_FADE) {
    companion object : FadeTransit()
}

open class StyleTransit(@StyleRes styleRes: Int) : FragmentTransit(TYPE_STYLE, styleRes)

@PublishedApi
@Suppress("NOTHING_TO_INLINE")
internal inline fun FragmentTransaction.setTransit(transit: FragmentTransit): FragmentTransaction = when (transit.type) {
    TYPE_CUSTOM -> {
        transit as CustomTransit
        if (transit.hasPop) setCustomAnimations(transit.value[0], transit.value[1])
        else setCustomAnimations(transit.value[0], transit.value[1], transit.value[2], transit.value[3])
    }
    TYPE_CONSTANT -> setTransition(transit.value[0])
    else -> setTransitionStyle(transit.value[0])
}
@file:JvmMultifileClass
@file:JvmName("SparseArraysKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED", "EXTENSION_SHADOWED_BY_MEMBER")

package kota

import android.util.SparseBooleanArray
import java.util.*

/** Transform current map to sparse array. */
inline fun Map<Int, Boolean>.toSparseBooleanArray(): SparseBooleanArray = SparseBooleanArray().apply {
    for (key in keys) append(key, get(key))
}

/** Returns an empty sparse array. */
inline fun sparseBooleanArrayOf(): SparseBooleanArray = SparseBooleanArray()

/** Returns a sparse array with matching position of array input. */
inline fun sparseBooleanArrayOf(vararg elements: Boolean): SparseBooleanArray = SparseBooleanArray().apply {
    var i = 0
    for (element in elements) append(i++, element)
}

/** Returns a sparse array with defined position and element from Kotlin pair. */
inline fun sparseBooleanArrayOf(vararg pairs: Pair<Int, Boolean>): SparseBooleanArray = SparseBooleanArray().apply {
    for ((key, value) in pairs) append(key, value)
}

inline operator fun SparseBooleanArray.get(key: Int): Boolean = get(key)
inline operator fun SparseBooleanArray.set(key: Int, value: Boolean) = put(key, value)

inline fun SparseBooleanArray.containsKey(key: Int): Boolean = indexOfKey(key) > -1
inline fun SparseBooleanArray.containsValue(value: Boolean): Boolean = indexOfValue(value) > -1

inline fun SparseBooleanArray.forEach(action: (Boolean) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(valueAt(i))
    }
}

inline fun SparseBooleanArray.forEachIndexed(action: (Int, Boolean) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(keyAt(i), valueAt(i))
    }
}
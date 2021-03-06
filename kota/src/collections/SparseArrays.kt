@file:JvmMultifileClass
@file:JvmName("SparseArraysKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED", "EXTENSION_SHADOWED_BY_MEMBER")

package kota

import android.util.SparseArray
import java.util.*

/** Transform current map to sparse array. */
inline fun <E> Map<Int, E>.toSparseArray(): SparseArray<E> = SparseArray<E>().apply {
    for (key in keys) append(key, get(key))
}

/** Returns an empty sparse array. */
inline fun <E> sparseArrayOf(): SparseArray<E> = SparseArray()

/** Returns a sparse array with matching position of array input. */
inline fun <E> sparseArrayOf(vararg elements: E): SparseArray<E> = SparseArray<E>().apply {
    var i = 0
    for (element in elements) append(i++, element)
}

/** Returns a sparse array with defined position and element from Kotlin pair. */
inline fun <E> sparseArrayOf(vararg pairs: Pair<Int, E?>): SparseArray<E> = SparseArray<E>().apply {
    for ((key, value) in pairs) append(key, value)
}

inline operator fun <E> SparseArray<E>.get(key: Int): E = get(key)!!
inline operator fun <E> SparseArray<E>.set(key: Int, value: E) = put(key, value)

inline fun <E> SparseArray<E>.containsKey(key: Int): Boolean = indexOfKey(key) > -1
inline fun <E> SparseArray<E>.containsValue(value: E): Boolean = indexOfValue(value) > -1

inline fun <E> SparseArray<E>.forEach(action: (E) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(valueAt(i))
    }
}

inline fun <E> SparseArray<E>.forEachIndexed(action: (Int, E) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(keyAt(i), valueAt(i))
    }
}
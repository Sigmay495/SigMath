package com.sigmay.sigmath.common.extension

import kotlin.math.pow

/**
 * 平均値を計算する。
 * 空集合の場合nullを返す。
 */
fun Iterable<Number>.mean(): Double? = when {
    count() == 0 -> null
    else -> sumByDouble { it.toDouble() } / count()
}

/**
 * 分散値を計算する。
 * 空集合の場合nullを返す。
 */
fun Iterable<Number>.variance(): Double? = when {
    count() == 0 -> null
    else -> {
        var sum = 0.0
        var sum2 = 0.0
        for (n in this) {
            val d = n.toDouble()
            sum += d
            sum2 += d * d
        }
        val size = count()
        sum2 / size - (sum / size).pow(2)
    }
}

/**
 * 中央値を計算する。
 * 空集合の場合nullを返す。
 */
fun Iterable<Number>.median(): Double? = when {
    count() == 0 -> null
    else -> sortedBy { it.toDouble() }[count() / 2].toDouble()
}

package com.sigmay.sigmath.point

import java.io.Serializable
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 点のインタフェース。
 * 2次元の点の座標を保持する。
 * 値は変更不可。
 *
 */
interface Point : Serializable {
    /**
     * x座標
     */
    val x: Double

    /**
     * y座標
     */
    val y: Double

    operator fun unaryPlus(): Point
    operator fun unaryMinus(): Point

    operator fun plus(p: Point): Point
    operator fun minus(p: Point): Point
    operator fun times(d: Double): Point
    operator fun div(d: Double): Point

    operator fun times(n: Number) = times(n.toDouble())
    operator fun div(n: Number) = div(n.toDouble())

    operator fun component1() = x
    operator fun component2() = y

    /**
     * 点 [p] とのユークリッド距離を求める。
     */
    fun distance(p: Point) = sqrt((x - p.x).pow(2) + (y - p.y).pow(2))

    /**
     * 点 [p] とのマンハッタン距離を計算する。
     */
    fun manhattanDistance(p: Point) = abs(x - p.x) + abs(y - p.y)

    /**
     * 点 [p] とのチェビシェフ距離を計算する。
     */
    fun chebyshevDistance(p: Point) = max(abs(x - p.x), abs(y - p.y))

    /**
     * Point型に変換する。
     */
    fun toPoint(): Point

    /**
     * MutablePoint型に変換する。
     */
    fun toMutablePoint(): MutablePoint

    /**
     * Point3d型に変換する。
     */
    fun toPoint3d(): Point3d

    /**
     * MutablePoint3d型に変換する。
     */
    fun toMutablePoint3d(): MutablePoint3d
}

package com.sigmay.sigmath.point

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 点のインタフェース。
 * 3次元の点の座標を保持する。
 * 値は変更不可。
 *
 */
interface Point3d : Point {
    /**
     * z座標
     */
    val z: Double

    override fun unaryPlus(): Point3d
    override fun unaryMinus(): Point3d

    operator fun plus(p: Point3d): Point3d
    operator fun minus(p: Point3d): Point3d
    override fun times(d: Double): Point3d
    override fun div(d: Double): Point3d

    override fun times(n: Number) = times(n.toDouble())
    override fun div(n: Number) = div(n.toDouble())

    operator fun component3() = z

    /**
     * 点 [p] とのユークリッド距離を求める。
     */
    fun distance(p: Point3d) = sqrt((x - p.x).pow(2) + (y - p.y).pow(2) + (z - p.z).pow(2))

    /**
     * 点 [p] とのマンハッタン距離を計算する。
     */
    fun manhattanDistance(p: Point3d) = abs(x - p.x) + abs(y - p.y) + abs(z - p.z)

    /**
     * 点 [p] とのチェビシェフ距離を計算する。
     */
    fun chebyshevDistance(p: Point3d) = max(max(abs(x - p.x), abs(y - p.y)), abs(z - p.z))
}

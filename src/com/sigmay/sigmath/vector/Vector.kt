package com.sigmay.sigmath.vector

import java.io.Serializable

/**
 * ベクトルのインタフェース。
 * 任意の次元を取り扱える。
 * 値は変更不可。
 *
 */
interface Vector : Iterable<Double>, Serializable {
    /**
     * 次元数
     */
    val dim: Int

    operator fun unaryPlus(): Vector
    operator fun unaryMinus(): Vector

    operator fun plus(v: Vector): Vector
    operator fun minus(v: Vector): Vector
    operator fun times(d: Double): Vector
    operator fun times(v: Vector): Double
    operator fun div(d: Double): Vector

    operator fun times(n: Number) = times(n.toDouble())
    operator fun div(n: Number) = div(n.toDouble())

    operator fun get(i: Int): Double

    /**
     * ベクトル [v] とのクロス積（外積）を計算する。
     */
    infix fun cross(v: Vector): Vector

    /**
     * ベクトル [v] とのユークリッド距離を計算する。
     */
    fun distance(v: Vector): Double

    /**
     * ベクトル [v] とのマンハッタン距離を計算する。
     */
    fun manhattanDistance(v: Vector): Double

    /**
     * ベクトル [v] とのチェビシェフ距離を計算する。
     */
    fun chebyshevDistance(v: Vector): Double

    /**
     * ベクトル [v] とのコサイン類似度を計算する。
     */
    fun cos(v: Vector) = times(v) / norm() / v.norm()

    /**
     * ベクトルの2ノルム（長さ）を計算する。
     */
    fun norm() = norm(2.0)

    /**
     * ベクトルの [p] ノルムを計算する。
     */
    fun norm(p: Double): Double

    /**
     * ゼロベクトルならばtrue
     */
    fun isZero(): Boolean

    /**
     * Vector型に変換する。
     */
    fun toVector(): Vector

    /**
     * MutableVector型に変換する。
     */
    fun toMutableVector(): MutableVector

}

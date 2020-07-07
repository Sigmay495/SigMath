package com.sigmay.sigmath.vector

import com.sigmay.sigmath.common.exception.VectorArithmeticException
import com.sigmay.sigmath.common.extension.mean
import com.sigmay.sigmath.common.extension.variance
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Double型の要素を持つベクトル。
 *
 * @property elements 要素の配列
 * @property dim 次元数
 */
class DoubleVector private constructor(private val elements: DoubleArray, override val dim: Int) : MutableVector {

    /**
     * 指定した要素を持つベクトルを生成する。
     */
    constructor(array: DoubleArray) : this(array, array.size)

    /**
     * 指定した要素を持つベクトルを生成する。
     */
    constructor(collection: Collection<Double>) : this(collection.toDoubleArray(), collection.size)

    /**
     * ゼロベクトルを生成する。
     */
    constructor(dim: Int) : this(DoubleArray(dim), dim)

    /**
     * 関数で初期化した要素を持つベクトルを生成する。
     */
    constructor(dim: Int, init: (Int) -> Double) : this(DoubleArray(dim, init), dim)

    override fun unaryPlus() = DoubleVector(elements, dim)

    override fun unaryMinus() = DoubleVector(elements.map { -it })

    override fun plus(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> DoubleVector(elements.mapIndexed { index, d -> d + v[index] })
    }

    override fun minus(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> DoubleVector(elements.mapIndexed { index, d -> d - v[index] })
    }

    override fun times(d: Double) = DoubleVector(elements.map { it * d })

    override fun times(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> elements.mapIndexed { index, d -> d * v[index] }.sum()
    }

    override fun div(d: Double) = when (d) {
        0.0 -> throw VectorArithmeticException("0では割ることができません。")
        else -> DoubleVector(elements.map { it / d })
    }

    override fun plusAssign(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> for (i in elements.indices) elements[i] += v[i]
    }

    override fun minusAssign(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> for (i in elements.indices) elements[i] -= v[i]
    }

    override fun timesAssign(d: Double) {
        for (i in elements.indices) elements[i] *= d
    }

    override fun divAssign(d: Double) = when (d) {
        0.0 -> throw VectorArithmeticException("0では割ることができません。")
        else -> for (i in elements.indices) elements[i] /= d
    }

    override fun set(i: Int, d: Double) = elements.set(i, d)

    override fun get(i: Int) = elements[i]

    /**
     * 最小値が [min]、最大値が [max] になるように正規化を行う。
     */
    override fun normalize(min: Double, max: Double) {
        if (min > max) throw VectorArithmeticException("最小値が最大値より大きいです。")
        val vMax = asIterable().max() ?: throw VectorArithmeticException("要素が存在しません。")
        val vMin = asIterable().min() ?: throw VectorArithmeticException("要素が存在しません。")
        if (vMax == vMin) throw VectorArithmeticException("ベクトルの要素がすべて同じです。")
        for (i in elements.indices) elements[i] = (elements[i] - vMin) / (vMax - vMin) * (max - min) + min
    }

    /**
     * 平均が0、分散が1になるように標準化を行う。
     */
    override fun standardization() {
        val mu = asIterable().mean() ?: throw VectorArithmeticException("要素が存在しません。")
        val sigma = sqrt(asIterable().mean() ?: throw VectorArithmeticException("要素が存在しません。"))
        if (sigma == 0.0) throw VectorArithmeticException("ベクトルの要素がすべて同じです。")
        for (i in elements.indices) elements[i] = (elements[i] - mu) / sigma
    }

    /**
     * ベクトル [v] とのクロス積（外積）を計算する。
     */
    override fun cross(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        dim == 0 -> DoubleVector(0)
        dim == 1 -> DoubleVector(1)
        dim == 3 -> DoubleVector(listOf(
                elements[1] * v[2] - elements[2] * v[1],
                elements[2] * v[0] - elements[0] * v[2],
                elements[0] * v[1] - elements[1] * v[0]
        ))
        dim == 7 -> DoubleVector(listOf(
                elements[1] * v[2] - elements[2] * v[1] - elements[3] * v[4] + elements[4] * v[3] - elements[5] * v[6] + elements[6] * v[5],
                -elements[0] * v[2] + elements[2] * v[0] - elements[3] * v[5] + elements[4] * v[6] + elements[5] * v[3] - elements[6] * v[4],
                elements[0] * v[1] - elements[1] * v[0] - elements[3] * v[6] - elements[4] * v[5] + elements[5] * v[4] + elements[6] * v[3],
                elements[0] * v[4] + elements[1] * v[5] + elements[2] * v[6] - elements[4] * v[0] - elements[5] * v[1] - elements[6] * v[2],
                -elements[0] * v[3] - elements[1] * v[6] + elements[2] * v[5] + elements[3] * v[0] - elements[5] * v[2] - elements[6] * v[1],
                elements[0] * v[6] - elements[1] * v[3] - elements[2] * v[4] + elements[3] * v[1] + elements[4] * v[2] - elements[6] * v[0],
                -elements[0] * v[5] + elements[1] * v[4] - elements[2] * v[3] + elements[3] * v[2] - elements[4] * v[1] + elements[5] * v[0]
        ))
        else -> throw VectorArithmeticException("クロス積（外積）が定義されていません。")
    }

    /**
     * ベクトル [v] とのユークリッド距離を計算する。
     */
    override fun distance(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> sqrt(elements.mapIndexed { index, d -> (d - v[index]).pow(2) }.sum())
    }

    /**
     * ベクトル [v] とのマンハッタン距離を計算する。
     */
    override fun manhattanDistance(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> elements.mapIndexed { index, d -> abs(d - v[index]) }.sum()
    }

    /**
     * ベクトル [v] とのチェビシェフ距離を計算する。
     */
    override fun chebyshevDistance(v: Vector) = when {
        dim != v.dim -> throw VectorArithmeticException("次元数が一致していません。")
        else -> elements.mapIndexed { index, d -> abs(d - v[index]) }.max() ?: 0.0
    }

    /**
     * ベクトルの [p] ノルムを計算する。
     */
    override fun norm(p: Double) = when (p) {
        Double.MAX_VALUE -> elements.map { abs(it) }.max() ?: 0.0
        Double.MIN_VALUE -> elements.map { abs(it) }.min() ?: 0.0
        else -> elements.map { abs(it).pow(p) }.sum().pow(1.0 / p)
    }

    /**
     * ゼロベクトルならばtrue
     */
    override fun isZero() = elements.all { it == 0.0 }

    /**
     * Vector型に変換する。
     */
    override fun toVector(): Vector = DoubleVector(elements, dim)

    /**
     * MutableVector型に変換する。
     */
    override fun toMutableVector(): MutableVector = DoubleVector(elements, dim)

    /**
     * イテレータを取得する。
     */
    override fun iterator() = elements.iterator()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DoubleVector

        if (!elements.contentEquals(other.elements)) return false
        if (dim != other.dim) return false

        return true
    }

    override fun hashCode(): Int {
        var result = elements.contentHashCode()
        result = 31 * result + dim
        return result
    }

    override fun toString() = elements.contentToString()
}

fun main() {
    val v = DoubleVector(5) { it.toDouble() + 1.0 }
    val v2 = DoubleVector(5) { it.toDouble() + 1 }
    v += v2
    v.normalize(1.0, 2.0)
    v.variance()
    println(v)
}

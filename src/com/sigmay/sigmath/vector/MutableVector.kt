package com.sigmay.sigmath.vector

/**
 * 点のインタフェース。
 * 2次元の点の座標を保持する。
 * 値は変更可能。
 *
 */
interface MutableVector : Vector {

    override fun unaryPlus(): MutableVector
    override fun unaryMinus(): MutableVector

    override fun plus(v: Vector): MutableVector
    override fun minus(v: Vector): MutableVector
    override fun times(d: Double): MutableVector
    override fun div(d: Double): MutableVector

    override fun times(n: Number) = times(n.toDouble())
    override fun div(n: Number) = div(n.toDouble())

    operator fun plusAssign(v: Vector)
    operator fun minusAssign(v: Vector)
    operator fun timesAssign(d: Double)
    operator fun divAssign(d: Double)

    operator fun timesAssign(n: Number) = timesAssign(n.toDouble())
    operator fun divAssign(n: Number) = divAssign(n.toDouble())

    operator fun set(i: Int, d: Double)

    /**
     * 長さが1になるように正規化を行う。
     */
    fun normalize() = divAssign(norm())

    /**
     * 最小値が [min]、最大値が [max] になるように正規化を行う。
     */
    fun normalize(min: Double, max: Double)

    /**
     * 平均が0、分散が1になるように標準化を行う。
     */
    fun standardization()
}

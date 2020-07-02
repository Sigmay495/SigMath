package com.sigmay.sigmath.point

/**
 * 点のインタフェース。
 * 2次元の点の座標を保持する。
 * 値は変更可能。
 *
 */
interface MutablePoint : Point {
    /**
     * x座標
     */
    override var x: Double

    /**
     * y座標
     */
    override var y: Double

    override fun unaryPlus(): MutablePoint
    override fun unaryMinus(): MutablePoint

    override fun plus(p: Point): MutablePoint
    override fun minus(p: Point): MutablePoint
    override fun times(d: Double): MutablePoint
    override fun div(d: Double): MutablePoint

    override fun times(n: Number) = times(n.toDouble())
    override fun div(n: Number) = div(n.toDouble())

    operator fun plusAssign(p: Point)
    operator fun minusAssign(p: Point)
    operator fun timesAssign(d: Double)
    operator fun divAssign(d: Double)

    operator fun timesAssign(n: Number) = timesAssign(n.toDouble())
    operator fun divAssign(n: Number) = divAssign(n.toDouble())
}

package com.sigmay.sigmath.point

/**
 * 点のインタフェース。
 * 3次元の点の座標を保持する。
 * 値は変更可能。
 *
 */
interface MutablePoint3d : Point3d, MutablePoint {
    /**
     * z座標
     */
    override var z: Double

    override fun unaryPlus(): MutablePoint3d
    override fun unaryMinus(): MutablePoint3d

    override fun plus(p: Point3d): MutablePoint3d
    override fun minus(p: Point3d): MutablePoint3d
    override fun times(d: Double): MutablePoint3d
    override fun div(d: Double): MutablePoint3d

    override fun times(n: Number) = times(n.toDouble())
    override fun div(n: Number) = div(n.toDouble())

    operator fun plusAssign(p: Point3d)
    operator fun minusAssign(p: Point3d)
    override fun timesAssign(d: Double)
    override fun divAssign(d: Double)

    override fun timesAssign(n: Number) = timesAssign(n.toDouble())
    override fun divAssign(n: Number) = divAssign(n.toDouble())
}

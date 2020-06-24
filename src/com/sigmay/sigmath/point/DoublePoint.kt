package com.sigmay.sigmath.point

import com.sigmay.sigmath.common.PointException

/**
 * Double型の座標値を持つ点。
 *
 * @property x x座標。
 * @property y y座標。
 * @property z z座標。
 * @property hasZ z座標を持つならtrue
 */
class DoublePoint private constructor(override var x: Double, override var y: Double, override var z: Double, private val hasZ: Boolean) : MutablePoint3d {

    /**
     * 3次元の点を生成する。
     */
    constructor(x: Double, y: Double, z: Double) : this(x, y, z, true)

    /**
     * 2次元の点を生成する。
     */
    constructor(x: Double, y: Double) : this(x, y, 0.0, false)

    override fun unaryPlus() = DoublePoint(x, y, z)

    override fun unaryMinus() = DoublePoint(-x, -y, -z)

    override fun plus(p: Point3d) = DoublePoint(x + p.x, y + p.y, z + p.z)

    override fun plus(p: Point) = DoublePoint(x + p.x, y + p.y)

    override fun minus(p: Point3d) = DoublePoint(x - p.x, y - p.y, z - p.z)

    override fun minus(p: Point) = DoublePoint(x - p.x, y - p.y)

    override fun times(d: Double) = DoublePoint(x * d, y * d, z * d)

    override fun div(d: Double) =
            if (d == 0.0)
                throw PointException("0では割ることができません。")
            else
                DoublePoint(x / d, y / d, z / d)

    override fun plusAssign(p: Point3d) {
        x += p.x
        y += p.y
        z += p.z
    }

    override fun plusAssign(p: Point) {
        x += p.x
        y += p.y
    }

    override fun minusAssign(p: Point3d) {
        x -= p.x
        y -= p.y
        z -= p.z
    }

    override fun minusAssign(p: Point) {
        x -= p.x
        y -= p.y
    }

    override fun timesAssign(d: Double) {
        x *= d
        y *= d
        z *= d
    }

    override fun divAssign(d: Double) {
        if (d == 0.0)
            throw PointException("0では割ることができません。")
        x /= d
        y /= d
        z /= d
    }

    override fun toPoint(): Point = DoublePoint(x, y)

    override fun toMutablePoint(): MutablePoint = DoublePoint(x, y)

    override fun toPoint3d(): Point3d = DoublePoint(x, y, z)

    override fun toMutablePoint3d(): MutablePoint3d = DoublePoint(x, y, z)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DoublePoint

        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        if (hasZ != other.hasZ) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString() = if (hasZ) "($x, $y, $z)" else "($x, $y)"

}

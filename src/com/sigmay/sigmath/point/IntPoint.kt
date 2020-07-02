package com.sigmay.sigmath.point

import com.sigmay.sigmath.common.exception.PointArithmeticException
import kotlin.math.round

/**
 * Int型の座標値を持つ点。
 *
 * @property x x座標。
 * @property y y座標。
 * @property z z座標。
 * @property hasZ z座標を持つならtrue
 */
class IntPoint private constructor(override var x: Double, override var y: Double, override var z: Double, private val hasZ: Boolean) : MutablePoint3d {

    /**
     * 3次元の点を生成する。
     */
    private constructor(x: Double, y: Double, z: Double) : this(round(x), round(y), round(z), true)

    /**
     * 2次元の点を生成する。
     */
    private constructor(x: Double, y: Double) : this(round(x), round(y), 0.0, false)

    /**
     * 3次元の点を生成する。
     */
    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble(), true)

    /**
     * 2次元の点を生成する。
     */
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble(), 0.0, false)

    override fun unaryPlus() = IntPoint(x, y, z)

    override fun unaryMinus() = IntPoint(-x, -y, -z)

    override fun plus(p: Point3d) = IntPoint(x + p.x, y + p.y, z + p.z)

    override fun plus(p: Point) = IntPoint(x + p.x, y + p.y)

    override fun minus(p: Point3d) = IntPoint(x - p.x, y - p.y, z - p.z)

    override fun minus(p: Point) = IntPoint(x - p.x, y - p.y)

    override fun times(d: Double) = when {
        hasZ -> IntPoint(x * d, y * d, z * d)
        else -> IntPoint(x * d, y * d)
    }

    override fun div(d: Double) = when {
        d == 0.0 -> throw PointArithmeticException("0では割ることができません。")
        hasZ -> IntPoint(x / d, y / d, z / d)
        else -> IntPoint(x / d, y / d)
    }

    override fun plusAssign(p: Point3d) {
        x += p.x
        y += p.y
        z += p.z
        x = round(x)
        y = round(y)
        z = round(z)
    }

    override fun plusAssign(p: Point) {
        x += p.x
        y += p.y
        x = round(x)
        y = round(y)
    }

    override fun minusAssign(p: Point3d) {
        x -= p.x
        y -= p.y
        z -= p.z
        x = round(x)
        y = round(y)
        z = round(z)
    }

    override fun minusAssign(p: Point) {
        x -= p.x
        y -= p.y
        x = round(x)
        y = round(y)
    }

    override fun timesAssign(d: Double) {
        x *= d
        y *= d
        if (hasZ)
            z *= d
        x = round(x)
        y = round(y)
        if (hasZ)
            z = round(z)
    }

    override fun divAssign(d: Double) {
        if (d == 0.0)
            throw PointArithmeticException("0では割ることができません。")
        x /= d
        y /= d
        if (hasZ)
            z /= d
        x = round(x)
        y = round(y)
        if (hasZ)
            z = round(z)
    }

    /**
     * Point型に変換する。
     */
    override fun toPoint(): Point = IntPoint(x, y)

    /**
     * MutablePoint型に変換する。
     */
    override fun toMutablePoint(): MutablePoint = IntPoint(x, y)

    /**
     * Point3d型に変換する。
     */
    override fun toPoint3d(): Point3d = IntPoint(x, y, z)

    /**
     * MutablePoint3d型に変換する。
     */
    override fun toMutablePoint3d(): MutablePoint3d = IntPoint(x, y, z)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntPoint

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
        result = 31 * result + hasZ.hashCode()
        return result
    }

    override fun toString() = when {
        hasZ -> "(${x.toInt()}, ${y.toInt()}, ${z.toInt()})"
        else -> "(${x.toInt()}, ${y.toInt()})"
    }

}

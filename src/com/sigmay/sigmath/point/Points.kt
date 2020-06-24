package com.sigmay.sigmath.point

/**
 * [x] と [y] を座標値に持つPointを生成する。
 */
fun pointOf(x: Double, y: Double): Point = DoublePoint(x, y)

/**
 * [x] と [y] を座標値に持つPointを生成する。
 */
fun pointOf(x: Int, y: Int): Point = IntPoint(x, y)

/**
 * [x] と [y] を座標値に持つMutablePointを生成する。
 */
fun mutablePointOf(x: Double, y: Double): MutablePoint = DoublePoint(x, y)

/**
 * [x] と [y] を座標値に持つMutablePointを生成する。
 */
fun mutablePointOf(x: Int, y: Int): MutablePoint = IntPoint(x, y)

/**
 * [x] と [y] と [z] を座標値に持つPoint3dを生成する。
 */
fun point3dOf(x: Double, y: Double, z: Double): Point3d = DoublePoint(x, y, z)

/**
 * [x] と [y] と [z] を座標値に持つPoint3dを生成する。
 */
fun point3dOf(x: Int, y: Int, z: Int): Point3d = IntPoint(x, y, z)

/**
 * [x] と [y] と [z] を座標値に持つMutablePoint3dを生成する。
 */
fun mutablePoint3dOf(x: Double, y: Double, z: Double): MutablePoint3d = DoublePoint(x, y, z)

/**
 * [x] と [y] と [z] を座標値に持つMutablePoint3dを生成する。
 */
fun mutablePoint3dOf(x: Int, y: Int, z: Int): MutablePoint3d = IntPoint(x, y, z)

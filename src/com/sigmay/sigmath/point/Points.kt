package com.sigmay.sigmath.point

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

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

/**
 * 点 [p1] と点 [p2] 間の2次元ユークリッド距離を求める。
 */
fun distance(p1: Point, p2: Point) = p1.distance(p2)

/**
 * 点 [p1] と点 [p2] 間の3次元ユークリッド距離を求める。
 */
fun distance(p1: Point3d, p2: Point3d) = p1.distance(p2)

/**
 * 点 [p1] と点 [p2] 間の2次元マンハッタン距離を計算する。
 */
fun manhattanDistance(p1: Point, p2: Point)= p1.manhattanDistance(p2)

/**
 * 点 [p1] と点 [p2] 間の3次元マンハッタン距離を計算する。
 */
fun manhattanDistance(p1: Point3d, p2: Point3d)= p1.manhattanDistance(p2)

/**
 * 点 [p1] と点 [p2] 間の2次元チェビシェフ距離を計算する。
 */
fun chebyshevDistance(p1: Point, p2: Point)= p1.chebyshevDistance(p2)

/**
 * 点 [p1] と点 [p2] 間の3次元チェビシェフ距離を計算する。
 */
fun chebyshevDistance(p1: Point3d, p2: Point3d)= p1.chebyshevDistance(p2)

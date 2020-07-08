package com.sigmay.sigmath.vector

/**
 * 要素 [values] を持つVectorを生成する。
 */
fun vectorOf(vararg values: Double): Vector = DoubleVector(values)

/**
 * [collection] に含まれる要素を持つVectorを生成する。
 */
fun vectorOf(collection: Collection<Double>): Vector = DoubleVector(collection)

/**
 * [dim] 次元のゼロVectorを生成する。
 */
fun vectorOf(dim: Int): Vector = DoubleVector(dim)

/**
 * 関数 [init] で初期化した要素を持つ [dim] 次元のVectorを生成する。
 */
fun vectorOf(dim: Int, init: (Int) -> Double): Vector = DoubleVector(dim, init)

/**
 * 要素 [values] を持つMutableVectorを生成する。
 */
fun mutableVectorOf(vararg values: Double): MutableVector = DoubleVector(values)

/**
 * [collection] に含まれる要素を持つMutableVectorを生成する。
 */
fun mutableVectorOf(collection: Collection<Double>): MutableVector = DoubleVector(collection)

/**
 * [dim] 次元のゼロMutableVectorを生成する。
 */
fun mutableVectorOf(dim: Int): MutableVector = DoubleVector(dim)

/**
 * 関数 [init] で初期化した要素を持つ [dim] 次元のMutableVectorを生成する。
 */
fun mutableVectorOf(dim: Int, init: (Int) -> Double): MutableVector = DoubleVector(dim, init)

/**
 * ベクトル [v1] と [v2] 間のユークリッド距離を計算する。
 */
fun distance(v1: Vector, v2: Vector) = v1.distance(v2)

/**
 * ベクトル [v1] と [v2] 間のマンハッタン距離を計算する。
 */
fun manhattanDistance(v1: Vector, v2: Vector) = v1.manhattanDistance(v2)

/**
 * ベクトル [v1] と [v2] 間のチェビシェフ距離を計算する。
 */
fun chebyshevDistance(v1: Vector, v2: Vector) = v1.chebyshevDistance(v2)

/**
 * ベクトル [v1] と [v2] 間のコサイン類似度を計算する。
 */
fun cos(v1: Vector, v2: Vector) = v1.cos(v2)

package com.sigmay.sigmath.vector

/**
 * 指定した要素を持つベクトルを生成する。
 */
fun vectorOf(vararg values: Double): Vector = DoubleVector(values)

/**
 * 指定した要素を持つベクトルを生成する。
 */
fun vectorOf(collection: Collection<Double>): Vector = DoubleVector(collection)

/**
 * ゼロベクトルを生成する。
 */
fun vectorOf(dim: Int): Vector = DoubleVector(dim)

/**
 * 関数で初期化した要素を持つベクトルを生成する。
 */
fun vectorOf(dim: Int, init: (Int) -> Double): Vector = DoubleVector(dim, init)

/**
 * 指定した要素を持つベクトルを生成する。
 */
fun mutableVectorOf(vararg values: Double): MutableVector = DoubleVector(values)

/**
 * 指定した要素を持つベクトルを生成する。
 */
fun mutableVectorOf(collection: Collection<Double>): MutableVector = DoubleVector(collection)

/**
 * ゼロベクトルを生成する。
 */
fun mutableVectorOf(dim: Int): MutableVector = DoubleVector(dim)

/**
 * 関数で初期化した要素を持つベクトルを生成する。
 */
fun mutableVectorOf(dim: Int, init: (Int) -> Double): MutableVector = DoubleVector(dim, init)

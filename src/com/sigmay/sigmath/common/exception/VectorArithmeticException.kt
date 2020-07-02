package com.sigmay.sigmath.common.exception

/**
 * ベクトルの演算時の例外。
 *
 * @constructor
 * [message] を持つ例外を発生させる。
 */
class VectorArithmeticException(message: String): ArithmeticException("[Vector] $message")

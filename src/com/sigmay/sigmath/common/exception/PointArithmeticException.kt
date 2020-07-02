package com.sigmay.sigmath.common.exception

/**
 * 点の演算時の例外。
 *
 * @constructor
 * [message] を持つ例外を発生させる。
 */
class PointArithmeticException(message: String): ArithmeticException("[Point] $message")

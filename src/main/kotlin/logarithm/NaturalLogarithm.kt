package org.example.logarithm

import kotlin.math.abs

open class NaturalLogarithm(val precision: Double = DEFAULT_PRECISION) {

    companion object {
        const val DEFAULT_PRECISION = 1e-15
        const val MAX_ITERATIONS = 1000
    }

    private val ln2: Double by lazy { seriesSum(1.0 / 3.0) * 2.0 }

    open fun calculate(x: Double): Double {
        require(x.isFinite() && x > 0.0) { "ln(x) определен только для конечных x > 0, на вход передали $x" }

        var m = x
        var k = 0
        while (m >= 2.0) { m /= 2.0; k++ }
        while (m < 1.0) { m *= 2.0; k-- }

        val u = (m - 1.0) / (m + 1.0)
        return 2.0 * seriesSum(u) + k * ln2
    }

    private fun seriesSum(u: Double): Double {
        val u2 = u * u
        var term = u
        var sum = u
        var n = 1
        while (n <= MAX_ITERATIONS) {
            term *= u2
            val contrib = term / (2 * n + 1)
            sum += contrib
            if (abs(contrib) < precision) break
            n++
        }
        return sum
    }
}

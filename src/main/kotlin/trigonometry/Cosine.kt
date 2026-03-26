package org.example.trigonometry

import kotlin.math.PI
import kotlin.math.abs

open class Cosine(val precision: Double = DEFAULT_PRECISION) {

    companion object {
        const val DEFAULT_PRECISION = 1e-15
        const val MAX_ITERATIONS = 500
    }

    open fun calculate(x: Double): Double {
        require(x.isFinite()) { "x должен быть конечным, на вход передан $x" }

        var r = x % (2.0 * PI)
        if (r > PI) r -= 2.0 * PI
        if (r < -PI) r += 2.0 * PI

        var sum = 1.0
        var term = 1.0
        var n = 1

        while (n <= MAX_ITERATIONS) {
            term *= -(r * r) / ((2 * n - 1).toDouble() * (2 * n).toDouble())
            sum += term
            if (abs(term) < precision) break
            n++
        }

        return sum
    }
}

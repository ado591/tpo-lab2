package org.example.trigonometry

import kotlin.math.abs

open class Secant(private val cosine: Cosine = Cosine()) {

    companion object {
        const val SINGULARITY_THRESHOLD = 1e-10
    }

    open fun calculate(x: Double): Double {
        require(x.isFinite()) { "x must be a finite number, got $x" }

        val cosVal = cosine.calculate(x)
        if (abs(cosVal) < SINGULARITY_THRESHOLD) {
            throw ArithmeticException("sec(x) неопределен в точке x = $x (cos(x) = 0)")
        }

        return 1.0 / cosVal
    }
}

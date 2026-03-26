package org.example.logarithm

open class BaseNLogarithm(
    val base: Double,
    private val ln: NaturalLogarithm = NaturalLogarithm()
) {

    init {
        require(base.isFinite() && base > 0.0) { "Основание логарифма должно быть целым числом строго больше 0, на вход передали $base" }
        require(base != 1.0) { "Base must not equal 1" }
    }

    private val lnBase: Double by lazy { ln.calculate(base) }

    fun calculate(x: Double): Double {
        require(x.isFinite() && x > 0.0) { "log_$base(x) определен только для x > 0, на вход передали $x" }
        return ln.calculate(x) / lnBase
    }
}

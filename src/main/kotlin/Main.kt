package org.example

import org.example.trigonometry.*
import org.example.logarithm.*

object Main {

    private var outputDir: String =
        System.getProperty("user.dir") + File.separator + "plots" + File.separator

    private const val START = -10.0
    private const val END = 10.0
    private const val STEP = 0.01

    @JvmStatic
    fun main(args: Array<String>) {
        generateFunctionData()
    }

    private fun generateFunctionData() {
        CSVGraphWriter(Sine(), outputDir).write(START, END, STEP)
        CSVGraphWriter(Cosine(), outputDir).write(START, END, STEP)
        CSVGraphWriter(Secant(), outputDir).write(START, END, STEP)
        CSVGraphWriter(Cosecant(), outputDir).write(START, END, STEP)
        CSVGraphWriter(Tangent(), outputDir).write(START, END, STEP)
        CSVGraphWriter(Cotangent(), outputDir).write(START, END, STEP)

        CSVGraphWriter(NaturalLogarithm(), outputDir).write(START, END, STEP)
        CSVGraphWriter(BaseNLogarithm(2.0), outputDir).write(START, END, STEP)
        CSVGraphWriter(BaseNLogarithm(3.0), outputDir).write(START, END, STEP)
        CSVGraphWriter(BaseNLogarithm(10.0), outputDir).write(START, END, STEP)

        CSVGraphWriter(EquationSystem(), outputDir).write(START, END, STEP)
    }
}
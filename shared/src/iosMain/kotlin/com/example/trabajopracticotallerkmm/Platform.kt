package com.example.trabajopracticotallerkmm

import com.example.trabajopracticotallerkmm.data.Calculadora
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun initLogger() {
    Napier.base(DebugAntilog())
}

actual fun initTestSuma(): Int {
    val calculadora = Calculadora()
    return calculadora.sumar(7,8)
}

actual fun initTestResta(): Int {
    val calculadora = Calculadora()
    return calculadora.restar(7,3)
}

actual fun initTestMultiplicacion(): Int {
    val calculadora = Calculadora()
    return calculadora.restar(5,5)
}

actual fun initTestDivision(): Float {
    val calculadora = Calculadora()
    return calculadora.dividir(10F,2F)
}
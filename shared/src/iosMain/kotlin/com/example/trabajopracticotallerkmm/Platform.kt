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
    TODO("Not yet implemented")
}

actual fun initTestMultiplicacion(): Int {
    TODO("Not yet implemented")
}

actual fun initTestDivision(): Float {
    TODO("Not yet implemented")
}
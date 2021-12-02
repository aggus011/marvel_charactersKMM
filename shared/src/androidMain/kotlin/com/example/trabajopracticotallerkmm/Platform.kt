package com.example.trabajopracticotallerkmm

import com.example.trabajopracticotallerkmm.data.Calculadora
import com.example.trabajopracticotallerkmm.model.Characters
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}


actual fun initLogger() {
    Napier.base(DebugAntilog())
}

actual fun initTestSuma():Int {
    val calculadora  = Calculadora()
    return calculadora.sumar(2,3)
}

actual fun initTestResta(): Int {
    val calculadora = Calculadora()
    return calculadora.restar(5,2)
}

actual fun initTestMultiplicacion():Int{
    val calculadora = Calculadora()
    return calculadora.multiplicar(3,2)
}

actual fun initTestDivision():Float {
    val calculadora = Calculadora()
    return calculadora.dividir(10f,0f)
}
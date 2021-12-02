package com.example.trabajopracticotallerkmm

import com.example.trabajopracticotallerkmm.model.Characters
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.SerialName

expect class Platform() {
    val platform: String
}

expect fun initLogger()

expect fun initTestSuma():Int

expect fun initTestResta():Int

expect fun initTestMultiplicacion():Int

expect fun initTestDivision():Float






















package trabajopracticotallerkmm

import com.example.trabajopracticotallerkmm.initTestDivision
import com.example.trabajopracticotallerkmm.initTestMultiplicacion
import com.example.trabajopracticotallerkmm.initTestResta
import com.example.trabajopracticotallerkmm.initTestSuma
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestOperaciones {

    @Test
    fun testQueHagaLaSumaIncorrecta(){
       assertEquals(initTestSuma(),8)
    }

    @Test
    fun testQueHagaLaSumaCorrecta(){
        assertEquals(initTestSuma(),5)
    }

    @Test
    fun testQueHagaLaRestaInCorrecta(){
        assertEquals(initTestResta(),4)
    }

    @Test
    fun testQueHagaLaRestaCorrecta(){
        assertEquals(initTestResta(),3)
    }

    @Test
    fun testQueHagaLaMultiplicacionIncorrecta(){
        assertEquals(initTestMultiplicacion(),7)
    }

    @Test
    fun testQueHagaLaMultiplicacionCorrecta(){
        assertEquals(initTestMultiplicacion(),6)
    }

    @Test
    fun testQueHagaLaDivisionCorrecta(){
        assertEquals(initTestDivision(),3f)
    }

    @Test
    fun testQueHagaLaDivisionIncorrecta(){
        val exception = assertFailsWith<Exception>{ initTestDivision()}
        assertEquals("No se puede dividir por 0",exception.message.toString())

    }

}
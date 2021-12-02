package com.example.trabajopracticotallerkmm.data

class Calculadora {
    fun sumar(a: Int, b: Int) = a + b
    fun restar(a: Int, b: Int) = a - b
    fun multiplicar(a: Int, b: Int) = a * b
    fun dividir(a: Float, b: Float): Float {
        if(b!=0f){
            return a / b
        }
        else{
            throw Exception("No se puede dividir por 0")
        }
    }
}
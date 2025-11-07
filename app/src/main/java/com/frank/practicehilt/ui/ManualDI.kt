package com.frank.practicehilt.ui

import android.util.Log

// NO DI
class PC {
    private val motherboard = Motherboard()
    fun start() {
        motherboard.powerON()
    }
}

class Motherboard() {
    fun powerON() {
        Log.e("NO_DI","turning on the computer .....")
    }
}

fun main() {
    val personalComputer = PC()
    personalComputer.start()
}


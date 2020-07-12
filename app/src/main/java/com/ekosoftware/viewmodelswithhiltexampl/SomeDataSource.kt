package com.ekosoftware.viewmodelswithhiltexampl

import kotlin.random.Random

class SomeDataSource {
    fun exampleFunctionGetMessage(): String {
        return "Example string"
    }

    fun exampleFunctionGetNumber(): Int {
        return Random(System.currentTimeMillis()).nextInt(0, 11)
    }

    fun exampleFunctionGetBoolean(): Boolean {
        return exampleFunctionGetNumber() % 2 == 0
    }
}
package com.ekosoftware.viewmodelswithhiltexampl.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class SomeDataSource {
    fun exampleFunctionGetMessage(): Flow<String> {
        return flow {
            for(i in 1..50) {
                delay(3000)
                emit("Mensaje no. $i")
            }
        }
    }

    fun exampleFunctionGetNumber(): Flow<Int> {
        return flow {
            for (i in 0..50) {
                delay(1000)
                emit(randomNum())
            }
        }
    }

    private fun randomNum() = Random(System.currentTimeMillis()).nextInt(0, 11)

    fun exampleFunctionGetBoolean(): Flow<Boolean> {
        return flow {
            for (i in 0..30) {
                delay(5000)
                emit(randomNum() % 2 == 0)
            }
        }
    }
}
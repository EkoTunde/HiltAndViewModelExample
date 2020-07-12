package com.ekosoftware.viewmodelswithhiltexampl.domain

import kotlinx.coroutines.flow.Flow

interface SomeRepoInterface {
    fun exampleFunctionGetMessage() : Flow<String>
    fun exampleFunctionGetNumber() : Flow<Int>
    fun exampleFunctionGetBoolean() : Flow<Boolean>
}
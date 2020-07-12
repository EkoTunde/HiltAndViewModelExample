package com.ekosoftware.viewmodelswithhiltexampl

import javax.inject.Inject
import kotlin.random.Random

class SomeInterfaceImpl @Inject constructor(private val someDataSource: SomeDataSource): SomeInterface {
    override fun exampleFunctionGetMessage(): String = someDataSource.exampleFunctionGetMessage()

    override fun exampleFunctionGetNumber(): Int = someDataSource.exampleFunctionGetNumber()

    override fun exampleFunctionGetBoolean(): Boolean = someDataSource.exampleFunctionGetBoolean()
}
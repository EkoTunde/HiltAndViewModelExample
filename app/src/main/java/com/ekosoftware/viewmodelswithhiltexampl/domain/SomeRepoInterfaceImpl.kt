package com.ekosoftware.viewmodelswithhiltexampl.domain

import com.ekosoftware.viewmodelswithhiltexampl.data.SomeDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SomeRepoInterfaceImpl @Inject constructor(private val someDataSource: SomeDataSource):
    SomeRepoInterface {
    override fun exampleFunctionGetMessage(): Flow<String> = someDataSource.exampleFunctionGetMessage()
    override fun exampleFunctionGetNumber(): Flow<Int> = someDataSource.exampleFunctionGetNumber()
    override fun exampleFunctionGetBoolean(): Flow<Boolean> = someDataSource.exampleFunctionGetBoolean()
}
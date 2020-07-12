package com.ekosoftware.viewmodelswithhiltexampl

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers.Default

class ExampleViewModel @ViewModelInject constructor(private val someInterface: SomeInterface) : ViewModel() {

    val message = liveData(Default) {
        val result = someInterface.exampleFunctionGetMessage()
        emit(result)
    }

    val number = liveData(Default) {
        val result = someInterface.exampleFunctionGetNumber()
        emit(result)
    }

    val boolean = liveData(Default) {
        val result = someInterface.exampleFunctionGetBoolean()
        emit(result)
    }

}
package com.ekosoftware.viewmodelswithhiltexampl.ui.model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ekosoftware.viewmodelswithhiltexampl.domain.SomeRepoInterface
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.flow.collect

class ExampleViewModel @ViewModelInject constructor(private val someRepoInterface: SomeRepoInterface) : ViewModel() {

    val message = liveData(Default) {
        someRepoInterface.exampleFunctionGetMessage().collect { result ->
            emit(result)
        }

    }

    val number = liveData(Default) {
        someRepoInterface.exampleFunctionGetNumber().collect { result ->
            emit(result)
        }
    }

    val boolean = liveData(Default) {
        someRepoInterface.exampleFunctionGetBoolean().collect { result ->
            emit(result)
        }

    }

}
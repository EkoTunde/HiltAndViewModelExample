package com.ekosoftware.viewmodelswithhiltexampl

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ExampleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tag = "DEBUG!!!"
        viewModel.message.observe(this, Observer {
            Log.d(tag, "onCreate: message is -> $it")
        })
        viewModel.number.observe(this, Observer {
            Log.d(tag, "onCreate: number is -> $it")
        })
        viewModel.boolean.observe(this, Observer {
            Log.d(tag, "onCreate: boolean is -> $it")
        })
    }
}
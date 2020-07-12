package com.ekosoftware.viewmodelswithhiltexampl

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ekosoftware.viewmodelswithhiltexampl.databinding.ActivityMainBinding
import com.ekosoftware.viewmodelswithhiltexampl.ui.model.ExampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<ExampleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this@MainActivity, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
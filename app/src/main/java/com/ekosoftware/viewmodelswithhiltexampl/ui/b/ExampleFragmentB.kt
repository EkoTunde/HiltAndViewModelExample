package com.ekosoftware.viewmodelswithhiltexampl.ui.b

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ekosoftware.viewmodelswithhiltexampl.R
import com.ekosoftware.viewmodelswithhiltexampl.databinding.FragmentExampleBBinding
import com.ekosoftware.viewmodelswithhiltexampl.ui.model.ExampleViewModel

class ExampleFragmentB : Fragment() {

    private var _binding: FragmentExampleBBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ExampleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExampleBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()
        binding.btnToA.setOnClickListener { findNavController().navigateUp() }
    }

    private fun attachObservers() {
        val tag = "DEBUG!!!"
        viewModel.message.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "FragmentB: message is -> $it")
            val txt = "$it ${it.hashCode()}"
            binding.txtMessage.text = txt
        })
        viewModel.number.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "FragmentB: number is -> $it")
            binding.txtNumber.text = it.toString()
        })
        viewModel.boolean.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "FragmentB: boolean is -> $it")
            binding.txtBoolean.text = it.toString()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
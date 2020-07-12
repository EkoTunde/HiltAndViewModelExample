package com.ekosoftware.viewmodelswithhiltexampl.ui.a

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
import com.ekosoftware.viewmodelswithhiltexampl.databinding.FragmentExampleABinding
import com.ekosoftware.viewmodelswithhiltexampl.ui.model.ExampleViewModel

class ExampleFragmentA : Fragment() {

    private var _binding: FragmentExampleABinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ExampleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExampleABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()
        binding.btnToB.setOnClickListener { goToB() }
    }

    private fun attachObservers() {
        println(true)
        val tag = "DEBUG!!!"
        viewModel.message.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "onCreate: message is -> $it")
            binding.txtMessage.text = it
        })
        viewModel.number.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "onCreate: number is -> $it")
            binding.txtNumber.text = it.toString()
        })
        viewModel.boolean.observe(viewLifecycleOwner, Observer {
            Log.d(tag, "onCreate: boolean is -> $it")
            binding.txtBoolean.text = it.toString()
        })
    }

    private fun goToB() {
        findNavController().navigate(R.id.action_exampleFragmentA_to_exampleFragmentB)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
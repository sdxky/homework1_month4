package com.example.lessonn1m4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lessonn1m4.databinding.FragmentMainBinding
import com.example.lessonn1m4.ui.data.models.User

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonSend.setOnClickListener {


            val email = binding.etEmail.text.toString()

            if (email.contains("@")) {
                User(
                    name = binding.etName.text.toString(),
                    email = email,
                    password = binding.etPassword.text.toString()
                )
                findNavController().navigate(MainFragmentDirections.actionRegistrationToDetails(User()))
            } else {
                Toast.makeText(requireContext(), "Некорректный адрес электронной почты", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

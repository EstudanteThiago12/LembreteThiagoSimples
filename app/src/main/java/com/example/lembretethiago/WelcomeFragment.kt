package com.example.lembretethiago

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lembretethiago.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {

            val nomeDigitado = binding.nomeEdt.text.toString()
            val sobrenomeDigitado = binding.sobrenomeEdt.text.toString()
            val nomeCompleto = nomeDigitado + " " + sobrenomeDigitado

            val bundle = Bundle().apply {
                putString("NOME_USUARIO" , nomeCompleto)
            }
            findNavController().navigate(R.id.action_WelcomeFragment_to_LembreteFragment, bundle)


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
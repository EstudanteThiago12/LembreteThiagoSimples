package com.example.lembretethiago

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lembretethiago.databinding.FragmentCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CadastroFragment : Fragment() {

    private var _binding: FragmentCadastroBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        auth = Firebase.auth

        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVoltarCad.setOnClickListener() {
            findNavController().navigate(R.id.action_CadastroFragment_to_WelcomeFragment)
        }
        binding.btnCadastrarCad.setOnClickListener {

            val CadNome = binding.tvNomeCad.text.toString()
            val CadEmail = binding.tvEmailCad.text.toString()
            val CadSenha = binding.tvSenhaCad.text.toString()

            auth.createUserWithEmailAndPassword(CadEmail, CadSenha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Debug", "createUserWithEmail:success")
                        findNavController().navigate(R.id.action_CadastroFragment_to_WelcomeFragment)
                    } else {
                        val exception = task.exception
                        if (exception is FirebaseAuthException) {
                            val errorMessage = exception.message ?: "Erro no cadastro"
                        }
                    }
                }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
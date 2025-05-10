package com.example.lembretethiago

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lembretethiago.databinding.FragmentLembreteBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LembreteFragment : Fragment() {

    private var _binding: FragmentLembreteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLembreteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stringArg = arguments?.getString("NOME_USUARIO")
        binding.NomeTxv.setText("Olá, " + stringArg)

        lateinit var sharedPreferences: SharedPreferences

        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val editar = sharedPreferences.edit()

        val salvar =  sharedPreferences.getString("TEXTO_SALVO", "")

        binding.TextoDigitado.setText(salvar)

        binding.buttonDeletar.setOnClickListener() {
            binding.TextoDigitado.text?.clear()
            editar.clear().commit()
        }

        binding.buttonSalvar.setOnClickListener(){
            val texto = binding.TextoDigitado.text.toString()
            Toast.makeText(context, "Texto salvo com sucesso!", Toast.LENGTH_SHORT).show()
            editar.putString("TEXTO_SALVO",texto).apply()
        }

        binding.buttonVoltar.setOnClickListener(){
            findNavController().navigate(R.id.action_LembreteFragment_to_WelcomeFragment)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

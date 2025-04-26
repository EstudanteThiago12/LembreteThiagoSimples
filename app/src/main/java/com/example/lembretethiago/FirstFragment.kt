package com.example.lembretethiago

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.text.set
import androidx.navigation.fragment.findNavController
import com.example.lembretethiago.databinding.FragmentFirstBinding
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

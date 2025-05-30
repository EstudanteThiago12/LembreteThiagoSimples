package com.example.lembretethiago

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lembretethiago.databinding.FragmentWelcomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.SharedPreferences


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    private lateinit var context: Context

    private lateinit var auth: FirebaseAuth

    private var _binding: FragmentWelcomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        auth = Firebase.auth

        context = requireContext()

        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharep = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val edit = sharep.edit()

        binding.buttonSecond.setOnClickListener {

            val emailUsuario = binding.nomeEdt.text.toString()
            val senhaUsuario = binding.sobrenomeEdt.text.toString()

            auth.signInWithEmailAndPassword(emailUsuario, senhaUsuario)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("DEBUG", "signInWithEmail:success")
                        val user = auth.currentUser
                        user?.getIdToken(true)?.addOnCompleteListener{ tokenTask ->
                            if(tokenTask.isSuccessful){
                                val  idToken = tokenTask.result?.token
                                if (!idToken.isNullOrEmpty()){
                                    edit.putString("token", idToken).apply()
                                    findNavController().navigate(R.id.action_WelcomeFragment_to_LembreteFragment)
                                }
                            }

                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("WARNING", "signInWithEmail:failure", task.exception)
                    }
                }

        }
        binding.buttonCadastro.setOnClickListener{
            findNavController().navigate(R.id.action_WelcomeFragment_to_CadastroFragment)
        }

        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
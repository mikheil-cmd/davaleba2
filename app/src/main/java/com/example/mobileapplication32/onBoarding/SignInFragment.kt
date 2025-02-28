package com.example.mobileapplication32.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileapplication32.MainFragment
import com.example.mobileapplication32.R
import com.example.mobileapplication32.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding : FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        tvForgotPasswordSignIn.setOnClickListener {
            loadFragment(ForgotPasswordFragment.newInstance())
        }

        btnSignIn.setOnClickListener {
            val email = etEmailSignIn.text.toString()
            val password = etPasswordSignIn.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //firebase auth TODO()

            loadFragment(MainFragment.newInstance())

        }

        tvSignUpSignIn.setOnClickListener {
            loadFragment(SignUpFragment.newInstance())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, fragment)
            .addToBackStack(null)
            .commit()
    }


    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
    }
}
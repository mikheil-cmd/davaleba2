package com.example.mobileapplication32.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileapplication32.MainFragment
import com.example.mobileapplication32.R
import com.example.mobileapplication32.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        btnSignUp.setOnClickListener {
            val email = etEmailSignUp.text.toString()
            val password = etPasswordSignUp.text.toString()

            if (email.isEmpty() || password.isEmpty()
                || password.contains(' ') || password.length < 5){
                Toast.makeText(requireContext(), "error!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //firebase auth TODO()

            loadFragment(MainFragment.newInstance())

        }

        tvSignInSignUp.setOnClickListener {
            loadFragment(SignInFragment.newInstance())
        }
    }

    private fun loadFragment(f: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.placeHolder, f).commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
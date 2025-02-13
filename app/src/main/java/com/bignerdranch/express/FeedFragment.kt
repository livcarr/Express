package com.bignerdranch.express

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bignerdranch.express.databinding.FragmentLoginBinding

class FeedFragment: Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null, is the view visible?"
        }

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
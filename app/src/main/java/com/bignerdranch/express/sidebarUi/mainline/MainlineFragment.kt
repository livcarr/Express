package com.bignerdranch.express.sidebarUi.mainline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bignerdranch.express.databinding.FragmentLoginBinding
import com.bignerdranch.express.databinding.FragmentMainlineBinding

class MainlineFragment: Fragment() {
    private var _binding: FragmentMainlineBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null, is the view visible?"
        }

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainlineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
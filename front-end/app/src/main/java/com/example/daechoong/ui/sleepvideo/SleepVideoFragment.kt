package com.example.daechoong.ui.sleepvideo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daechoong.databinding.FragmentMycalendarBinding
import com.example.daechoong.databinding.FragmentMyprofileBinding
import com.example.daechoong.databinding.FragmentSleepvideoBinding

class SleepVideoFragment: Fragment() {
    lateinit var binding: FragmentSleepvideoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSleepvideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {

    }
}
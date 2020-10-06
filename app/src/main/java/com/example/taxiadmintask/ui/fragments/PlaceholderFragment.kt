package com.example.taxiadmintask.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.databinding.FragmentMainBinding
import com.example.taxiadmintask.ui.adapter.OrdersViewAdapter
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.weatherapp.utils.Resource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import java.io.Serializable

//class PlaceholderFragment : Fragment() {
//
//    private var _binding: FragmentMainBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentMainBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//}
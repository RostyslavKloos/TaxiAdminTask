package com.example.taxiadmintask.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taxiadmintask.databinding.FragmentMainBinding
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.taxiadmintask.utils.SessionManager
import com.example.weatherapp.utils.Resource.Status.*

class PlaceholderFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var pageViewModel: PageViewModel
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)

        arguments?.getString(SECTION_TOKEN)?.let { pageViewModel.setIndex(it) }
        pageViewModel.currentToken.observe(viewLifecycleOwner, {

            //Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
    }

    companion object {

        private const val SECTION_TOKEN = "section_token"

        @JvmStatic
        fun newInstance(token: String?): PlaceholderFragment {
            return PlaceholderFragment().apply {

            }
        }
    }
}
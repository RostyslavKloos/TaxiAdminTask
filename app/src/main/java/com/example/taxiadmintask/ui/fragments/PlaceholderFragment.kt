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
import com.example.taxiadmintask.databinding.FragmentMainBinding
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import java.io.Serializable


class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvTest.text = arguments?.getString("TOKEN")

        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)

//       binding.tvTest.text = arguments?.getString("token").toString().apply {
//           Toast.makeText(requireContext(), this, Toast.LENGTH_SHORT ).show()
//           Log.i("LOL", this )
//       }
        binding.tvTest.text = arguments?.getSerializable("postResponse").toString().apply {
            Toast.makeText(requireContext(), this, Toast.LENGTH_SHORT ).show()
        }
    }

    companion object{

//        fun newInstance(token: String): PlaceholderFragment{
//            val args = Bundle()
//            args.putString("token", token)
//            val fragment = PlaceholderFragment()
//            fragment.arguments = args
//            return fragment
//        }

        fun newInstance(token: Serializable): PlaceholderFragment{
            val args = Bundle()
            args.putSerializable("postResponse", token)
            val fragment = PlaceholderFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
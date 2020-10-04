package com.example.taxiadmintask.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.taxiadmintask.R
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.ui.adapter.SectionsPagerAdapter
import com.example.taxiadmintask.ui.fragments.PlaceholderFragment
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.weatherapp.utils.Resource
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        fragmentTransaction = supportFragmentManager.beginTransaction()
        setupUI()

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
            override fun onPageSelected(i: Int) {

                val token = (viewPager.adapter as SectionsPagerAdapter).getPageTitle(i).toString()
                val bundle = Bundle()

                pageViewModel.getPostResponse(Types(types = listOf(1)), "Bearer $token").observe(this@MainActivity, {

                    it?.let {
                        it.data?.let {
                            when (it.status) {
                                Resource.Status.SUCCESS -> {
                                    bundle.putSerializable("postResponse", it.data )

                                }
                                Resource.Status.LOADING -> {

                                }
                                Resource.Status.ERROR -> {
                                }
                            }
                        }
                    }
                })
                //Log.i("tes:", "${(viewPager.adapter as SectionsPagerAdapter).getPageTitle(i)}" )
            }

            override fun onPageScrollStateChanged(i: Int) {
            }
        })
    }
    private fun fetchData(token: String) {

    }

    private fun setupUI() {
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)
    }
}
package com.example.taxiadmintask

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.ui.adapter.SectionsPagerAdapter
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.taxiadmintask.utils.SessionManager
import com.example.weatherapp.utils.Resource
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        setupUI()

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
            override fun onPageSelected(i: Int) {
                val token = (viewPager.adapter as SectionsPagerAdapter).getPageTitle(i).toString()
                Log.i("TAT", "BLA")
                pageViewModel.getPostResponse(Types(types = listOf(1)), "Bearer $token").observe(this@MainActivity, {
                    it?.let {
                        it.data?.let {
                            when (it.status) {
                                Resource.Status.SUCCESS -> {
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
package com.example.taxiadmintask.ui.activity

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.taxiadmintask.R
import com.example.taxiadmintask.ui.adapter.ServiceViewAdapter
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.taxiadmintask.utils.SessionManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        initViewPager2()
    }

    private fun initViewPager2() {
        viewPager = findViewById(R.id.view_pager)
        //adapter = SectionsPagerAdapter(this, supportFragmentManager, lifecycle)
        val sessionManager =  SessionManager(applicationContext)
        val tokens = sessionManager.fetchAuthToken()
        val adapter = tokens?.let { ServiceViewAdapter(it, pageViewModel, lifecycle, this) }

        viewPager.adapter = adapter
        tabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager){
            tab, position ->
            val token = adapter?.tokens?.elementAt(position)
            tab.text = token

        }.attach()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
              //  Toast.makeText(this@MainActivity, "${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
               // Toast.makeText(this@MainActivity, "${tab?.text} unselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //Toast.makeText(this@MainActivity, "${tab?.text} reselected", Toast.LENGTH_SHORT).show()
            }
        })
    }
}





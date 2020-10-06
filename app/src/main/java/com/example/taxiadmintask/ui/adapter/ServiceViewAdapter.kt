package com.example.taxiadmintask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.taxiadmintask.R
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.ui.viewModel.PageViewModel
import com.example.weatherapp.utils.Resource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.view.*

class ServiceViewAdapter(
    val tokens: MutableSet<String>,
    private val pageViewModel: PageViewModel,
    private val lf: Lifecycle,
    private val context: Context
) : RecyclerView.Adapter<ItemViewHolder>(),
    LifecycleOwner {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val token = tokens.elementAt(position)
        val types = Types(types = listOf(1, 2, 3))
        pageViewModel.getPostResponse(types, "Bearer $token").observe(this, {
            it?.let {
                it.data?.let {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            viewPager = holder.itemView.findViewById(R.id.vp_viewPager)
                            tabLayout = holder.itemView.findViewById(R.id.tl_tabs)
                            viewPager.adapter =
                                OrdersViewAdapter(types.types, it.data!!, context, types)
                            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                                tab.text = when (position) {
                                    0 -> "New Orders"
                                    1 -> "Waiting"
                                    2 -> "In Action"
                                    else -> ""
                                }
                            }.attach()

                            holder.itemView.pb_main.visibility = ProgressBar.GONE
                        }
                        Resource.Status.LOADING -> {
                            holder.itemView.pb_main.visibility = ProgressBar.VISIBLE
                        }
                        Resource.Status.ERROR -> {
                        }
                    }
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return tokens.size
    }

    override fun getLifecycle(): Lifecycle {
        return lf
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


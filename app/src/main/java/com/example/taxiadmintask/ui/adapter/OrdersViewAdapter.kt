package com.example.taxiadmintask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.Types
import com.example.taxiadmintask.databinding.OrderLayoutBinding
import kotlinx.android.synthetic.main.order_layout.view.*

class OrdersViewAdapter(
    private val list: List<Int>,
    private val postResponse: PostResponse,
    private val context: Context,
    private val types: Types
) : RecyclerView.Adapter<OrdersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding: OrderLayoutBinding = OrderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val response = postResponse
        val count = postResponse.response.size

        if (types.types[position] == response.response[position].type) {
            holder.itemView.rv_orders.layoutManager = LinearLayoutManager(context)
            holder.itemView.rv_orders.adapter = CurrentOrderAdapter(response, count)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class OrdersViewHolder(itemBinding: OrderLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root)

package com.example.taxiadmintask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taxiadmintask.data.model.PostResponse
import com.example.taxiadmintask.data.model.Response
import com.example.taxiadmintask.databinding.OrderItemBinding
import kotlinx.android.synthetic.main.order_item.view.*

class CurrentOrderAdapter(
    private val currentResponse: PostResponse,
    private val size: Int,
) : RecyclerView.Adapter<CurrentItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentItemViewHolder {
        val binding: OrderItemBinding =
            OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrentItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrentItemViewHolder, position: Int) {
        holder.itemView.tv_id.text = currentResponse.response[position].id.toString()
        //holder.itemView.tv_time.text = currentResponse.response[position].dateTime
        holder.itemView.tv_phone.text = currentResponse.response[position].phone
        holder.itemView.tv_way.text = currentResponse.response[position].routes[0].home
        holder.itemView.tv_price.text = currentResponse.response[position].price
        holder.itemView.tv_comment.text = currentResponse.response[position].comment
    }

    override fun getItemCount(): Int {
        return size
    }
}

class CurrentItemViewHolder(itemBinding: OrderItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root)

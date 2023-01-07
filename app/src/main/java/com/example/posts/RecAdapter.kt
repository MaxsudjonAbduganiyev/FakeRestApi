package com.example.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.databinding.ItemLayoutBinding

class RecAdapter:ListAdapter<Posts,RecAdapter.MyViewHolder>(diffUtil) {


    class MyViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffUtil=object :DiffUtil.ItemCallback<Posts>(){
            override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=getItem(position)
        holder.binding.userid.text=item.userId.toString()
        holder.binding.id.text=item.id.toString()
        holder.binding.title.text=item.title
        holder.binding.body.text=item.body
    }

}
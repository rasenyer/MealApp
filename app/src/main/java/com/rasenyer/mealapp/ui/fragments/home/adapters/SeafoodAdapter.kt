package com.rasenyer.mealapp.ui.fragments.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rasenyer.mealapp.R
import com.rasenyer.mealapp.databinding.ItemSeafoodBinding
import com.rasenyer.mealapp.data.remote.models.Category
import com.rasenyer.mealapp.ui.fragments.home.HomeFragmentDirections

class SeafoodAdapter: RecyclerView.Adapter<SeafoodAdapter.MyViewHolder>() {

    private var categoryList = ArrayList<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemSeafoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        val category = categoryList[position]

        myViewHolder.binding.mImageView.load(category.url){
            placeholder(R.color.purple_200)
            error(R.color.purple_200)
            crossfade(true)
            crossfade(400)
        }
        myViewHolder.binding.mTextViewName.text = category.name

        myViewHolder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(category)
            it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class MyViewHolder(val binding: ItemSeafoodBinding): RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun setCategoryList(newCategoryList: ArrayList<Category>) {

        categoryList = newCategoryList
        notifyDataSetChanged()

    }

}
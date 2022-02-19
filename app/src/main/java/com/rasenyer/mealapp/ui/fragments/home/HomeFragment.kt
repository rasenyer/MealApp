package com.rasenyer.mealapp.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.rasenyer.mealapp.data.remote.models.Category
import com.rasenyer.mealapp.databinding.FragmentHomeBinding
import com.rasenyer.mealapp.ui.fragments.home.adapters.DessertAdapter
import com.rasenyer.mealapp.ui.fragments.home.adapters.SeafoodAdapter
import com.rasenyer.mealapp.ui.fragments.home.adapters.VegetarianAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var seafoodAdapter: SeafoodAdapter
    private lateinit var vegetarianAdapter: VegetarianAdapter
    private lateinit var dessertAdapter: DessertAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        seafoodAdapter = SeafoodAdapter()
        vegetarianAdapter = VegetarianAdapter()
        dessertAdapter = DessertAdapter()

        homeViewModel.getSeafoodCategoryList("Seafood")
        observeSeafoodCategoryList()
        setUpRecyclerViewSeafood()

        homeViewModel.getVegetarianCategoryList("Vegetarian")
        observeVegetarianCategoryList()
        setUpRecyclerViewVegetarian()

        homeViewModel.getDessertCategoryList("Dessert")
        observeDessertCategoryList()
        setUpRecyclerViewDessert()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeSeafoodCategoryList() {

        homeViewModel.observeSeafoodCategoryList().observe(viewLifecycleOwner) {
            seafoodAdapter.setCategoryList(it as ArrayList<Category>)
        }

    }

    private fun setUpRecyclerViewSeafood() {

        binding.mRecyclerViewSeafood.apply {
            adapter = seafoodAdapter
        }

    }


    private fun observeVegetarianCategoryList() {

        homeViewModel.observeVegetarianCategoryList().observe(viewLifecycleOwner) {
            vegetarianAdapter.setCategoryList(it as ArrayList<Category>)
        }

    }

    private fun setUpRecyclerViewVegetarian() {

        binding.mRecyclerViewVegetarian.apply {
            adapter = vegetarianAdapter
        }

    }


    private fun observeDessertCategoryList() {

        homeViewModel.observeDessertCategoryList().observe(viewLifecycleOwner) {
            dessertAdapter.setCategoryList(it as ArrayList<Category>)
        }

    }

    private fun setUpRecyclerViewDessert() {

        binding.mRecyclerViewDessert.apply {
            adapter = dessertAdapter
        }

    }


}
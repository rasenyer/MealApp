package com.rasenyer.mealapp.ui.fragments.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.rasenyer.mealapp.R
import com.rasenyer.mealapp.data.remote.models.Category
import com.rasenyer.mealapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private val detailFragmentArgs: DetailFragmentArgs by navArgs()
    private lateinit var currentCategory: Category
    private lateinit var linkVideo: String

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        currentCategory = detailFragmentArgs.category!!

        detailViewModel.getMealById(currentCategory.id)
        observerMeal()

        binding.mRelativeLayout.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkVideo))
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun observerMeal() {

        detailViewModel.observerMeal().observe(viewLifecycleOwner) {

            binding.mImageView.load(it.linkImage){
                placeholder(R.color.purple_200)
                error(R.color.purple_200)
                crossfade(true)
                crossfade(400)
            }
            binding.mTextViewName.text = it.name
            binding.mTextViewInstructions.text = it.instructions
            binding.mTextViewCategory.text = resources.getString(R.string.category) + it.category
            binding.mTextViewArea.text = resources.getString(R.string.area) + it.area

            linkVideo = it.linkVideo

        }

    }

}
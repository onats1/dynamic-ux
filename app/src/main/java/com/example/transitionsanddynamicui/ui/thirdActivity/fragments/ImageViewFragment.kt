package com.example.transitionsanddynamicui.ui.thirdActivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.models.imageData.ImageSource
import kotlinx.android.synthetic.main.fragment_image_layout.*

class ImageViewFragment(position: Int) : Fragment() {

     var position: Int = 0

    init {
        this.position = position
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(context!!)
            .load(ImageSource.getImages()[position])
            .into(image)

    }


    companion object{
        fun newInstance(position: Int) = ImageViewFragment(position)
    }

}
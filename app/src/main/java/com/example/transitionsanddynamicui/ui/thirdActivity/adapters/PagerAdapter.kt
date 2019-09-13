package com.example.transitionsanddynamicui.ui.thirdActivity.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.transitionsanddynamicui.models.imageData.ImageSource
import com.example.transitionsanddynamicui.ui.thirdActivity.GridToPager
import com.example.transitionsanddynamicui.ui.thirdActivity.fragments.ImageViewFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return ImageViewFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return ImageSource.getImages().size
    }


}
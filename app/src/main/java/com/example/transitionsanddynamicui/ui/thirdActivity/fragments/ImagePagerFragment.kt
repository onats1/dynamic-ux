package com.example.transitionsanddynamicui.ui.thirdActivity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.mainActivity.MainActivity
import com.example.transitionsanddynamicui.ui.thirdActivity.GridToPager
import com.example.transitionsanddynamicui.ui.thirdActivity.adapters.PagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ImagePagerFragment : Fragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = PagerAdapter(fragmentManager!!)
        view_pager.currentItem = GridToPager.currentImage

        view_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                GridToPager.currentImage = position
            }
        })


    }

}
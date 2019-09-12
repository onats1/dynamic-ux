package com.example.transitionsanddynamicui.ui.thirdActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.thirdActivity.fragments.ImageGridFragment

class GridToPager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_to_pager)

        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .add(
                R.id.fragment_container,
                ImageGridFragment(),
                ImageGridFragment::class.java!!.getSimpleName()
            )
            .commit()
    }
}

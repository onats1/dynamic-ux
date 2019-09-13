package com.example.transitionsanddynamicui.ui.fourthActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.fourthActivity.fragments.MotionsFragment
import kotlinx.android.synthetic.main.activity_motions.*

class MotionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motions)

        val motionsFragment = MotionsFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, motionsFragment, "")
            .commit()
    }
}

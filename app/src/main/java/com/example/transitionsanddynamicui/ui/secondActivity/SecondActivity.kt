package com.example.transitionsanddynamicui.ui.secondActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentTransaction
import com.example.transitionsanddynamicui.ConstantTags.BUTTON_TAG
import com.example.transitionsanddynamicui.ConstantTags.IMAGE_TAG
import com.example.transitionsanddynamicui.ConstantTags.SHARED_TEXT
import com.example.transitionsanddynamicui.ConstantTags.TEXT_TAG
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.secondActivity.fragments.BasicTransition
import com.example.transitionsanddynamicui.ui.secondActivity.fragments.CustomTransition
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), BasicTransition.OnFragmentInteractionListener, CustomTransition.OnFragmentInteractionListener {

    override fun onFragmentInteraction(view: View) {
      // basic_trans.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        ViewCompat.setTransitionName(imageView2, IMAGE_TAG)
        ViewCompat.setTransitionName(editText, TEXT_TAG)
        ViewCompat.setTransitionName(horizontalScrollView, BUTTON_TAG)

        editText.text = intent.getStringExtra(SHARED_TEXT)
    }






}

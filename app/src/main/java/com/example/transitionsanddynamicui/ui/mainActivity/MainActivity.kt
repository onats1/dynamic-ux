package com.example.transitionsanddynamicui.ui.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.transitionsanddynamicui.ConstantTags.BUTTON_TAG
import com.example.transitionsanddynamicui.ConstantTags.IMAGE_TAG
import com.example.transitionsanddynamicui.ConstantTags.SHARED_TEXT
import com.example.transitionsanddynamicui.ConstantTags.TEXT_TAG
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.secondActivity.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transition_button.setOnClickListener({onclick()})


    }

    fun onclick(){

        var finalText = editText.text.toString() + " " + editText2.text.toString()

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SHARED_TEXT, finalText)

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair(imageView, IMAGE_TAG),
            Pair(editText, TEXT_TAG), Pair(editText2, TEXT_TAG), Pair(transition_button, BUTTON_TAG))

        ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
    }

}

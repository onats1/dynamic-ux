package com.example.transitionsanddynamicui.ui.thirdActivity.fragments

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.R.transition.activity_transitions
import com.example.transitionsanddynamicui.R.transition.fade_out_transition
import com.example.transitionsanddynamicui.ui.fourthActivity.MotionsActivity
import com.example.transitionsanddynamicui.ui.mainActivity.MainActivity
import com.example.transitionsanddynamicui.ui.thirdActivity.GridToPager
import com.example.transitionsanddynamicui.ui.thirdActivity.adapters.GridAdapter
import com.example.transitionsanddynamicui.ui.thirdActivity.listeners.GridOnClickListener
import kotlinx.android.synthetic.main.fragment_grid_layout.*
import kotlinx.android.synthetic.main.image_list_item.view.*


class ImageGridFragment: Fragment(), GridOnClickListener {

    override fun onImageClick(position: Int, view: View) {

        GridToPager.currentImage = position

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementReturnTransition = TransitionInflater.from(activity).inflateTransition(
                activity_transitions
            )

            exitTransition =
                TransitionInflater.from(activity).inflateTransition(android.R.transition.explode)

        }

        val nextFrag = ImagePagerFragment()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            nextFrag.sharedElementReturnTransition =
                TransitionInflater.from(activity).inflateTransition(
                    activity_transitions
                )

         /*   nextFrag.exitTransition =
                TransitionInflater.from(activity).inflateTransition(fade_out_transition)*/

            nextFrag.exitTransition =
                TransitionInflater.from(activity).inflateTransition(android.R.transition.explode)
        }

        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, nextFrag, "findThisFragment")
            .addToBackStack(null)
            .addSharedElement(view.card_image, "shared_fragment_item")
            .commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_grid_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = GridAdapter(context!!, this)

        floatingActionButton?.setOnClickListener{
            val intent = Intent(context, MotionsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}
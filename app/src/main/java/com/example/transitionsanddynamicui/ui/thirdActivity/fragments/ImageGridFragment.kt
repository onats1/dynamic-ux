package com.example.transitionsanddynamicui.ui.thirdActivity.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.ui.thirdActivity.adapters.GridAdapter
import com.example.transitionsanddynamicui.ui.thirdActivity.listeners.GridOnClickListener
import kotlinx.android.synthetic.main.fragment_grid_layout.*

class ImageGridFragment: Fragment(), GridOnClickListener {



    override fun onImageClick(position: Int) {
        Toast.makeText(context, "$position!!", Toast.LENGTH_LONG).show()
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
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}
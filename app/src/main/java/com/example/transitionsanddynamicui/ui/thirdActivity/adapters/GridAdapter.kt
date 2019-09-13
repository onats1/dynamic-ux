package com.example.transitionsanddynamicui.ui.thirdActivity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.transitionsanddynamicui.R
import com.example.transitionsanddynamicui.models.imageData.ImageSource
import com.example.transitionsanddynamicui.ui.thirdActivity.listeners.GridOnClickListener
import kotlinx.android.synthetic.main.image_list_item.view.*



class GridAdapter() : RecyclerView.Adapter<GridAdapter.ImageViewHolder>() {

    val list = ImageSource.getImages()
    var onClickListener: GridOnClickListener? = null
    lateinit var context: Context
    var currentPosition = 0

    constructor(context: Context, gridInstance: GridOnClickListener) :this(){
        this.context = context
        onClickListener = gridInstance
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_list_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position])
            .into(holder.itemView.card_image)

        currentPosition = position

    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener{

                onClickListener?.let {
                    onClickListener!!.onImageClick(adapterPosition, itemView)
                   // Toast.makeText(context, "viewholder", Toast.LENGTH_LONG).show()
                }

            }
        }


    }
}
package com.blackdev.netflixprototype

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class carouselAdapter(private  val carouselList: List<carouselModel>,val interf : positionInterface): RecyclerView.Adapter<carouselAdapter.carouselViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): carouselViewHolder {
        val view:View  = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return carouselViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carouselList.size
    }

    override fun onBindViewHolder(holder: carouselViewHolder, position: Int) {
        holder.title.setText(carouselList.get(position).carouselTitle)
        holder.image.setImageResource(carouselList.get(position).imageID)
        holder.itemView.setOnClickListener {
            interf.getcarouselPosition(position)
                notifyDataSetChanged()
                Log.i("Position of element in carousel", "" + position)



        }
    }
    class carouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title:TextView  = itemView.findViewById(R.id.nameText)
        var image:ImageView = itemView.findViewById(R.id.imageBack)

    }



}
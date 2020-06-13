package com.blackdev.netflixprototype

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.TextView
import androidx.core.view.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import java.util.logging.Handler

class homePageAdapter(val homeList: List<homeModel>, val context:Context) : RecyclerView.Adapter<homePageAdapter.ViewHolder>(),positionInterface {

    val pool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.carousel_layout, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        holder.category.text = homeList[position].category
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.initialPrefetchItemCount = 5
        holder.recyclerView.layoutManager = layoutManager


        val positionInterf = object : positionInterface {
            override
            fun getcarouselPosition(position1: Int) {
                super.getcarouselPosition(position1)
                Log.i("position in home", "" + position + position1);

                val intent: Intent = Intent(context, SongActivity::class.java)
                    intent.putExtra("songID", homeList[position].carousel[position1].songID)
                    intent.putExtra("title", homeList[position].carousel[position1].carouselTitle)
                    intent.putExtra("imageID", homeList[position].carousel[position1].imageID)
                    context.startActivity(intent)



            }
        }



        holder.recyclerView.setRecycledViewPool(pool)
        holder.recyclerView.adapter = carouselAdapter(homeList[position].carousel, positionInterf)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), positionInterface {


        val recyclerView: RecyclerView = itemView.findViewById(R.id.carouselRecyclerView)
        val category: TextView = itemView.findViewById(R.id.category)


    }
}



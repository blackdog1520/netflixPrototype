package com.blackdev.netflixprototype

import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView =findViewById<RecyclerView>(R.id.HomePageRecylerView);
        val carouselList = mutableListOf<carouselModel>()
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao-remix",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao-remix",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao-remix",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao-remix",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.boxshot,"Bella ciao-2",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.bella,"Bella ciao-3",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.boxshot,"Bella ciao-4",R.raw.bellaciao))
        carouselList.add(carouselModel(R.drawable.boxshot,"Bella ciao-5",R.raw.bellaciao))

        val carouselList1 = mutableListOf<carouselModel>()
        carouselList1.add(carouselModel(R.drawable.bella,"Bella ciao-remix",R.raw.bellaciao))
        carouselList1.add(carouselModel(R.drawable.boxshot,"Bella ciao-2",R.raw.bellaciao))
        carouselList1.add(carouselModel(R.drawable.bella,"Bella ciao-3",R.raw.bellaciao))
        carouselList1.add(carouselModel(R.drawable.boxshot,"Stranger Things",R.raw.bellaciao))
        carouselList1.add(carouselModel(R.drawable.boxshot,"Bella ciao-5",R.raw.bellaciao))
        carouselList1.add(carouselModel(R.drawable.bella,"Bella ciao",R.raw.bellaciao))


        val carouselList2 = mutableListOf<carouselModel>()
        carouselList2.add(carouselModel(R.drawable.bella,"Bella ciao",R.raw.bellaciao))
        carouselList2.add(carouselModel(R.drawable.boxshot,"Bella ciao-2",R.raw.bellaciao))
        carouselList2.add(carouselModel(R.drawable.boxshot,"Bella ciao-10",R.raw.bellaciao))

        carouselList2.add(carouselModel(R.drawable.boxshot,"Bella ciao new",R.raw.bellaciao))

        carouselList2.add(carouselModel(R.drawable.bella,"Bella ciao-3",R.raw.bellaciao))
        carouselList2.add(carouselModel(R.drawable.boxshot,"Bella ciao-4",R.raw.bellaciao))
        carouselList2.add(carouselModel(R.drawable.boxshot,"Bella ciao-5",R.raw.bellaciao))


        val homeList = mutableListOf<homeModel>()
        homeList.add(homeModel("First",carouselList))
        homeList.add(homeModel("Second",carouselList1))
        homeList.add(homeModel("Fourth",carouselList2))
        homeList.add(homeModel("Fifth",carouselList1))
        homeList.add(homeModel("Sixth",carouselList))
        homeList.add(homeModel("Seventh",carouselList2))
        homeList.add(homeModel("Eight",carouselList))
        homeList.add(homeModel("Nineth",carouselList))
        homeList.add(homeModel("Tenth",carouselList2))
        val layout = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val adapter = homePageAdapter(homeList,this)
        layout.initialPrefetchItemCount= 6
        recyclerView.layoutManager = layout
        recyclerView.adapter = adapter
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }







}

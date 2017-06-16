package com.lynnard.kotlinproject.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lynnard.kotlinproject.R
import com.lynnard.kotlinproject.adapter.KotlinRecyclerAdapter
import com.lynnard.kotlinproject.helpers.DatabaseHandler

/**
 * Created by gerard on 6/16/2017.
 */


class ToBuyFragment : Fragment(){

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : KotlinRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater!!.inflate(R.layout.fragment_to_buy, container, false)
        recyclerView = v.findViewById(R.id.toBuyRecyclerView) as RecyclerView
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = KotlinRecyclerAdapter(DatabaseHandler(context).allItems, context)
    }
}
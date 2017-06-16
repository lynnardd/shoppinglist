package com.lynnard.kotlinproject.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.lynnard.kotlinproject.R
import com.lynnard.kotlinproject.adapter.ViewPagerAdapter
import com.lynnard.kotlinproject.fragments.BoughtFragment
import com.lynnard.kotlinproject.fragments.ToBuyFragment

/**
 * Created by gerard on 6/16/2017.
 */
class ShoppingActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var viewPagerAdapter : ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) = setContentView(R.layout.activity_shopping)

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()

        viewPager = findViewById(R.id.shoppingViewPager) as ViewPager
        viewPagerAdapter.addFragment(ToBuyFragment(), "To Buy")
        viewPagerAdapter.addFragment(BoughtFragment(), "Bought")
    }

    override fun onStop() {
        super.onStop()
    }


}
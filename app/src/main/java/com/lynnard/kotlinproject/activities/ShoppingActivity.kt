package com.lynnard.kotlinproject.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.TableLayout
import com.lynnard.kotlinproject.R
import com.lynnard.kotlinproject.adapter.ViewPagerAdapter
import com.lynnard.kotlinproject.fragments.BoughtFragment
import com.lynnard.kotlinproject.fragments.ToBuyFragment

/**
 * Created by gerard on 6/16/2017.
 */
class ShoppingActivity : AppCompatActivity() {

    private lateinit var tabs : TabLayout
    private lateinit var viewPager : ViewPager
    private lateinit var viewPagerAdapter : ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(R.layout.activity_shopping)

        tabs = findViewById(R.id.tabs) as TabLayout
        viewPager = findViewById(R.id.shoppingViewPager) as ViewPager

        viewPager  = ViewPager(this@ShoppingActivity)

        val fragments : ArrayList<Fragment> = ArrayList()
        fragments.add(ToBuyFragment())
        fragments.add(BoughtFragment())
        val titles : ArrayList<String> = ArrayList()
        titles.add("To Buy")
        titles.add("Bought")

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments, titles)

        viewPager.adapter = viewPagerAdapter


        tabs = TabLayout(this@ShoppingActivity)
        tabs.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()
    }


}
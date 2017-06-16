package com.lynnard.kotlinproject.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by gerard on 6/16/2017.
 */
class ViewPagerAdapter(fragmentManager: FragmentManager, private val fragments : ArrayList<Fragment>, private val titles : ArrayList<String>) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence = titles[position]

    fun addFragment(fragment:Fragment, title:String) {
        fragments.add(fragment)
        titles.add(title)
    }
}
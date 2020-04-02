package com.jaygoo.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jaygoo.demo.fragments.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var fragments: MutableList<BaseFragment> =
        ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        fragments.clear()
        fragments.add(SingleSeekBarFragment())
        fragments.add(RangeSeekBarFragment())
        fragments.add(StepsSeekBarFragment())
        fragments.add(VerticalSeekBarFragment())
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.layout_tab)
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
        for (s in types) {
            tabLayout.newTab().text = s
        }
    }

    private inner class PagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return types.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return types[position]
        }
    }

    companion object {
        private val types =
            arrayOf("SINGLE", "RANGE", "STEP", "VERTICAL")
    }
}
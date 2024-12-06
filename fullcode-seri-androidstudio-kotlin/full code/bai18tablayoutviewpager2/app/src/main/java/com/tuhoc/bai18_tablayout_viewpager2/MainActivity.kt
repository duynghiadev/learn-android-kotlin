package com.tuhoc.bai18_tablayout_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adaptervv = ViewPagerAdapter(supportFragmentManager,lifecycle)
        pagerTest.adapter = adaptervv
        TabLayoutMediator(tabDemo,pagerTest){tab,pos->
            when(pos){
                0->{tab.text="Tab 1"}
                1->{tab.text="Tab 2"}
                2->{tab.text="Tab 3"}
                3->{tab.text="Tab 4"}
                4->{tab.text="Tab 5"}
            }
        }.attach()
    }
}
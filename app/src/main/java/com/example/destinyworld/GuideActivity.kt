package com.example.destinyworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GuideActivity : AppCompatActivity() {
    lateinit var viewpager:ViewPager2
    lateinit var tab: TabLayout
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        viewpager = findViewById(R.id.pager)
        tab = findViewById(R.id.tab_lay)
        button= findViewById(R.id.nextBtn)

        viewpager.adapter = VpAdapter(this, List.list)
        TabLayoutMediator(tab,viewpager){_,_ ->}.attach()

        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int){
                when(position){
                    2-> {
                        button.text = "Начать"
                    }
                    else->{
                        button.text="Далее"
                    }
                }
            }
        })
    }

    fun guide(view: android.view.View) {
        when(viewpager.currentItem){
            2->startActivity(Intent(this,SingUpActivity::class.java))
            else->viewpager.currentItem++
        }
    }
}
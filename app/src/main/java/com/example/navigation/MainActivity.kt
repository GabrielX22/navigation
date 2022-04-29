package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Collections.list

class MainActivity : AppCompatActivity() {
    class fragmentadapter (fragment:FragmentActivity,private val items:List<String>):FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return items.size

        }

        override fun createFragment(position: Int): Fragment {
            val primerfragmento=firstfragment()
            val segundofragmento=secondfragment()
            val tercerfragmento=thirdfragment()
            return when(position){
                0->primerfragmento
                1->segundofragmento
                2->tercerfragmento
                else->primerfragmento
            }

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list= listOf ("calendario","Himno","Notas")
        //val icons

        vista.adapter=fragmentadapter(this,list)

        TabLayoutMediator(menusito,vista){ tab, position->
            tab.text=list[position]


        }.attach()


    }
}
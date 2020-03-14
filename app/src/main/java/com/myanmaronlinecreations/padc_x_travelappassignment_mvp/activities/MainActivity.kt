package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.frgments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragemnt(HomeFragment.newInstance("Home","Home"))
        navigation_main.setOnNavigationItemSelectedListener (object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId) {
                    R.id.icon_home -> {
                        changeFragemnt(HomeFragment.newInstance("Home","Home"))
                        return true
                    }

                }

                return false
            }


        })

    }

    private fun changeFragemnt(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit()
    }

}

package com.myanmaronlinecreations.padc_x_travelappassignment_mvp.UiTests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.activities.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.frgments.HomeFragment
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder.CountryViewHolder
import com.myanmaronlinecreations.padc_x_travelappassignment_mvp.views.viewholder.ToursViewHolder
import kotlinx.android.synthetic.main.fragment_home.*


@RunWith(AndroidJUnit4ClassRunner::class)
class GotoToursDetailTest {
    private val activityTestRule= ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tabOnCart_navigateTocartList(){

       onView(withId(R.id.icon_home)).perform(click())


        Thread.sleep(2000)
        onView(withId(com.myanmaronlinecreations.padc_x_travelappassignment_mvp.R.id.recycler_country))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(1,
                    click()
                ))

        onView(withId(R.id.iv_detail))
            .check(matches(isDisplayed()))

    }
}
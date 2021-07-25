package com.gmail.okooko24816.contributorlist

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.VerificationMode
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.*
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf.allOf

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.espresso.ViewAction
import androidx.test.espresso.contrib.RecyclerViewActions
import com.gmail.okooko24816.contributorlist.adapter.MainAdapter
import org.hamcrest.Matcher


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule:IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)
    @Before
    fun setUp() {
    }

    @Test
    fun testIntent(){
        val button = onView(withId(R.id.all))
        button.perform(click())
        intended(
            allOf(
                hasComponent(hasShortClassName(".DetailActivity")),
                toPackage("com.gmail.okooko24816.contributorlist"),
                hasExtra("position",10000)
            )
        )
    }
    @Test
    fun onClickButtonInRecyclerView(){
        val recyclerView = onView(withId(R.id.contributor_names))
        var rand = (0..30).random()
        recyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<MainAdapter.MainViewHolder>(rand,MyViewAction.clickChildViewWithId(R.id.contributor_button))
        )
        intended(
            allOf(
                hasComponent(hasShortClassName(".DetailActivity")),
                toPackage("com.gmail.okooko24816.contributorlist"),
                hasExtra("position",rand)
            )
        )
    }
    @Test
    fun onCreate() {
    }

    @Test
    fun onStart() {
    }

    object MyViewAction {

        fun clickChildViewWithId(id: Int): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View>? {
                    return null
                }

                override fun getDescription(): String {
                    return ""
                }

                override fun perform(uiController: UiController, view: View) {
                    val v = view.findViewById<View>(id)
                    if (v != null) {
                        v.performClick()
                    }
                }
            }
        }
    }
}
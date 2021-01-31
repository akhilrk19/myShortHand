package com.example.myshorthand.Activity

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myshorthand.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun checkAppTitle() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.title_shorthand)).check(matches(isDisplayed()))

    }

    @Test
    fun addButton() {
        val activityScenario =ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.add_candidate)).check(matches(isDisplayed()))
    }

    @Test
    fun recyclerVisibility() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.recyclerView)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
    @Test
    fun activityNavigation() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.add_candidate)).perform(click())
        onView(withId(R.id.second_parent)).check(matches(isDisplayed()))
    }
}
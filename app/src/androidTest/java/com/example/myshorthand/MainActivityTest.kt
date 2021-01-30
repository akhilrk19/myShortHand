package com.example.myshorthand

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Assert.*
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
}
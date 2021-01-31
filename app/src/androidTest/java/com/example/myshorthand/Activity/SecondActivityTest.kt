package com.example.myshorthand.Activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.myshorthand.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun titleIsInView() {
        onView(withId(R.id.title_shorthand_second)).check(matches(isDisplayed()))

    }

    @Test
    fun isTitleSame() {
        onView(withId(R.id.title_shorthand_second)).check(matches(withText(R.string.app_name)))
    }

}
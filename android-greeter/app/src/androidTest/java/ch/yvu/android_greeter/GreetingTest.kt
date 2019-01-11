package ch.yvu.android_greeter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingTest {
    @get:Rule
    val activityRule = ActivityTestRule(GreetingActivity::class.java, false, true)

    @Test
    fun canGreet() {
        val name = "Mary"
        onView(withId(R.id.name)).perform(typeText(name))
        onView(withId(R.id.greetingButton)).perform(click())

        val expectedGreeting = activityRule.activity.resources.getString(R.string.greeting, name)
        onView(withText(expectedGreeting)).check(matches(isDisplayed()))
    }

    @Test
    fun showsErrorMessageWhenNoNameEntered() {
        onView(withId(R.id.greetingButton)).perform(click())

        onView(withText(R.string.errorNoNameEntered)).check(matches(isDisplayed()))
    }
}

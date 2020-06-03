package com.example.androidweekly

import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.androidweekly.ui.SplashFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
class SplashTest {

    @Test
    fun testSplashFragment(){
        // The "fragmentArgs" and "factory" arguments are optional.
        val fragmentArgs = Bundle().apply {
            putInt("selectedListItem", 0)
        }
        val factory = FragmentFactory()
        val scenario = launchFragmentInContainer<SplashFragment>( fragmentArgs, R.layout.fragment_splash, factory)
        scenario.onFragment {
            onView(withId(R.id.tv_splash))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.splash_title)))
        }
    }
}
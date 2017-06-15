package com.lynnard.kotlinproject;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /*@Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lynnard.kotlinproject", appContext.getPackageName());
    }*/

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False to customize the intent

    @Test
    public void intent() {
        Intent intent = new Intent();
        intent.putExtra("your_key", "your_value");

        activityRule.launchActivity(intent);

        // Continue with your test
    }
}

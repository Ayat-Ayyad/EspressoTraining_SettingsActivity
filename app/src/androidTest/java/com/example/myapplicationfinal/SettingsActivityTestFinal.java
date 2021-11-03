package com.example.myapplicationfinal;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.ext.junit.rules.ActivityScenarioRule.*;

import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Rule;
import org.junit.Test;

public class SettingsActivityTestFinal {
    @Rule
    public ActivityScenarioRule<SettingsActivity> mActivityTestRule = new ActivityScenarioRule<>(SettingsActivity.class);
    @Test
    public void testSignature(){
        onView(withText("Your signature")).perform(click());
        onView(withId(android.R.id.edit)).perform(clearText()).perform(typeText("Tala"));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withText("Tala")).check(matches(isDisplayed()));
    }

    @Test
    public void testReplyAction(){
        onView(withText("Default reply action")).perform(click());
        onView(withText("Reply to all")).perform(click());
        onView(withText("Reply to all")).check(matches(isDisplayed()));
    }
    @Test
    public void testToggleSwitch(){

        onView(withText("Download incoming attachments")).check(matches(not(isEnabled())));
        onView(withText("Sync email periodically")).perform(click());
        onView(withText("Download incoming attachments")).check(matches(isEnabled()));
    }


}

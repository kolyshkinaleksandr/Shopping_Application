package com.example.kolyshkin.shopping_application;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule= new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEnter() {
        onView(withId(R.id.first_activity_button)).perform(click());

        onView(withId(R.id.box_one)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_two)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_three)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_four)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_five)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_six)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_seven)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_eight)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_nine)).check(matches(isNotChecked())).perform(click());
        onView(withId(R.id.box_ten)).check(matches(isNotChecked())).perform(click());
        mainActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        onView(withId(R.id.submit_button)).perform(click());
        mainActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withId(R.id.value_1)).check(matches(withText("Chaddar")));
        onView(withId(R.id.value_2)).check(matches(withText("Camembert")));
        onView(withId(R.id.value_3)).check(matches(withText("Mozzarella")));
        onView(withId(R.id.value_4)).check(matches(withText("Parmezan")));
        onView(withId(R.id.value_5)).check(matches(withText("Provolone")));
        onView(withId(R.id.value_6)).check(matches(withText("Mascaprone")));
        onView(withId(R.id.value_7)).check(matches(withText("Manchego")));
        onView(withId(R.id.value_8)).check(matches(withText("Feta")));
        onView(withId(R.id.value_9)).check(matches(withText("Gruyere")));
        onView(withId(R.id.value_10)).check(matches(withText("Monterey Jack")));
        onView(withId(R.id.finish_activity_button)).perform(click());
    }
}

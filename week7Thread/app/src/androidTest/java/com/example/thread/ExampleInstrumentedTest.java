package com.example.thread;

import android.view.View;
import android.widget.ProgressBar;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    //如果使用Support包，需要替换为ActivityTestRule
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    public int getProgress(Matcher<View> matcher) {

        final int[] progress = {0};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(ProgressBar.class);
            }

            @Override
            public String getDescription() {
                return "progressBar";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ProgressBar bar = (ProgressBar)view;
                progress[0] = bar.getProgress();
            }
        });
        return progress[0];
    }

    @Test
    public void clickTest() {
        onView(withId(R.id.btn1)).perform(click());
        int progress = 0, progress2, count = 0;
        try {
            for(int i=0;i<=200;i++) {
                progress2 = getProgress(withId(R.id.progressBar1));
                if(i>0){
                    assertTrue(progress<=progress2 && progress2 <=progress+1);
                }
                progress = progress2;
                Thread.sleep(5);
            }
            System.out.println(progress);
            assertEquals(100, progress);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickTest2() {
        onView(withId(R.id.btn2)).perform(click());
        int progress = 0, progress2, count = 0;
        try {
            for(int i=0;i<=200;i++) {
                progress2 = getProgress(withId(R.id.progressBar2));
                if(i>0){
                    assertTrue(progress<=progress2 && progress2 <=progress+1);
                }
                progress = progress2;
                Thread.sleep(5);
            }
            System.out.println(progress);
            assertEquals(100, progress);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickTest3() {
        onView(withId(R.id.btn3)).perform(click());
        int progress = 0, progress2, count = 0;
        try {
            for(int i=0;i<=200;i++) {
                progress2 = getProgress(withId(R.id.progressBar3));
                if(i>0){
                    assertTrue(progress<=progress2 && progress2 <=progress+1);
                }
                progress = progress2;
                Thread.sleep(5);
            }
            System.out.println(count);
            assertEquals(100, progress);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

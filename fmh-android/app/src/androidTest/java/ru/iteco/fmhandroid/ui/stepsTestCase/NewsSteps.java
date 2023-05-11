package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;
import android.content.Intent;
import ru.iteco.fmhandroid.ui.dataTestCase.AboutData;
import ru.iteco.fmhandroid.ui.dataTestCase.NewsData;

public class NewsSteps {


    public static void clickCategory() {
        NewsData.selectCategory.perform(click());
    }

    public static void clickNewsFilterButton() {
        NewsData.newsFilterButton.perform(click());
    }
    public static void clickFilterButton() {
        NewsData.filterButton.perform(click());
    }

    public static void clickNotice() {
        NewsData.notice.perform(click());
    }

//    public static void clickSalary() {
//        NewsData.salary.perform(click());
//    }


}

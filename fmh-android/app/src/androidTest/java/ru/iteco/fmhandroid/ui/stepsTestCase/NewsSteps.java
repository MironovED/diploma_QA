package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.StringContains.containsString;

import ru.iteco.fmhandroid.ui.dataTestCase.NewsData;
import ru.iteco.fmhandroid.ui.utils.Helper;

public class NewsSteps {

    public static void clickNewsFilterButton() {
        NewsData.newsFilterButton.perform(click());
    }

    public static void clickFilterButton() {
        NewsData.filterButton.perform(click());
    }

    public static void selectCategory() {
        NewsData.fieldCategory.perform(click());
    }

    public static void insertCategory(String category) {
//        NewsData.fieldCategory.perform(replaceText(category), closeSoftKeyboard()).perform(click());
        onView(Helper.withIndex(withText(category), 0)).perform(click());
    }

    public static void checkFilter(String notice) {
        onView(Helper.withIndex(withText(notice), 0)).check(matches(isDisplayed()));;
    }

//    onView(withText(containsString(yourSearchFilter))).perform(click()).
//
//    Также, вероятно, существует withSubstring(text), который соответствует withText(containsString(text))




}



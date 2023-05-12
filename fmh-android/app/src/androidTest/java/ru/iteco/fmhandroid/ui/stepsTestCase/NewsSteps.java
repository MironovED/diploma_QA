package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;

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
//        onView(Helper.withIndex(withText(category), 0)).perform(click());
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public static void checkFilter(String notice) {
        onView(Helper.withIndex(withText(notice), 0)).check(matches(isDisplayed()));;
    }

    protected void clickOnListItemWithText(String text) {
        onView(withText(text))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }
//    onView(withText(containsString(yourSearchFilter))).perform(click()).
//
//    Также, вероятно, существует withSubstring(text), который соответствует withText(containsString(text))




}



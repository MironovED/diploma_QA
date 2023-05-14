package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Helper.hasItemAtPosition;

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

    public static void clickSortButton() {
        NewsData.sortNewsButton.perform(click());
    }

    public static void selectCategory() {
        NewsData.fieldCategory.perform(click());
    }

    public static void insertCategory(String category) {
        selectCategory();
        onView(withText(category)).inRoot(RootMatchers.isPlatformPopup()).perform(click());
    }

    public static void checkFilter(String notice) {
        onView(Helper.withIndex(withText(notice), 0)).check(matches(isDisplayed()));;
    }

    public static  void selectDateStart() {
        NewsData.fieldDateStart.perform(click());
        clickButtonOk();
    }

    public static  void selectDateEnd() {
        NewsData.fieldDateEnd.perform(click());
        clickButtonOk();
    }

    public static void clickButtonOk() {
        NewsData.buttonOkInFilter.perform(click());
    }

    public static void checkSort(){

        for(int i=0;i<=100;i++){
            NewsData.recyclerView.perform(swipeDown());
        }
        onView(hasItemAtPosition(hasDescendant(withText("01.01.001")), 0)).check(matches(isDisplayed()));
        onView(hasItemAtPosition(hasDescendant(withText("01.01.001")), 1)).check(matches(isDisplayed()));
    }


}



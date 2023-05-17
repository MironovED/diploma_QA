package ru.iteco.fmhandroid.ui.stepsTestCase;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.ui.dataTestCase.ClaimsData;

public class ClaimsSteps {

    public static void clickClaimsFilterButton() {
        ClaimsData.claimsFilterButton.perform(click());
    }

    public static void checkStatusClaim(String status) {
        ClaimsData.claimsStatus.check(matches(withText(status)));
    }

    public static void clickFirstClaim() {
        ClaimsData.recyclerView.perform(swipeDown());
        ClaimsData.firstClaims.perform(actionOnItemAtPosition(0, click()));
    }

    public static void clickCheckBoxOpen() {
        ClaimsData.filteringOpen.perform(click());
    }

    public static void clickCheckBoxInProgress() {
        ClaimsData.filteringInProgress.perform(click());
    }

    public static void clickCheckBoxExecuted() {
        ClaimsData.filteringExecuted.perform(click());
    }

    public static void clickCheckBoxCancelled() {
        ClaimsData.filteringCancelled.perform(click());
    }

    public static void clickButtonOkInFiltering() {
        ClaimsData.buttonOkInFiltering.perform(click());
    }

}

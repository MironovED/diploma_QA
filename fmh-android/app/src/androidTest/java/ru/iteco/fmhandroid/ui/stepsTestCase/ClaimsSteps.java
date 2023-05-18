package ru.iteco.fmhandroid.ui.stepsTestCase;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Helper.withItemText;

import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.rule.ActivityTestRule;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
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

    public static void insertExecutor() {
        ClaimsData.fieldExecutor.perform(click());
        onView(withText("Ivanov Ivan Ivanovich")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
    }

    public static void checkCreateClaim(String text) {
        onView(allOf(withId(R.id.claim_list_recycler_view))).perform(scrollTo(hasDescendant(withText(text))));
        onView(withItemText(text)).check(matches(isDisplayed()));
    }

    public static void checkShowWarning(ActivityTestRule<AppActivity> activityTestRule) {
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }

    public static void createClaim(String textTitle) {
        ClaimsData.buttonCreateClaim.perform(click());
        ClaimsData.fieldTitle.perform(click()).perform(replaceText(textTitle), closeSoftKeyboard());
        insertExecutor();
        ClaimsData.fieldDate.perform(click());
        ClaimsData.buttonOkInDateWindow.perform(click());
        ClaimsData.fieldTime.perform(click());
        ClaimsData.buttonOkInDateWindow.perform(click());
        ClaimsData.fieldDescription.perform(click()).perform(replaceText(textTitle), closeSoftKeyboard());
        ClaimsData.saveButton.perform(click());
        checkCreateClaim(textTitle);
    }

    public static void selectApplicationByDescription(String text) {
        onView(allOf(withId(R.id.claim_list_recycler_view))).perform(scrollTo(hasDescendant(withText(text))));
        onView(allOf(withId(R.id.claim_list_card), hasDescendant(withText(text)))).perform(click());

    }

    public static void clickButtonEditClaim() {
        ClaimsData.buttonEditClaim.perform(click());
    }

    public static void clickButtonEditStatus() {
        ClaimsData.buttonEditStatus.perform(click());
    }

    public static void editStatusThrowOff() {
        clickButtonEditStatus();
        onView(allOf(withId(android.R.id.title), withText("Throw off"))).perform(click());
        onView(allOf(withId(R.id.editText))).perform(click()).perform(click()).perform(replaceText("first comment"), closeSoftKeyboard());
        ClaimsData.buttonOkInDateWindow.perform(click());
    }
    public static void editStatusToExecute() {
        clickButtonEditStatus();
        onView(allOf(withId(android.R.id.title), withText("To execute"))).perform(click());
        onView(allOf(withId(R.id.editText))).perform(click()).perform(click()).perform(replaceText("first comment"), closeSoftKeyboard());
        ClaimsData.buttonOkInDateWindow.perform(click());
    }

    public static void editClaim(String textTitle, String textDesc) {
        ClaimsSteps.clickButtonEditClaim();
        ClaimsData.fieldTitle.perform(click()).perform(replaceText(textTitle), closeSoftKeyboard());
        ClaimsData.fieldDescription.perform(click()).perform(replaceText(textDesc), closeSoftKeyboard());
        ClaimsData.saveButton.perform(click());
    }

    public static void checkEditClaim(String textTitle, String textDesc) {
        onView(allOf(withId(R.id.title_text_view), withText(textTitle))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.description_text_view), withText(textDesc))).check(matches(isDisplayed()));
    }

    public static void  checkStatus(String status) {
        onView(allOf(withId(R.id.status_label_text_view), withText(status))).check(matches(isDisplayed()));
    }


}

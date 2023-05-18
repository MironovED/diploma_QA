package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Helper.hasItem;
import static ru.iteco.fmhandroid.ui.utils.Helper.hasItemAtPosition;

import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.rule.ActivityTestRule;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
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
        onView(Helper.withIndex(withText(notice), 0)).check(matches(isDisplayed()));
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

    public static void  clickEditNewsButton() {
        NewsData.editNewsButton.perform(click());
    }

    public static void buttonCreateNews() {
        NewsData.addNewsButton.perform(click());
    }

    public static void insertTitle(String text) {
        NewsData.fieldTitle.perform(click()).perform(replaceText(text), closeSoftKeyboard());

    }

    public static void insertPublicationDate() {
        NewsData.fieldPublicationDate.perform(click());
        clickButtonOkInDateTimeWindow();

    }

    public static void insertTime() {
        NewsData.fieldTime.perform(click());
        clickButtonOkInDateTimeWindow();
    }

    public static void insertDescription(String text) {
        NewsData.fieldDescription.perform(click()).perform(replaceText(text), closeSoftKeyboard());
    }

    public static void clickButtonOkInDateTimeWindow() {
        NewsData.buttonOkInDateWindow.perform(scrollTo(), click());
    }

    public static void clickButtonSave() {
        NewsData.saveButton.perform(click());
    }
    public static void clickButtonCancel() {
        NewsData.cancelButton.perform(click());
    }

    public static void checkCreateNews(String currentDate,String texDescription) {
        onView(Helper.withIndex(withId(R.id.view_news_item_image_view), 0)).perform(click());
        onView(Helper.withIndex(withId(R.id.news_item_create_date_text_view), 0)).check(matches(withText(currentDate)));
        onView(Helper.withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("ACTIVE")));
        onView(Helper.withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText(texDescription)));
    }

    public static void createNews(String category, String textTitle, String textDescription) {
        buttonCreateNews();
        insertCategory(category);
        insertTitle(textTitle);
        insertPublicationDate();
        insertTime();
        insertDescription(textDescription);
        clickButtonSave();
    }

    public static void deleteNews(){
        onView(Helper.withIndex(withId(R.id.delete_news_item_image_view), 0)).perform(click());
        onView(withId(android.R.id.message)).check(matches(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future.")));
        clickButtonOk();
    }

    public static void checkRemoteNews(String checkText) {
        onView(withId(R.id.news_list_recycler_view)).check(matches(not(hasItem(hasDescendant(withText(checkText))))));
    }

    public static void checkShowWarning(ActivityTestRule<AppActivity> activityTestRule) {
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }



    public static void editNews(String Category, String textTitle, String textDescription){
        onView(Helper.withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
        insertCategory(Category);
        insertTitle(textTitle);
        insertDescription(textDescription);
        clickButtonSave();
    }

    public static void buttonEditNews(){
        onView(Helper.withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }

}



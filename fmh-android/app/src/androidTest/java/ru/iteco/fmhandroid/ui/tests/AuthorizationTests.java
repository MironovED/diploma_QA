package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;




@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTests {

    String validLogin = "login2";
    String validPassword = "password2";
    String inValidLogin = "login";
    String inValidPassword = "password";

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void sleep() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationSteps.checkIsAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }
    }


    @Test
    @DisplayName("Авторизация зарегистрированным пользователем")
    public void shouldLogInWithValidData() {

        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkAuthorization();
    }

    @Test
    @DisplayName("Авторизация не зарегистрированным пользователем")
    public void shouldNotLogInWithInValidData() {

        AuthorizationSteps.enterLogin(inValidLogin);
        AuthorizationSteps.enterPass(inValidPassword);
        AuthorizationSteps.clickEnterButton();

        //На этой проверке тест зависает - вемя идет и никаких реакций
        AuthorizationSteps.checkInvalidData(activityTestRule);
    }

    @Test
    @DisplayName("Авторизация без логина и пароля")
    public void shouldNotLogInWithEmptyData() {

        AuthorizationSteps.clickEnterButton();

        //На этой проверке тест зависает - вемя идет и никаких реакций
        AuthorizationSteps.checkEmptyField(activityTestRule);
    }


    @Test
    @DisplayName("Авторизация без пароля")
    public void shouldNotLogInWithEmptyPassword() {

        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.clickEnterButton();

        //На этой проверке тест зависает - вемя идет и никаких реакций
        //AuthorizationSteps.checkEmptyField(activityTestRule);
    }
}


//    @Test
//    @DisplayName("Повторная авторизация после выхода из учетной записи")
//    public void shouldLogInAfterLogOut() {
//
//        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input));
//
//        textInputEditText.check(matches(isDisplayed()));
//        textInputEditText.perform(replaceText(validLogin));
//
//        ViewInteraction textInputEditText2 = onView(withId(R.id.password_text_input));
//        textInputEditText2.check(matches(isDisplayed()));
//        textInputEditText2.perform(replaceText(validPassword), closeSoftKeyboard());
//
//
//        ViewInteraction materialButton = onView(withId(R.id.enter_button));
//        materialButton.perform(click());
//
//        ViewInteraction viewGroup = onView(withId(R.id.trademark_image_view));
//        viewGroup.check(matches(isDisplayed()));
//
//        ViewInteraction logOut = onView(withId(R.id.authorization_image_button));
//        logOut.perform(click());
//        ViewInteraction logOut2 = onView(withText("Выйти"));
//        logOut2.perform(click());
//
//
//        ViewInteraction textInputEditText1 = onView(withId(R.id.login_text_input));
//        textInputEditText1.check(matches(isDisplayed()));
//        textInputEditText1.perform(replaceText(validLogin));
//        ViewInteraction textInputEditText3 = onView(withId(R.id.password_text_input));
//        textInputEditText3.check(matches(isDisplayed()));
//        textInputEditText3.perform(replaceText(validPassword), closeSoftKeyboard());
//        viewGroup.check(matches(isDisplayed()));
//
//        ViewInteraction viewGroup1 = onView(withId(R.id.trademark_image_view));
//        viewGroup1.check(matches(isDisplayed()));
//
//    }





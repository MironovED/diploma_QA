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

        AuthorizationSteps.checkInvalidData(activityTestRule);
    }

    @Test
    @DisplayName("Авторизация без логина и пароля")
    public void shouldNotLogInWithEmptyData() {

        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkEmptyField(activityTestRule);
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void shouldNotLogInWithEmptyPassword() {

        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkEmptyField(activityTestRule);
    }

    @Test
    @DisplayName("Повторная авторизация после выхода из учетной записи")
    public void shouldLogInAfterLogOut() {

        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkAuthorization();

        AuthorizationSteps.logOut();
        AuthorizationSteps.checkIsAuthorizationScreen();

        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();

        //Валится тест на проверке
        AuthorizationSteps.checkAuthorization();
    }

}



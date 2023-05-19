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
import ru.iteco.fmhandroid.ui.dataTestCase.AuthorizationData;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTests {

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
        AuthorizationSteps.enterLogin(AuthorizationData.validLogin);
        AuthorizationSteps.enterPass(AuthorizationData.validPass);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkAuthorization();
    }

    @Test
    @DisplayName("Авторизация не зарегистрированным пользователем")
    public void shouldNotLogInWithInValidData() {
        AuthorizationSteps.enterLogin(AuthorizationData.inValidLogin);
        AuthorizationSteps.enterPass(AuthorizationData.inValidPassword);
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
        AuthorizationSteps.enterLogin(AuthorizationData.validLogin);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkEmptyField(activityTestRule);
    }

    @Test
    @DisplayName("Повторная авторизация после выхода из учетной записи")
    public void shouldLogInAfterLogOut() throws InterruptedException {
        AuthorizationSteps.enterLogin(AuthorizationData.validLogin);
        AuthorizationSteps.enterPass(AuthorizationData.validPass);
        AuthorizationSteps.clickEnterButton();

        AuthorizationSteps.checkAuthorization();

        AuthorizationSteps.logOut();
        AuthorizationSteps.checkIsAuthorizationScreen();

        AuthorizationSteps.enterLogin(AuthorizationData.validLogin);
        AuthorizationSteps.enterPass(AuthorizationData.validPass);
        AuthorizationSteps.clickEnterButton();

        Thread.sleep(1000);
        AuthorizationSteps.checkAuthorization();
    }

}



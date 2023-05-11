package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataTestCase.AuthorizationData;
import ru.iteco.fmhandroid.ui.stepsTestCase.AboutSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutTests {

    @Rule
    public IntentsTestRule<AppActivity> intentsTestRule =
            new IntentsTestRule<>(AppActivity.class);

    @Before
    public void sleep() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationSteps.checkIsAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.logIn(AuthorizationData.validLogin, AuthorizationData.validPass);
    }

    @Test
    @DisplayName("Переход по ссылке политики конфиденциальности")
    public void shouldGoToPrivacyPolicy() {
        AboutSteps.goToAbout();
        AboutSteps.clickPrivacyPolicy();
        AboutSteps.checkTheSuccessfulTransitionToPrivacyPolicy();
    }

    @Test
    @DisplayName("Переход по ссылке Пользовательское соглашение")
    public void shouldGoToTermsOfUse() {
        AboutSteps.goToAbout();
        AboutSteps.clickTermsOfUse();
        AboutSteps.checkTheSuccessfulTransitionToTermsOfUse();
    }

}

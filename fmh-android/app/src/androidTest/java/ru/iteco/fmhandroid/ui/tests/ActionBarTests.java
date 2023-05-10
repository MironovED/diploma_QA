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
import ru.iteco.fmhandroid.ui.stepsTestCase.ActionBarSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ActionBarTests {

    String validLogin = "login2";
    String validPassword = "password2";

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
    @DisplayName("Переход в раздел тематических цитат")
    public void shouldGoToThematicQuotes() {
        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();
        ActionBarSteps.clickOurMissionButton();

        ActionBarSteps.checkOurMission();
    }

    @Test
    @DisplayName("Переход в раздел Claims")
    public void shouldGoToClaims() {
        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ActionBarSteps.checkIsOpenClaims();
    }

    @Test
    @DisplayName("Переход в раздел News")
    public void shouldGoToNews() {
        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();

        ActionBarSteps.checkIsOpenNews();
    }

    @Test
    @DisplayName("Переход в раздел About")
    public void shouldGoToAbout() {
        AuthorizationSteps.enterLogin(validLogin);
        AuthorizationSteps.enterPass(validPassword);
        AuthorizationSteps.clickEnterButton();
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickAboutButton();

        ActionBarSteps.checkIsOpenAbout();
    }
}



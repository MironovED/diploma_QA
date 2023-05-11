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
import ru.iteco.fmhandroid.ui.stepsTestCase.ActionBarSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ActionBarTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

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
    @DisplayName("Переход в раздел тематических цитат")
    public void shouldGoToThematicQuotes() {
        ActionBarSteps.clickOurMissionButton();

        ActionBarSteps.checkOurMission();
    }

    @Test
    @DisplayName("Переход в раздел Claims")
    public void shouldGoToClaims() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ActionBarSteps.checkIsOpenClaims();
    }

    @Test
    @DisplayName("Переход в раздел News")
    public void shouldGoToNews() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();

        ActionBarSteps.checkIsOpenNews();
    }

    @Test
    @DisplayName("Переход в раздел About")
    public void shouldGoToAbout() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickAboutButton();

        ActionBarSteps.checkIsOpenAbout();
    }
}



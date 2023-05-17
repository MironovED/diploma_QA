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
import ru.iteco.fmhandroid.ui.stepsTestCase.ClaimsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsTests {
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
    @DisplayName("Фильтрация заявок по 'Open'")
    public void shouldBeFilteredByOpen() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();
        ClaimsSteps.clickClaimsFilterButton();
        ClaimsSteps.clickCheckBoxInProgress();
        ClaimsSteps.clickButtonOkInFiltering();

        ClaimsSteps.clickFirstClaim();
        ClaimsSteps.checkStatusClaim("Open");


    }

    @Test
    @DisplayName("Фильтрация заявок по 'In progress'")
    public void shouldBeFilteredByInProgress() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();
        ClaimsSteps.clickClaimsFilterButton();
        ClaimsSteps.clickCheckBoxOpen();
        ClaimsSteps.clickButtonOkInFiltering();

        ClaimsSteps.clickFirstClaim();
        ClaimsSteps.checkStatusClaim("In progress");
    }

    @Test
    @DisplayName("Фильтрация заявок по 'Executed'")
    public void shouldBeFilteredByExecuted() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();
        ClaimsSteps.clickClaimsFilterButton();
        ClaimsSteps.clickCheckBoxOpen();
        ClaimsSteps.clickCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOkInFiltering();

        ClaimsSteps.clickFirstClaim();
        ClaimsSteps.checkStatusClaim("Executed");

    }

    @Test
    @DisplayName("Фильтрация заявок по 'Cancelled'")
    public void shouldBeFilteredByCancelled() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();
        ClaimsSteps.clickClaimsFilterButton();

        ClaimsSteps.clickCheckBoxOpen();
        ClaimsSteps.clickCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOkInFiltering();

        ClaimsSteps.clickFirstClaim();
        ClaimsSteps.checkStatusClaim("Canceled");

    }

}

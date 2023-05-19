package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataTestCase.AuthorizationData;
import ru.iteco.fmhandroid.ui.dataTestCase.ClaimsData;
import ru.iteco.fmhandroid.ui.stepsTestCase.ActionBarSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.ClaimsSteps;
import ru.iteco.fmhandroid.ui.utils.Helper;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
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

    @Test
    @DisplayName("Создание заявки")
    public void shouldCreateClaim() {
        int randValue = Helper.randInt(100,1000);
        String text = "test" + randValue;

        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ClaimsSteps.createClaim(text); //Необходимо каждый раз вводить новые данные
        ClaimsSteps.checkCreateClaim(text);
    }

    @Test
    @DisplayName("Создание заявки с пустыми полями")
    public void shouldShowWarningWhenAllFieldEmpty() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ClaimsData.buttonCreateClaim.perform(click());
        ClaimsData.saveButton.perform(click());

        ClaimsSteps.checkShowWarning(activityTestRule);
    }

    @Test
    @DisplayName("Редактирование существующей заявки")
    public void shouldEditClaim() {
        int randValue = Helper.randInt(100,1000);
        String text = "test" + randValue;
        String textNew = "testNew" + randValue;

        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ClaimsSteps.createClaim(text); //Необходимо каждый раз вводить новые данные
        ClaimsSteps.selectApplicationByDescription(text);
        ClaimsSteps.editStatusThrowOff();
        ClaimsSteps.editClaim(textNew, textNew);

        ClaimsSteps.checkEditClaim(textNew, textNew);
    }

    @Test
    @DisplayName("Изменения статуса заявки")
    public void shouldEditStatus() {
        int randValue = Helper.randInt(100,1000);
        String text = "test" + randValue;

        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickClaimsButton();

        ClaimsSteps.createClaim(text);
        ClaimsSteps.selectApplicationByDescription(text);
        ClaimsSteps.editStatusToExecute();

        ClaimsSteps.checkStatus("Executed");
    }
}

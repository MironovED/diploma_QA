package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.intent.rule.IntentsTestRule;
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
import ru.iteco.fmhandroid.ui.stepsTestCase.AboutSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.ActionBarSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.stepsTestCase.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsTests {

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
    @DisplayName("Фильтрация списка в разделе новостей")
    public void should1() {

    }


    @Test
    @DisplayName("Упорядочивание списка новостей")
    public void should2() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.clickCategory();
//        NewsSteps.clickSalary();
        NewsSteps.clickNotice();
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей в режиме редактирования списка")
    public void should3() {

    }

    @Test
    @DisplayName("Создание новости")
    public void should5() {

    }

    @Test
    @DisplayName("Создание новости с пустыми полями")
    public void should8() {

    }

    @Test
    @DisplayName("Редактирование существующей новости")
    public void should6() {

    }

    @Test
    @DisplayName("Выход из режима редактирования новости без сохранения")
    public void should7() {

    }

    @Test
    @DisplayName("Удаление существующей новости")
    public void should4() {

    }



}

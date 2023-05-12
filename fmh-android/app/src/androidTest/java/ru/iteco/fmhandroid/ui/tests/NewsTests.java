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
import ru.iteco.fmhandroid.ui.dataTestCase.NewsData;
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
    @DisplayName("Фильтрация новостей по объявлению")
    public void shouldBeFilteredByNotice() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.notice);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.birthday);
    }

    @Test
    @DisplayName("Фильтрация новостей по дню рождения")
    public void shouldBeFilteredByBirthday() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.birthday);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по зарплате")
    public void shouldBeFilteredBySalary() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.salary);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по профсоюзу")
    public void shouldBeFilteredByTradeUnion() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.tradeUnion);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по празднику")
    public void shouldBeFilteredByHoliday() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.holiday);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по массажу")
    public void shouldBeFilteredByMassage() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.massage);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по благодарности")
    public void shouldBeFilteredByThank() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.thank);
        NewsSteps.clickFilterButton();


    }

    @Test
    @DisplayName("Фильтрация новостей по нужна помощь")
    public void shouldBeFilteredByHelp() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.selectCategory();
        NewsSteps.insertCategory(NewsData.help);
        NewsSteps.clickFilterButton();


    }

//    @Test
//    @DisplayName("Фильтрация новостей по дате")
//    public void should16() {
//        ActionBarSteps.clickMainMenuButton();
//        ActionBarSteps.clickNewsButton();
//        NewsSteps.clickNewsFilterButton();
//        NewsSteps.selectCategory();
//        NewsSteps.insertCategory("дата");
//        NewsSteps.clickFilterButton();
//
//
//    }

//////

//    @Test
//    @DisplayName("Упорядочивание списка новостей")
//    public void should2() {
//
//
//
//    }
//
//    @Test
//    @DisplayName("Фильтрация новостей в режиме редактирования списка")
//    public void should3() {
//
//    }
//
//    @Test
//    @DisplayName("Создание новости")
//    public void should5() {
//
//    }
//
//    @Test
//    @DisplayName("Создание новости с пустыми полями")
//    public void should8() {
//
//    }
//
//    @Test
//    @DisplayName("Редактирование существующей новости")
//    public void should6() {
//
//    }
//
//    @Test
//    @DisplayName("Выход из режима редактирования новости без сохранения")
//    public void should7() {
//
//    }
//
//    @Test
//    @DisplayName("Удаление существующей новости")
//    public void should4() {
//
//    }



}

package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataTestCase.AuthorizationData;
import ru.iteco.fmhandroid.ui.dataTestCase.NewsData;
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
    @DisplayName("Фильтрация новостей по 'Объявления'")
    public void shouldBeFilteredByNotice() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.notice);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.notice);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'День рождения'")
    public void shouldBeFilteredByBirthday() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.birthday);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.birthday);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Зарплата'")
    public void shouldBeFilteredBySalary() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.salary);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.salary);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Профсоюз'")
    public void shouldBeFilteredByTradeUnion() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.tradeUnion);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.tradeUnion);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Праздник'")
    public void shouldBeFilteredByHoliday() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.holiday);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.holiday);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Массаж'")
    public void shouldBeFilteredByMassage() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.massage);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.massage);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Благодарность'")
    public void shouldBeFilteredByThank() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.thank);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.thank);
    }

    @Test
    @DisplayName("Фильтрация новостей по 'Нужна помощь'")
    public void shouldBeFilteredByHelp() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.help);
        NewsSteps.clickFilterButton();

        NewsSteps.checkFilter(NewsData.help);
    }

    @Test
    @DisplayName("Фильтрация новостей по дате")
    public void shouldBeFilteredByDate() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickNewsFilterButton();
        NewsSteps.insertCategory(NewsData.notice);
        NewsSteps.selectDateStart();
        NewsSteps.selectDateEnd();

        String currentDate = new SimpleDateFormat("dd.MM.YYYY").format(new Date());
        NewsSteps.checkFilter(currentDate);
    }


    @Test
    @DisplayName("Упорядочивание списка новостей")
    public void shouldSortList() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickNewsButton();
        NewsSteps.clickSortButton();

        NewsSteps.checkSort();
    }
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

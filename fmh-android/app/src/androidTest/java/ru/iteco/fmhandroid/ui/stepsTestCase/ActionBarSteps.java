package ru.iteco.fmhandroid.ui.stepsTestCase;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.ui.dataTestCase.ActionBarData;

public class ActionBarSteps {

    //нажать кнопку раздела Our Mission
    public static void clickOurMissionButton() {
        ActionBarData.ourMissionButton.perform(click());
    }

    //проверка открытия раздела Our Mission
    public static void checkOurMission() {
        ActionBarData.ourMissionRecyclerView.check(matches(isDisplayed()));
    }

    //нажать Main Menu
    public static void clickMainMenuButton() {
        ActionBarData.MainMenuButton.perform(click());
    }

    //нажать кнопку раздела Main
    public static void clickMainButton() {
        ActionBarData.MainButton.perform(click());
    }

    //проверка открытого окна Main
    public static void checkIsOpenMain() {
        ActionBarData.textNews.check(matches(isDisplayed()));
        ActionBarData.textClaims.check(matches(isDisplayed()));
    }

    //нажать кнопку раздела Claims
    public static void clickClaimsButton() {
        ActionBarData.claimsButton.perform(click());
    }

    //нажать кнопку раздела News
    public static void clickNewsButton() {
        ActionBarData.newsButton.perform(click());
    }

    //нажать кнопку раздела About
    public static void clickAboutButton() {
        ActionBarData.aboutButton.perform(click());
    }

    //проверка открытого окна Claims
    public static void checkIsOpenClaims() {
        ActionBarData.claimsRecyclerView.check(matches(isDisplayed()));
    }

    //проверка открытого окна News
    public static void checkIsOpenNews() {
        ActionBarData.newsRecyclerView.check(matches(isDisplayed()));
    }

    //проверка открытого окна About
    public static void checkIsOpenAbout() {
        ActionBarData.aboutRecyclerView.check(matches(isDisplayed()));
    }
}
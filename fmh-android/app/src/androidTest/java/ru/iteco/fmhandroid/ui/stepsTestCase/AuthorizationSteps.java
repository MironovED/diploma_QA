package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import androidx.test.rule.ActivityTestRule;


import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataTestCase.AuthorizationData;


public class AuthorizationSteps {



    //assert Неверный логин или пароль
    public static void checkInvalidData(ActivityTestRule<AppActivity> activityTestRule) {
        onView(withText(R.string.wrong_login_or_password)).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                .getDecorView())))).check(matches(withText("Wrong login or password")));
    }

    //assert Логин и пароль не могут быть пустыми
    public static void checkEmptyField(ActivityTestRule<AppActivity> activityTestRule) {
        onView(withText(R.string.empty_login_or_password)).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                .getDecorView())))).check(matches(withText("Login and password cannot be empty")));
    }

    //проверка авторизации
    public static void checkAuthorization() {
        AuthorizationData.emblemID.check(matches(isDisplayed()));
    }
    //проверка открытого окна авторизации
    public static void checkIsAuthorizationScreen() {
        AuthorizationData.textAuthorization.check(matches(isDisplayed()));
    }

    //ввести логин
    public static void enterLogin(String login) {
        AuthorizationData.loginField.check(matches(isDisplayed()));
        AuthorizationData.loginField.perform(replaceText(login));
    }
    //ввести пароль
    public static void enterPass(String password) {
        AuthorizationData.passField.check(matches(isDisplayed()));
        AuthorizationData.passField.perform(replaceText(password));
    }
    //нажать кнопку войти
    public static void clickEnterButton() {
        AuthorizationData.enterButton.perform(click());
    }
    //выйти из учетной записи
    public static void logOut() {
        AuthorizationData.logOutButton.check(matches(isDisplayed()));
        AuthorizationData.logOutButton.perform(click());
        AuthorizationData.textExit.perform(click());
    }

}

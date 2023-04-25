package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationData {

    public static ViewInteraction loginField = onView(withId(R.id.login_text_input));
    public static ViewInteraction passField = onView(withId(R.id.password_text_input));
    public static ViewInteraction enterButton = onView(withId(R.id.enter_button));
    public static ViewInteraction emblemID = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction logOutButton = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction textExit = onView(withText("Выйти"));
    public static ViewInteraction textAuthorization = onView(withText("Авторизация"));

}

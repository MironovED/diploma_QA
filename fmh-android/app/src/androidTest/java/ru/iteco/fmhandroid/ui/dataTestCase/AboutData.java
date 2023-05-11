package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

public class AboutData {

    public static ViewInteraction privacyPolicy = onView(withText("https://vhospice.org/#/privacy-policy/"));
    public static ViewInteraction termsOfUse = onView(withText("https://vhospice.org/#/terms-of-use"));

}

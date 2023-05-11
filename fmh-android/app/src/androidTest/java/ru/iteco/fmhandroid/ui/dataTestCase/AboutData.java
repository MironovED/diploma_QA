package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutData {

//    public static ViewInteraction privacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
//    public static ViewInteraction termsOfUse = onView(withId(R.id.about_terms_of_use_value_text_view));
    public static ViewInteraction privacyPolicy = onView(withText("https://vhospice.org/#/privacy-policy/"));
    public static ViewInteraction termsOfUse = onView(withText("https://vhospice.org/#/terms-of-use"));


}

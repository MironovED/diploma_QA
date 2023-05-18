package ru.iteco.fmhandroid.ui.stepsTestCase;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import ru.iteco.fmhandroid.ui.dataTestCase.AboutData;

public class AboutSteps {

    public static void clickPrivacyPolicy() {
        AboutData.privacyPolicy.perform(click());
    }

    public static void clickTermsOfUse() {
        AboutData.termsOfUse.perform(click());
    }

    public static void goToAbout() {
        ActionBarSteps.clickMainMenuButton();
        ActionBarSteps.clickAboutButton();
        ActionBarSteps.checkIsOpenAbout();
    }

    public static void checkTheSuccessfulTransitionToPrivacyPolicy() {
        intended(allOf(
                hasData("https://vhospice.org/#/privacy-policy/"),
                hasAction(Intent.ACTION_VIEW)
        ));
    }

    public static void checkTheSuccessfulTransitionToTermsOfUse() {
        intended(allOf(
                hasData("https://vhospice.org/#/terms-of-use"),
                hasAction(Intent.ACTION_VIEW)
        ));
    }

}

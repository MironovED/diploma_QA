package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ActionBarData {

    public static ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction ourMissionRecyclerView = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction claimsRecyclerView = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction newsRecyclerView = onView(withId(R.id.news_list_recycler_view));
    public static ViewInteraction aboutRecyclerView = onView(withId(R.id.about_version_title_text_view));

    public static ViewInteraction MainMenuButton = onView(allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu")));
    public static ViewInteraction MainButton = onView(allOf(withId(android.R.id.title),withText("Main")));
    public static ViewInteraction claimsButton = onView(allOf(withId(android.R.id.title),withText("Claims")));
    public static ViewInteraction newsButton = onView(allOf(withId(android.R.id.title),withText("News")));
    public static ViewInteraction aboutButton = onView(allOf(withId(android.R.id.title),withText("About")));

    public static ViewInteraction textNews = onView(withText("News"));
    public static ViewInteraction textClaims = onView(withText("Claims"));

}

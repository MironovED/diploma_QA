package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class NewsData {

//    public static String notice = "Объявление";
//    public static String birthday = "День рождения";
//    public static String salary = "Зарплата";
//    public static String tradeUnion = "Профсоюз";
//    public static String holiday = "Праздник";
//    public static String massage = "Массаж";
//    public static String thank = "Благодарность";
//    public static String help = "Нужна помощь";



    public static ViewInteraction selectCategory = onView(
            allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
    public static ViewInteraction newsFilterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));

    // Сортировка новостей
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));




    public static DataInteraction notice = onData(anything())
            .inAdapterView(childAtPosition(
                    withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                    0))
            .atPosition(0);


//    public static DataInteraction salary = onData(anything())
//            .inAdapterView(childAtPosition(
//                    withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
//                    0))
//            .atPosition(2);



    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}

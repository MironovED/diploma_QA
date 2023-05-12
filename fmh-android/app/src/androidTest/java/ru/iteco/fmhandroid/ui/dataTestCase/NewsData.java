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

    public static String notice = "Объявление";
    public static String birthday = "День рождения";
    public static String salary = "Зарплата";
    public static String tradeUnion = "Профсоюз";
    public static String holiday = "Праздник";
    public static String massage = "Массаж";
    public static String thank = "Благодарность";
    public static String help = "Нужна помощь";

    public static ViewInteraction fieldCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));

    public static ViewInteraction newsFilterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));

    public static ViewInteraction tittleNewsNotice = onView(allOf(withId(R.id.news_item_title_text_view), withText(notice)));
    public static ViewInteraction tittleNewsBirthday = onView(allOf(withId(R.id.news_item_title_text_view), withText(birthday)));
    public static ViewInteraction tittleNewsSalary = onView(allOf(withId(R.id.news_item_title_text_view), withText(salary)));
    public static ViewInteraction tittleNewsTradeUnion = onView(allOf(withId(R.id.news_item_title_text_view), withText(tradeUnion)));
    public static ViewInteraction tittleNewsHoliday = onView(allOf(withId(R.id.news_item_title_text_view), withText(holiday)));
    public static ViewInteraction tittleNewsMassage = onView(allOf(withId(R.id.news_item_title_text_view), withText(massage)));
    public static ViewInteraction tittleNewsThank = onView(allOf(withId(R.id.news_item_title_text_view), withText(thank)));
    public static ViewInteraction tittleNewsHelp = onView(allOf(withId(R.id.news_item_title_text_view), withText(help)));

    public static ViewInteraction recyclerView =onView(withId(R.id.news_list_recycler_view));


    // Сортировка новостей
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));









}

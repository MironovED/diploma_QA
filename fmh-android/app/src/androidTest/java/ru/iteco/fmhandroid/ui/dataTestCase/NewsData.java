package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

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

    public static ViewInteraction fieldCategory = onView(allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
    public static ViewInteraction newsFilterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));

    public static ViewInteraction recyclerView =onView(withId(R.id.news_list_recycler_view));


    // Сортировка новостей
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));









}

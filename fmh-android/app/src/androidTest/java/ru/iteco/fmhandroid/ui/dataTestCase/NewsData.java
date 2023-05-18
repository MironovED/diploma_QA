package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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

    public static ViewInteraction fieldDateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction fieldDateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction buttonOkInFilter = onView(allOf(withId(android.R.id.button1), withText("OK")));

    // Сортировка новостей
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction recyclerView = onView(withId(R.id.news_list_recycler_view));
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction fieldPublicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction fieldTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction fieldDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction fieldTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction buttonOkInDateWindow = onView(withId(android.R.id.button1));
    public static ViewInteraction buttonOpenNews = onView(withId(R.id.view_news_item_image_view));



}

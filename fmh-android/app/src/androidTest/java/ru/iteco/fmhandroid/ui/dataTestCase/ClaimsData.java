package ru.iteco.fmhandroid.ui.dataTestCase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Helper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsData {

    public static ViewInteraction claimsFilterButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction buttonOkInFiltering = onView(withId(R.id.claim_list_filter_ok_material_button));
    public static ViewInteraction filteringOpen = onView(withId(R.id.item_filter_open));
    public static ViewInteraction filteringInProgress = onView(withId(R.id.item_filter_in_progress));
    public static ViewInteraction filteringExecuted = onView(withId(R.id.item_filter_executed));
    public static ViewInteraction filteringCancelled = onView(withId(R.id.item_filter_cancelled));
    public static ViewInteraction claimsStatus = onView(withId(R.id.status_label_text_view));
    public static ViewInteraction firstClaims = onView(
        allOf(withId(R.id.claim_list_recycler_view),
    childAtPosition(
            withId(R.id.all_claims_cards_block_constraint_layout),
                                4)));
    public static ViewInteraction recyclerView = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction buttonCreateClaim = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction buttonOkInDateWindow = onView(withId(android.R.id.button1));
    public static ViewInteraction fieldDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction fieldTime = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction fieldExecutor = onView(allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
    public static ViewInteraction fieldDescription = onView(withId(R.id.description_edit_text));
    public static ViewInteraction fieldTitle = onView(withId(R.id.title_edit_text));
    public static ViewInteraction buttonEditClaim = onView(withId(R.id.edit_processing_image_button));
    public static ViewInteraction buttonEditStatus = onView(withId(R.id.status_processing_image_button));
}

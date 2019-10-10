import business_objects.Note;
import org.testng.annotations.Test;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;

public class SwipeScenarios extends BaseTest {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateTextNote")
    public void testVerticalSwipe(Note note) {
            baseEmulatorPageSteps.clickAllowAccess();
            baseEmulatorPageSteps.clickSkipButton();
            homePageSteps.clickNewNoteButton();
            noteTypePopupSteps.selectNoteType(note.getType());
            notePageSteps.setTitle(note);
            notePageSteps.setColor(note);
            notePageSteps.setNoteData(note);
            notePageSteps.saveNote();
            editNotePageSteps.clickBackButton();
            homePageSteps.swipeScreenToLeft();
            homePageSteps.swipeScreenToRight();
            AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }
}

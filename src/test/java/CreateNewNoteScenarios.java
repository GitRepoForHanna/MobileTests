import business_objects.Note;
import org.testng.annotations.Test;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;


public class CreateNewNoteScenarios extends BaseTest{

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateNewNote")
    public void createNewNote(Note note) {
        baseEmulatorPageSteps.clickAllowAccess();
        baseEmulatorPageSteps.clickSkipButton();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(note);
        notePageSteps.setColor(note);
        notePageSteps.setNoteData(note);
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }

}

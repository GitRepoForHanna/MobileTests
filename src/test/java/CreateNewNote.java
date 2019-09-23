import business_objects.CheckListNote;
import business_objects.Note;
import business_objects.NoteType;
import org.testng.annotations.Test;
import pages.ChecklistNotePage;
import steps.TextNotePageSteps;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;


public class CreateNewNote extends BaseTest{

//    @Autowired
//    BaseEmulatorPageSteps psgeSteps;

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateNewNote")
    public void createNewNote(Note note) {
        baseEmulatorPageSteps.clickAllowAccess();
        baseEmulatorPageSteps.clickSkipButton();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        if (note.getType().equals(NoteType.TEXT_NOTE)) {
            notePageSteps = new TextNotePageSteps();
            notePageSteps.setNoteData(note);
        } else {
//            notePageSteps = new ChecklistNotePage();
//            notePageSteps.setNoteData(note);
        }
        AndroidDriverSingletone.getSingletoneInstance().resetApp();

    }
}

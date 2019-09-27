import business_objects.TextNote;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.dataProviders.NoteDataProvider;

public class DeleteNote extends BaseTest {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateTextNote")
    public void deleteNote(TextNote textNote) {
        SoftAssert softAssert = new SoftAssert();
        baseEmulatorPageSteps.preparationActivities();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(textNote.getType());
        notePageSteps.setTitle(textNote);
        notePageSteps.setNoteData(textNote);
        notePageSteps.saveNote();
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(), 1, "New note is added");
        homePageSteps.deleteNote(textNote.getName());
        softAssert.assertEquals(homePageSteps.getNotesCount(), 0, "Note was deleted");
    }
}

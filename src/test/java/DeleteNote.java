import business_objects.TextNote;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.dataProviders.NoteDataProvider;

public class DeleteNote extends BaseTest {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateTextNote")
    public void deleteNote(TextNote textNote) {
        baseEmulatorPageSteps.clickAllowAccess();
        baseEmulatorPageSteps.clickSkipButton();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(textNote.getType());
        notePageSteps.setTitle(textNote);
        notePageSteps.setNoteData(textNote);
        notePageSteps.saveNote();
        editNotePageSteps.clickBackButton();
        Assert.assertEquals(homePageSteps.getNotesCount(), 1);
        homePageSteps.deleteNote(textNote.getName());
        Assert.assertEquals(homePageSteps.getNotesCount(), 0);
    }
}

import business_objects.Note;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;

public class EditingNotesScenarios extends BaseTest{

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "EditNoteTitle")
    public void changeNoteTitle(Note editedNote, Note desiredNote) {
        SoftAssert softAssert = new SoftAssert();
        String oldTitle = editedNote.getName();
        String newTitle = desiredNote.getName();
        baseEmulatorPageSteps.preparationActivities();
        softAssert.assertEquals(homePageSteps.getNotesCount(),0,  "There are no notes on Home page");
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(editedNote.getType());
        notePageSteps.setTitle(editedNote);
        notePageSteps.setNoteData(editedNote);
        notePageSteps.saveNote();
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(),1, "There is 1 new note on the Home page");
        Assert.assertTrue(homePageSteps.isNoteWithTextPresent(oldTitle),
                String.format("Note %s is created", oldTitle));
        homePageSteps.clickNoteWithText(oldTitle);
        editNotePageSteps.clickEditButton();
        notePageSteps.changeTitle(desiredNote);
        notePageSteps.saveNote();
        Assert.assertEquals(editNotePageSteps.getNoteTitle(), newTitle,
                String.format("New title %s is applied", newTitle));
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(), 1);
        Assert.assertTrue(homePageSteps.isNoteWithTextPresent(newTitle),
                String.format("The note %s is present on Home Page", newTitle));
        Assert.assertFalse(homePageSteps.isNoteWithTextPresent(oldTitle),
                String.format("The note %s is absent on Home Page", oldTitle));
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "UpdateNoteTitle")
    public void updateNoteTitle(Note editedNote, Note desiredNote) {
        SoftAssert softAssert = new SoftAssert();
        String oldTitle = editedNote.getName();
        String newTitle = desiredNote.getName();
        baseEmulatorPageSteps.preparationActivities();
        softAssert.assertEquals(homePageSteps.getNotesCount(),0,  "There are no notes on Home page");
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(editedNote.getType());
        notePageSteps.setTitle(editedNote);
        notePageSteps.setNoteData(editedNote);
        notePageSteps.saveNote();
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(),1, "There is 1 new note on the Home page");
        Assert.assertTrue(homePageSteps.isNoteWithTextPresent(oldTitle),
                String.format("Note %s is created", oldTitle));
        homePageSteps.clickNoteWithText(oldTitle);
        editNotePageSteps.clickEditButton();
        notePageSteps.updateTitle(desiredNote);
        notePageSteps.saveNote();
        Assert.assertEquals(editNotePageSteps.getNoteTitle(), newTitle,
                String.format("New title %s is applied", newTitle));
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(), 1);
        Assert.assertTrue(homePageSteps.isNoteWithTextPresent(newTitle),
                String.format("The note %s is present on Home Page", newTitle));
        Assert.assertFalse(homePageSteps.isNoteWithTextPresent(oldTitle),
                String.format("The note %s is absent on Home Page", oldTitle));
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }
}

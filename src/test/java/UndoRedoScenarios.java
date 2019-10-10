import business_objects.Note;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class UndoRedoScenarios extends BaseTest {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "Note_Editing", groups = "Editing")
    public void testSettingNoteBody(Note note) {
        baseEmulatorPageSteps.preparationActivities();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(note);
        notePageSteps.setNoteData(note);
        List<String> noteContent = notePageSteps.getNoteBody(note);
        MatcherAssert.assertThat("Assert that some infromation is added in the note",
                noteContent, is(note.getBody().getContentItems()));
        notePageSteps.undoAction();
        noteContent = notePageSteps.getNoteBody(note);
        MatcherAssert.assertThat("Assert that note content is deleted, note is empty", noteContent, is(empty()));
        notePageSteps.redoAction();
        noteContent = notePageSteps.getNoteBody(note);
        MatcherAssert.assertThat("Assert that content is restored, note has expected information",
                noteContent, is(notePageSteps.getNoteBody(note)));
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "AppendingToNote", groups = "Editing")
    public void testAppendingToNote(Note note, Note noteToAdd) {
        baseEmulatorPageSteps.preparationActivities();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(note);
        notePageSteps.setNoteData(note);
        List<String> expectedNoteContent = new ArrayList<String>(note.getBody().getContentItems());
        MatcherAssert.assertThat("Asserted that note is filled as expected",
                notePageSteps.getNoteBody(note), is(note.getBody().getContentItems()));
        notePageSteps.saveNote();
        editNotePageSteps.clickEditButton();
        notePageSteps.setNoteData(noteToAdd);
        expectedNoteContent.addAll(noteToAdd.getBody().getContentItems());
        MatcherAssert.assertThat("Asserted that note is supplemented with desired information",
                notePageSteps.getNoteBody(note), is(expectedNoteContent));
        notePageSteps.undoAction();
        MatcherAssert.assertThat("Asserted that note supplement is undone",
                notePageSteps.getNoteBody(note), is(note.getBody().getContentItems()));
        notePageSteps.redoAction();
        MatcherAssert.assertThat("Asserted that note supplement is restored",
                notePageSteps.getNoteBody(note), is(expectedNoteContent));
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }
}


import business_objects.Note;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import utils.androiddriver.AndroidDriverSingletone;
import utils.dataProviders.NoteDataProvider;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class UndoRedoScenarios extends BaseTest {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "Note_Editing")
    public void undoAndRedoChanges(Note note) {
        baseEmulatorPageSteps.clickAllowAccess();
        baseEmulatorPageSteps.clickSkipButton();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(note);
        notePageSteps.setNoteData(note);
        List<String> noteContent = notePageSteps.getNoteBody(note);
        Collections.reverse(noteContent);
        MatcherAssert.assertThat(noteContent, is(note.getBody().getContentItems()));
        notePageSteps.undoAction();
        noteContent = notePageSteps.getNoteBody(note);
        MatcherAssert.assertThat(noteContent, is(empty()));
        notePageSteps.redoAction();
        noteContent = notePageSteps.getNoteBody(note);
        MatcherAssert.assertThat(noteContent, is(notePageSteps.getNoteBody(note)));
        AndroidDriverSingletone.getSingletoneInstance().resetApp();
    }
}


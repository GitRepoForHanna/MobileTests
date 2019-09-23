package steps;

import business_objects.Note;
import business_objects.TextNote;
import pages.TextNotePage;

public class TextNotePageSteps extends NotePageSteps {

    public void setNoteTitle(String title) {
        TextNotePage textNotePage = new TextNotePage();
        textNotePage.setTitle(title);
    }

    public void setNoteBody(String body) {
        TextNotePage textNotePage = new TextNotePage();
        textNotePage.setBody(body);
    }

    public void saveNote() {
        TextNotePage textNotePage = new TextNotePage();
        textNotePage.clickSaveButton();
    }

    public void undoAction() {
        TextNotePage textNotePage = new TextNotePage();
        textNotePage.clickUndoButton();
    }

    public void undoAction(int actionCount) {
        TextNotePage textNotePage = new TextNotePage();
        for(int i = 0; i < actionCount; i++){
            textNotePage.clickUndoButton();
        }
    }

    public void redoAction() {
        TextNotePage textNotePage = new TextNotePage();
        textNotePage.clickRedoButton();
    }

    public void redoAction(int actionCount) {
        TextNotePage textNotePage = new TextNotePage();
        for(int i = 0; i < actionCount; i++){
            textNotePage.clickRedoButton();
        }
    }

    @Override
    public void setNoteData(Note note) {
        new TextNotePage().setNoteData(note);
    }

}

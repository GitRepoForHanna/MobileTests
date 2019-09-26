package steps;

import business_objects.CheckListNote;
import business_objects.Note;
import business_objects.TextNote;
import pages.BasePage;
import pages.ChecklistNotePage;
import pages.NotePage;
import pages.TextNotePage;
import popups.ColorPopup;
import popups.NewChecklistItemPopup;

import java.util.Iterator;
import java.util.List;

public class NotePageSteps extends BasePage {

    public void setNoteData(Note note) {
        switch (note.getType()) {
            case TEXT_NOTE: {
                TextNote textNote = (TextNote) note;
                Iterator iterator = textNote.getBody().getContentItems().iterator();
                String body = "";
                while (iterator.hasNext()){
                    body += iterator.next();
                }
                if (body != null) {
                    new TextNotePage().setBody(body);
                }
                break;
            }
            case CHECKLIST: {
                CheckListNote checkListNote = (CheckListNote) note;
                List<String> itemsList = checkListNote.getBody().getContentItems();
                if (itemsList != null) {
                    itemsList
                            .forEach(item -> {
                                new ChecklistNotePage().clickNewItem();
                                NewChecklistItemPopup popup = new NewChecklistItemPopup();
                                popup.setItemBody(item);
                                popup.clickOkButton();
                            });
                }
                break;
            }
            default:
                throw new RuntimeException("This note type doesn't exists!");
        }
    }

    public void setTitle(Note note) {
        NotePage notePage = new NotePage();
        notePage.setTitle(note.getName());
    }

    public void setColor(Note note) {
        NotePage notePage = new NotePage();
        ColorPopup colorPopup = new ColorPopup();
        notePage.clickColorButton();
        colorPopup.setColor(note.getColor());
    }

    public void saveNote() {
        NotePage notePage = new NotePage();
        notePage.clickSaveButton();
    }

    public void undoAction() {
        NotePage notePage = new NotePage();
        notePage.clickUndoButton();
    }

    public void undoAction(int actionCount) {
        for (int i = 0; i < actionCount; i++) {
            undoAction();
        }
    }

    public void redoAction() {
        NotePage notePage = new NotePage();
        notePage.clickRedoButton();
    }

    public void redoAction(int actionCount) {
        for (int i = 0; i < actionCount; i++) {
            redoAction();
        }
    }

    public List<String> getNoteBody(Note note) {
        switch (note.getType()) {
            case TEXT_NOTE: {
                return new TextNotePage().getBody();
            }
            case CHECKLIST: {
                return new ChecklistNotePage().getCheckListItems();
            }
            default:
                throw new RuntimeException("This note type doesn't exists!");
        }
    }

    public void assertBody(List<String> expectedBody) {

    }
}

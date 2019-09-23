package steps;

import business_objects.NoteType;
import pages.NoteTypePopup;

public class NoteTypePopupSteps extends BaseSteps {

    public void selectNoteType(NoteType type) {
        new NoteTypePopup().setNoteType(type);
    }
}

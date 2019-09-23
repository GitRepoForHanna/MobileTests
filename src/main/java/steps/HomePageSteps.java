package steps;

import business_objects.Note;
import business_objects.NoteType;
import org.apache.log4j.Logger;
import pages.*;

public class HomePageSteps extends BaseSteps {

    public void clickNewNoteButton() {
        new HomePage().clickNewNoteButton();
        Logger.getLogger(HomePageSteps.class).info("Click New Note Button");
    }

    public void createNewNote(Note note) {
        NotePage newNotePage;
        Logger logger = Logger.getLogger(HomePageSteps.class);
        HomePage homePage = new HomePage();
        NoteTypePopup typePopup = new NoteTypePopup();

        homePage.clickNewNoteButton();
        logger.info("Click New Note Button");

        typePopup.setNoteType(note.getType());
        logger.info(String.format("Note type %s is selected", note.getType()));

        if(note.getType().getValue().equals(NoteType.CHECKLIST.getValue())){
            //newNotePage = new ();
        }
        else {
            newNotePage = new TextNotePage();
            newNotePage.setNoteData(note);
        }

    }

    public void createNoteAndBack(Note note) {

        createNewNote(note);
        Logger.getLogger(HomePageSteps.class).info("Go back");

    }
}

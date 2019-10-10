import business_objects.Body;
import business_objects.CheckListNote;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ParameterInXML extends BaseTest{

    @Test(groups = "Creation")
    @Parameters({"noteTitle", "checkListItems"})
    public void testParameters(String noteTitle, String citiesToVisit) {
        CheckListNote note = new CheckListNote(noteTitle, new Body(Arrays.asList(StringUtils.split(citiesToVisit, ","))));
        baseEmulatorPageSteps.preparationActivities();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(noteTitle);
        notePageSteps.setNoteData(note);
        notePageSteps.saveNote();
    }
}

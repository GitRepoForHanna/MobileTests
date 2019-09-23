package pages;

import business_objects.Color;
import business_objects.Note;
import business_objects.TextNote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class TextNotePage extends NotePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_note")
    private WebElement bodyInput;

    public TextNotePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void setBody(String body) {
        Wait.waitUntilParticularState(bodyInput::isEnabled);
        bodyInput.sendKeys(body);
    }

    @Override
    public void setNoteData(Note note) {
        TextNote textNote = ((TextNote) note);

        String title = textNote.getName();
        if (title != null) {
            setTitle(title);
        }
        String body = textNote.getBody();
        if (body != null) {
            setBody(body);
        }
        Color color = textNote.getColor();
        if (color != null && !(color.equals(Color.YELLOW))) {
            ColorPopup colorPopup = new ColorPopup();
            clickColorButton();
            colorPopup.clickColorButton(color);
        }
        clickSaveButton();
    }
}

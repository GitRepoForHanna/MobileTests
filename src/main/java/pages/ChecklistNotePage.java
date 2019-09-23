package pages;

import business_objects.Note;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;

public class ChecklistNotePage extends NotePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/editlist")
    private WebElement editListPanel;

    @FindBy(xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='Add Item']")
    private WebElement addNewItemButton;

    public ChecklistNotePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    @Override
    public void setNoteData(Note note) {

    }
}

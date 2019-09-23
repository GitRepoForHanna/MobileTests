package pages;

import business_objects.Note;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public abstract class NotePage extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_title")
    protected WebElement titleInput;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/back_btn")
    protected WebElement saveButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/color_btn")
    protected WebElement colorButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/overflow_btn")
    protected WebElement menuButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_undo")
    protected WebElement undoButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_redo")
    protected WebElement redoButton;

    public NotePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void setTitle(String title) {
        Wait.waitUntilParticularState(titleInput::isEnabled);
        titleInput.sendKeys(title);
    }

    public void clickSaveButton() {
        Wait.waitUntilParticularState(saveButton::isEnabled);
        saveButton.click();
    }

    public void clickColorButton() {
        Wait.waitUntilParticularState(colorButton::isEnabled);
        colorButton.click();
    }

    public void clickMenuButton() {
        Wait.waitUntilParticularState(menuButton::isEnabled);
        menuButton.click();
    }

    public void clickUndoButton() {
        Wait.waitUntilParticularState(undoButton::isEnabled);
        undoButton.click();
    }

    public void clickRedoButton() {
        Wait.waitUntilParticularState(redoButton::isEnabled);
        redoButton.click();
    }

    public abstract void setNoteData(Note note);
}

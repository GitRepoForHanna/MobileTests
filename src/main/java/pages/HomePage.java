package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class HomePage extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")
    private WebElement newNoteButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn2")
    private WebElement searchButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")
    private WebElement actionsButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/text_button_center")
    private WebElement sortByTimeButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/img_add")
    private WebElement addNoteImage;


    public HomePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void clickNewNoteButton() {
        Wait.waitUntilParticularState(() -> newNoteButton.isDisplayed());
        newNoteButton.click();
    }

    public void clickNewNoteImage() {
        Wait.waitUntilParticularState(() -> addNoteImage.isDisplayed());
        addNoteImage.click();
    }

    public void clickSearchButton() {
        Wait.waitUntilParticularState(() -> searchButton.isDisplayed());
        searchButton.click();
    }

    public void clickActionsButton() {
        Wait.waitUntilParticularState(() -> actionsButton.isDisplayed());
        actionsButton.click();
    }

    public void clickSortByTimeButton() {
        Wait.waitUntilParticularState(() -> sortByTimeButton.isDisplayed());
        sortByTimeButton.click();
    }

}

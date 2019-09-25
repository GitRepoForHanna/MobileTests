package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class BottomMenuPage {

    private static final String BOTTOM_MENU_ID = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_layout";

    @FindBy(id = BOTTOM_MENU_ID)
    private WebElement bottomMenu;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_archive")
    private WebElement archiveButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_delete")
    private WebElement deleteButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_color")
    private WebElement colorButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_reminder")
    private WebElement reminderButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_more")
    private WebElement moreButton;

    public BottomMenuPage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public boolean isDisplayed() {
        if (AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElements(By.id(BOTTOM_MENU_ID)).size() == 0)
            return false;
        return bottomMenu.isDisplayed();
    }

    public void clickArchiveButton() {
        Wait.waitUntilParticularState(archiveButton::isEnabled);
        archiveButton.click();
    }

    public void clickDeleteButton() {
        Wait.waitUntilParticularState(deleteButton::isEnabled);
        deleteButton.click();
    }

    public void clickColorButton() {
        Wait.waitUntilParticularState(colorButton::isEnabled);
        colorButton.click();
    }

    public void clickReminderButton() {
        Wait.waitUntilParticularState(reminderButton::isEnabled);
        reminderButton.click();
    }

    public void clickMoreButton() {
        Wait.waitUntilParticularState(moreButton::isEnabled);
        moreButton.click();
    }
}

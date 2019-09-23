package pages;

import business_objects.NoteType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class NoteTypePopup extends BasePage{

    @FindBy(id = "android:id/parentPanel")
    private WebElement noteTypePopupPanel;

    private String noteTypePopupPanelId = "android:id/parentPanel";

    private String typeButtonXpathPattern = "//android.widget.TextView[@text='%s']";

    public NoteTypePopup() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public WebElement getTypeButton(String type) {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElement(By.xpath(String.format(typeButtonXpathPattern, type)));
    }

    public void clickNoteTypeButton(String type) {
        WebElement button = getTypeButton(type);
        Wait.waitUntilParticularState(button::isEnabled);
        button.click();
    }

    public boolean isPopupDisplayed() {
        if (AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElements(By.id(noteTypePopupPanelId)).size() == 0) {
            return false;
        }
        return noteTypePopupPanel.isDisplayed();
    }

    public void setNoteType(NoteType type) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickNoteTypeButton(type.getValue());
        Wait.waitUntilParticularState(() -> !isPopupDisplayed());
    }
}
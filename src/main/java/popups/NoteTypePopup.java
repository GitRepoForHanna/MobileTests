package popups;

import business_objects.NoteType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class NoteTypePopup extends BasePage {

    @FindBy(id = "android:id/parentPanel")
    private WebElement noteTypePopupPanel;

    public static final String NOTE_TYPE_POPUP_PANEL_ID = "android:id/parentPanel";

    private String typeButtonXpathPattern = "//android.widget.TextView[@text='%s']";

    public NoteTypePopup() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    private WebElement getTypeButton(String type) {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElement(By.xpath(String.format(typeButtonXpathPattern, type)));
    }

    public void clickNoteTypeButton(String type) {
        WebElement button = getTypeButton(type);
        Wait.waitUntilParticularState(button::isEnabled);
        button.click();
    }

    public boolean isPopupDisplayed() {
        return (AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElements(By.id(NOTE_TYPE_POPUP_PANEL_ID)).size() != 0) && noteTypePopupPanel.isDisplayed();
    }

    public void setNoteType(NoteType type) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickNoteTypeButton(type.getValue());
        Wait.waitUntilParticularState(() -> !isPopupDisplayed());
        Logger.getLogger(NoteTypePopup.class).info(String.format("Note type %s selected", type.getValue()));
    }
}

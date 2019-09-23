package pages;

import business_objects.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class ColorPopup extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/layout")
    private WebElement colorPanel;

    private String colorPanelId = "com.socialnmobile.dictapps.notepad.color.note:id/layout";

    public ColorPopup() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    private WebElement getColorButton(Color color) {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElement(By.id(color.getColorButtonId()));
    }

    public void clickColorButton(Color color) {
        WebElement button = getColorButton(color);
        Wait.waitUntilParticularState(button::isEnabled);
        button.click();
    }

    public boolean isPopupDisplayed() {
        if (AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElements(By.id(colorPanelId)).size() == 0) {
            return false;
        }
        return colorPanel.isDisplayed();
    }

    public void setColor(Color color) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickColorButton(color);
        Wait.waitUntilParticularState(() -> !this.isPopupDisplayed());
    }
}

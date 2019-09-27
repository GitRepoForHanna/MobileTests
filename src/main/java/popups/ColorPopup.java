package popups;

import business_objects.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class ColorPopup extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn1")
    private WebElement colorButton;

    private static final String COLOR_BUTTON_ID = "com.socialnmobile.dictapps.notepad.color.note:id/btn1";

    public ColorPopup() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    private WebElement getColorButton(Color color) {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElement(By.id(color.getColorButtonId()));
    }

    public void clickColorButton(Color color) {
        WebElement button = getColorButton(color);
        Wait.waitUntilParticularState(button::isDisplayed);
        button.click();
    }

    public boolean isPopupDisplayed() {
        return (AndroidDriverSingletone.getSingletoneInstance().getDriverInstance().findElements(By.id(COLOR_BUTTON_ID)).size() != 0) && colorButton.isDisplayed();
    }

    public void setColor(Color color) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickColorButton(color);
        Wait.waitUntilParticularState(() -> !this.isPopupDisplayed());
    }
}

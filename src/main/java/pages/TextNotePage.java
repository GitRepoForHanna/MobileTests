package pages;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextNotePage extends NotePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_note")
    private WebElement bodyInput;

    public TextNotePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void setBody(String body) {
        Wait.waitUntilParticularState(bodyInput::isDisplayed);
        new Actions(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance()).sendKeys(bodyInput, body).perform();
        Logger.getLogger(TextNotePage.class).info("Set Body");
    }

    public void pressKey(Keys key) {
        new Actions(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance()).sendKeys(bodyInput, key).perform();
    }

    public List<String> getBody() {
        Wait.waitUntilParticularState(bodyInput::isDisplayed);
        String bodyContent = bodyInput.getText();
        return StringUtils.isNotBlank(bodyContent) ? Arrays.asList(bodyContent) : Collections.EMPTY_LIST;
    }
}

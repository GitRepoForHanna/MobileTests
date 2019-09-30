package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

import java.util.List;

public abstract class BasePage {

    protected String resourceIdXPathPattern = "//*[@resource-id='%s']";
    protected static final long DEFAULT_HOLD_TIMEOUT = 3;


    public AndroidDriver getAndroidDriver() {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance();
    }

    protected List findElementsById(String elementId){
        return getAndroidDriver().findElementsById(elementId);
    }

    protected WebElement findElementById(String elementId) {
        return getAndroidDriver().findElement(By.id(elementId));
    }

    protected List findElementsByXpath(String elementXpath) {
        return getAndroidDriver().findElementsByXPath(elementXpath);
    }

    protected WebElement findElementByXpath(String elementXpath) {
        return getAndroidDriver().findElement(By.xpath(elementXpath));
    }

    public void clickOnElement(WebElement element) {
        Wait.waitUntilParticularState(element::isEnabled);
        new Actions(getAndroidDriver()).click(element).perform();
    }

    public void putCursorToStart(WebElement element) {
        putCursorToEnd(element);
        int strLength = element.getText().length();
        pressKey(element, Keys.ARROW_LEFT, strLength);
    }

    public void putCursorToEnd(WebElement element) {
        clickOnElement(element);
        pressKey(element, Keys.END);
    }

    public void pressKey(WebElement element, Keys key) {
        new Actions(getAndroidDriver()).sendKeys(element, key).perform();
    }

    public void pressKey(WebElement element, Keys key, int timesToPress) {
        Actions action = new Actions(getAndroidDriver());
        for(int i = 0; i < timesToPress; i++){
            action.sendKeys(element, key).perform();
        }
    }
}

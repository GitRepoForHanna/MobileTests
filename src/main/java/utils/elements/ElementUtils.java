package utils.elements;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class ElementUtils {

    public static PointOption getCenterElementPointOption(WebElement element) {
        int y = element.getSize().getHeight()/2;
        int x = element.getRect().getWidth()/2;
        return new PointOption().point(element.getLocation().moveBy(x, y));
    }

    private static AndroidDriver getAndroidDriver() {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance();
    }

    public static void clickOnElement(WebElement element) {
        Wait.waitUntilParticularState(element::isEnabled);
        new Actions(getAndroidDriver()).click(element).perform();
    }

    public static void putCursorToStart(WebElement element) {
        putCursorToEnd(element);
        int strLength = element.getText().length();
        pressKey(element, Keys.ARROW_LEFT, strLength);
    }

    public static void putCursorToEnd(WebElement element) {
        clickOnElement(element);
        pressKey(element, Keys.END);
    }

    public static void pressKey(WebElement element, Keys key) {
        new Actions(getAndroidDriver()).sendKeys(element, key).perform();
    }

    public static void pressKey(WebElement element, Keys key, int timesToPress) {
        Actions action = new Actions(getAndroidDriver());
        for(int i = 0; i < timesToPress; i++){
            action.sendKeys(element, key).perform();
        }
    }
}

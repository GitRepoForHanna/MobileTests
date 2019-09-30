package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.androiddriver.AndroidDriverSingletone;

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

}

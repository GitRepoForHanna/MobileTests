package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.androiddriver.DriverUtils;

import java.util.List;

public abstract class BasePage {

    protected String resourceIdXPathPattern = "//*[@resource-id='%s']";
    protected static final long DEFAULT_HOLD_TIMEOUT = 3;

    protected List findElementsById(String elementId){
        return DriverUtils.getAndroidDriver().findElementsById(elementId);
    }

    protected WebElement findElementById(String elementId) {
        return DriverUtils.getAndroidDriver().findElement(By.id(elementId));
    }

    protected List findElementsByXpath(String elementXpath) {
        return DriverUtils.getAndroidDriver().findElementsByXPath(elementXpath);
    }

    protected WebElement findElementByXpath(String elementXpath) {
        return DriverUtils.getAndroidDriver().findElement(By.xpath(elementXpath));
    }

}

package utils.element_utils;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

public class ElementUtils {

    public static PointOption getCenterElementPointOption(WebElement element) {
        int y = element.getSize().getHeight()/2;
        int x = element.getRect().getWidth()/2;
        return new PointOption().point(element.getLocation().moveBy(x, y));
    }
}

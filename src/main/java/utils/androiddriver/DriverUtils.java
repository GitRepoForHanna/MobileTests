package utils.androiddriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverUtils {
    public static AndroidDriver getAndroidDriver() {
        return AndroidDriverSingletone.getSingletoneInstance().getDriverInstance();
    }

    public static Actions getActions() {
        return new Actions(getAndroidDriver());
    }
}

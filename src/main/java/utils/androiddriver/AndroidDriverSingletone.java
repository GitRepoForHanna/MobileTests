package utils.androiddriver;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverSingletone {

    private static AndroidDriverSingletone instance;
    private AndroidDriver driver;
    private static final String URL = "http://127.0.0.1:4723/wd/hub";


    public AndroidDriver initDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 2 API 28");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
        capabilities.setCapability("app","C:\\HannasWorkshop\\mobApps\\TestApp.apk");
        capabilities.setCapability("newCommandTimeout",7200);
        try {
            driver = new AndroidDriver<>(new URL(URL), capabilities);
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(AndroidDriverSingletone.class).info("MalformedURLException exception was caught \n" + ex.getMessage());
        }
        return driver;
    }

    private AndroidDriverSingletone() {
        initDriver();
    }

    public static AndroidDriverSingletone getSingletoneInstance() {
        if(null == instance){
            instance = new AndroidDriverSingletone();
        }
        return instance;
    }

    public AndroidDriver getDriverInstance() {
        if(null == driver) {
            initDriver();
        }
        return driver;
    }

    public void closeDriver() {
        driver.closeApp();
        driver.runAppInBackground(Duration.ofSeconds(1));
    }

    public void resetApp() {
        driver.resetApp();
    }
}

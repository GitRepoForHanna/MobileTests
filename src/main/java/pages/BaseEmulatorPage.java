package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

public class BaseEmulatorPage {

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowAccessButton;
    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")
    private WebElement skipButton;

    public BaseEmulatorPage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void clickAllowAccess() {
        Wait.waitUntilParticularState(allowAccessButton::isDisplayed);
        allowAccessButton.click();
    }

    public void clickSkipButton() {
        Wait.waitUntilParticularState(skipButton::isEnabled);
        skipButton.click();
    }
}

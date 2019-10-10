package popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.DriverUtils;
import utils.wait.Wait;

public class NewChecklistItemPopup extends BasePopup {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit")
    private WebElement bodyInput;

    @FindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private WebElement nextButton;

    public NewChecklistItemPopup() {
        PageFactory.initElements(DriverUtils.getAndroidDriver(), this);
    }

    public void setItemBody(String body) {
        Wait.waitUntilParticularState(() -> bodyInput.isEnabled());
        bodyInput.sendKeys(body);
    }

    public void clickNextButton() {
        Wait.waitUntilParticularState(() -> nextButton.isEnabled());
        nextButton.click();
    }
}



package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.androiddriver.AndroidDriverSingletone;
import utils.wait.Wait;

import java.util.ArrayList;
import java.util.List;

public class ChecklistNotePage extends NotePage {

    @FindBy(xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='Add Item']")
    private WebElement addNewItemButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/editlist")
    private WebElement listItemsPanel;

    private String checklistItemXPath = "//android.widget.RelativeLayout//android.widget.TextView";

    private String checklistItemXPathPattern = "//android.widget.RelativeLayout//android.widget.TextView[@text='%s']";

    private static final String DRAG_BUTTON_RESOURCE_ID = "com.socialnmobile.dictapps.notepad.color.note:id/icon_drag";

    private static final String DELETE_BUTTON_RESOURCE_ID = "com.socialnmobile.dictapps.notepad.color.note:id/btn_del";

    public ChecklistNotePage() {
        PageFactory.initElements(AndroidDriverSingletone.getSingletoneInstance().getDriverInstance(), this);
    }

    public void clickNewItem() {
        Wait.waitUntilParticularState(() -> addNewItemButton.isDisplayed());
        addNewItemButton.click();
    }

    public WebElement getChecklistItemElement(String itemTitle) {
        Wait.waitUntilParticularState(() -> listItemsPanel.isDisplayed());
        return listItemsPanel.findElement(By.xpath(String.format(checklistItemXPathPattern, itemTitle)));
    }

    public void clickDeleteItem(String itemTitle) {
        getChecklistItemElement(itemTitle).findElement(By.xpath(String.format(resourceIdXPathPattern, DELETE_BUTTON_RESOURCE_ID))).click();
    }

    public List<WebElement> getListItems() {
        Wait.waitUntilParticularState(() -> listItemsPanel.isDisplayed());
        return listItemsPanel.findElements(By.xpath(checklistItemXPath));
    }

    public List<String> getCheckListItems() {
        List<String> items = new ArrayList<String>();
        getListItems().stream()
                .map(WebElement::getText)
                .forEach(items::add);
        return items;
    }
}

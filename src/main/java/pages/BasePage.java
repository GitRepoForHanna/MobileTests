package pages;

public abstract class BasePage {

    protected String resourceIdXPathPattern = "//*[@resource-id='%s']";
    protected static final long DEFAULT_HOLD_TIMEOUT = 3;
}

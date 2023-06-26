import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesParser;

public abstract class BaseTest {

    protected Logger logger = AqualityServices.getLogger();

    @BeforeMethod
    protected void setUp() {
        getBrowser().goTo(PropertiesParser.getTestData().getUrl());
        getBrowser().waitForPageToLoad();
    }

    @AfterMethod
    protected void tearDown() {
        getBrowser().quit();
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}

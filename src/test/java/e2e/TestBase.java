package e2e;

import config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setApp() {
        app.init(new Config().getBrowser());
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}

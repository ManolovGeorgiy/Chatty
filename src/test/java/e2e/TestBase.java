package e2e;

import org.testng.ITestResult;
<<<<<<< HEAD
import config.Config;
=======
>>>>>>> origin/dev_Natalie
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setApp() {
        app.init();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        app.stop(result.isSuccess());
    }
}

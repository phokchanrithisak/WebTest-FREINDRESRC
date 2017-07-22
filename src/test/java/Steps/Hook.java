package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by chhormchhatra on 7/22/17.
 */

public class Hook extends BaseUtil{
    //    Before each scenario
    private BaseUtil base;
    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeBrowser(){

        /*
        * Configure the variables below
        * for example : change driverName to geckodriver
        *               and change driver property to webdriver.gecko.driver
        *               comment Chrome driver to run only firefox
        * */
        String driverName = "chromedriver";
        String driverProperty = "webdriver.chrome.driver";
        File fs = new File("src/test/Res", driverName);
        System.out.println("Opening Web Browser\n");
        System.setProperty(driverProperty , fs.getAbsolutePath());

        /*
        * Uncomment one of the driver below
        * */
        base.driver = new FirefoxDriver();
        base.driver = new ChromeDriver();

        /*
        * Implicit wait
        * */
        base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
    //    After each scenario
    @After
    public void closingBrowser(Scenario scenario){
        if(scenario.isFailed()){
//          TODO code to take screenshot
            System.out.println("The scenario " +scenario.getName()+"is failed");
        }
        base.driver.quit();
        System.out.println("Closing Web Browser");
    }

}

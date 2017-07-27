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
 * Created by chhormchhatra from KEEN Virtual Company of KIT on 7/22/17.
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
        * TODO Configure the variables below
        * for example : change driverName to chromedriver
        *               and change driver property to webdriver.chrome.driver
        *               comment firefox driver to run only chrome
        * NB:
        *   The two drivers given in src/test/Res are for macOS only
        *   For windows:
        *       Make sure to add extension .exe to driverName (e.g. driverName = "chromedriver.exe")
        *       Do not forget to change the path of driver to src//test//Res//Windows
        *       (e.g. fs = new File("src//test//Res//Windows", driverName);
        *       NB : if double forward slashes do not work, try double backward slashes
        * */
        String driverName = "geckodriver";
        String driverProperty = "webdriver.gecko.driver";
        File fs = new File("src/test/Res", driverName);
        System.out.println("Opening Web Browser\n");
        System.setProperty(driverProperty , fs.getAbsolutePath());

        /*
        * TODO comment one of the driver below
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

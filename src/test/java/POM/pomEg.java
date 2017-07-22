package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chhormchhatra on 7/22/17.
 */

public class pomEg {
    public pomEg(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "someXpath")
    WebElement elementName;

    public void actionButton() {
        elementName.click();
    }
}

package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class ListDemo {

    AppiumDriver<MobileElement> driver = null;

    public ListDemo(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By countryTextButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Cumulonimbus\"]/android.widget.TextView");
    By getOkayButton = By.xpath("//*[@text='OK']");
    By getCancelButton = By.xpath("//*[@text='CANCEL']");
    By getLearnMoreButton = By.xpath("//*[@text='LEARN MORE ABOUT CUMULONIMBUS']");


    public void validateListDemo() {

        Utilities.WaitAndClick(driver, countryTextButton);
        Utilities.WaitAndClick(driver, getOkayButton);
        //Utilities.WaitAndClick(driver, countryTextButton);
        //Utilities.WaitAndClick(driver, getCancelButton);
        //Utilities.WaitAndClick(driver, countryTextButton);
        //Utilities.WaitAndClick(driver, getLearnMoreButton);
        //Utilities.WaitAndClick(driver, getOkayButton);
        Utilities.goBack();
    }


}

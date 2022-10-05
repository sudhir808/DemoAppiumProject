package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class WebViewDemo {

    AppiumDriver<MobileElement> driver = null;

    public WebViewDemo(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By urlInput = By.xpath("//android.widget.EditText[@content-desc=\"urlInput\"]");
    By goButton = By.xpath("//android.view.ViewGroup[@content-desc=\"navigateBtn\"]/android.widget.TextView");
    By clearButton = By.xpath("//android.view.ViewGroup[@content-desc=\"clearBtn\"]/android.widget.TextView");

    By okButton=By.xpath("//*[@text='OK']");


    public void validateWebView() {
        Utilities.WaitAndSendkey(driver, urlInput, "https://appium.io/");
        Utilities.WaitAndClick(driver, clearButton);
        Utilities.WaitAndSendkey(driver, urlInput, "https://appium.io/");
        Utilities.WaitAndClick(driver, goButton);
        Utilities.WaitAndClick(driver, okButton);
        Utilities.goBack();
        //Utilities.goBack();
    }


}

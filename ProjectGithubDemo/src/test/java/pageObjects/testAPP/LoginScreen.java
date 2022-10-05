package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class LoginScreen {

    AppiumDriver<MobileElement> driver = null;
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//android.widget.EditText[@content-desc=\"username\"]");
    By passWord = By.xpath("//android.widget.EditText[@content-desc=\"password\"]");

    By loginButton=By.xpath("//android.view.ViewGroup[@content-desc=\"loginBtn\"]/android.widget.TextView");

    By okButton=By.xpath("//*[@text='OK']");

    public void validateLoginScreen() {
        Utilities.WaitAndSendkey(driver, userName, "test");
        Utilities.WaitAndSendkey(driver, passWord, "test123");
        Utilities.WaitAndClick(driver, loginButton);
        Utilities.WaitAndClick(driver, okButton);
        Utilities.goBack();
        //Utilities.goBack();
    }


}

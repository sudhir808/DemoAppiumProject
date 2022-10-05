package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class EchoBox {

    AppiumDriver<MobileElement> driver = null;
    public  EchoBox(  AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By messageInputBox = By.xpath("//android.widget.EditText[@content-desc=\"messageInput\"]");

    By saveButton=By.xpath("//android.view.ViewGroup[@content-desc=\"messageSaveBtn\"]/android.widget.TextView");

    public void validateEchoBox() {
        Utilities.WaitAndSendkey(driver, messageInputBox, "test");
        Utilities.WaitAndClick(driver, saveButton);
        Utilities.goBack();
        
    }


}


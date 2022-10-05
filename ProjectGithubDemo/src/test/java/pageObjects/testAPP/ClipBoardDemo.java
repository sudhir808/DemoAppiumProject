package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class ClipBoardDemo {

    AppiumDriver<MobileElement> driver = null;

    public ClipBoardDemo(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By refreshClipBoardButton = By.xpath("//android.view.ViewGroup[@content-desc=\"refreshClipboardText\"]/android.widget.TextView");
    By clipboardInputText = By.xpath("//android.widget.EditText[@content-desc=\"messageInput\"]");
    By setCliptoardButton = By.xpath("//android.view.ViewGroup[@content-desc=\"setClipboardText\"]/android.widget.TextView");


    public void validateClipBoardDemo() {
        Utilities.WaitAndSendkey(driver, clipboardInputText, "test123");
        Utilities.WaitAndClick(driver, refreshClipBoardButton);
        Utilities.WaitAndClick(driver, setCliptoardButton);
        Utilities.goBack();
        
    }


}

package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;

public class AppDashboard {

    AppiumDriver<MobileElement> driver = null;

    By appDashboardText = By.xpath("//*[@text='The App']");
    By chooseAnAwesomeText = By.xpath("//*[@text='Choose An Awesome View']");
    By eChoBoxText=By.xpath("//*[@text='Echo Box']");
    By loginScreen=By.xpath("//*[@text='Login Screen']");
    By clipboardScreen=By.xpath("//*[@text='Clipboard Demo']");
    By webViewDemo=By.xpath("//*[@text='Webview Demo']");
    By listDemo=By.xpath("//*[@text='List Demo']");
    By photoDemo=By.xpath("//*[@text='Photo Demo']");

    public  AppDashboard(  AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public void tapEchoBox() {
        Utilities.WaitAndClick(driver, eChoBoxText);
    }
    public void tapLoginScreen() {
        Utilities.WaitAndClick(driver, loginScreen);
    }
    public void tapClipBoardScreen() {
        Utilities.WaitAndClick(driver, clipboardScreen);
    }
    public void tapWebViewDemo() {
        Utilities.WaitAndClick(driver, webViewDemo);
    }
    public void tapListDemo() {
        Utilities.WaitAndClick(driver, listDemo);
    }
    public void tapPhotoDemo() {
        Utilities.WaitAndClick(driver, photoDemo);
    }

}

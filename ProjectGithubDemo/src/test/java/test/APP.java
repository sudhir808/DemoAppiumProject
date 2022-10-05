package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.testAPP.*;
import utils.Utilities;

import java.io.IOException;

public class APP extends  BaseTest{

    AppiumDriver<MobileElement> driver = getDriver();
    Utilities util = new Utilities(driver);
    AppDashboard appDashboard=new AppDashboard(driver);
    EchoBox echoBox=new EchoBox(driver);
    ClipBoardDemo clipBoardDemo=new ClipBoardDemo(driver);
    ListDemo listDemo=new ListDemo(driver);
    LoginScreen loginDemo = new LoginScreen(driver);
    PhotoDemo photoDemo=new PhotoDemo(driver);
    WebViewDemo webViewDemo=new WebViewDemo(driver);

    @Test
    public void APP() throws InterruptedException, IOException {
        driver.resetApp();
        APP apptest = new APP();
        String className = apptest.getClass().getName();
        System.out.println("sheet name" + className);
        String trimClassName = className.substring(5, 8);
        System.out.println(trimClassName);

        appDashboard.tapEchoBox();
        echoBox.validateEchoBox();


        appDashboard.tapClipBoardScreen();
        clipBoardDemo.validateClipBoardDemo();
        appDashboard.tapListDemo();
        listDemo.validateListDemo();
        appDashboard.tapWebViewDemo();
        webViewDemo.validateWebView();
        appDashboard.tapPhotoDemo();
        photoDemo.validatePhotoDemo();
        appDashboard.tapLoginScreen();
        loginDemo.validateLoginScreen();

    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {

        driver.resetApp();

    }



}

package pageObjects.testAPP;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Utilities;


public class PhotoDemo {

    AppiumDriver<MobileElement> driver = null;

    public PhotoDemo(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By firstPhoto = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView");
    By getOkayButton = By.xpath("//*[@text='OK']");



    public void validatePhotoDemo() {

        Utilities.WaitAndClick(driver, firstPhoto);
        Utilities.WaitAndClick(driver, getOkayButton);
        Utilities.goBack();
    }


}

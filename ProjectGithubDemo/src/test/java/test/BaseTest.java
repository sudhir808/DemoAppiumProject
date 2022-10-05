package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import testData.FetchData;

public class BaseTest {

	public static AppiumDriver<MobileElement> driver;

	public AppiumDriver<MobileElement> getDriver() {

		if (driver == null)
			return setup();
		return driver;

	}

	public AppiumDriver<MobileElement> setup() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
	//	cap.setCapability("deviceName", "And");
	//	cap.setCapability("udid", "USCAXWMJT4JBMVMB");
//		 cap.setCapability("udid", "emulator-5554");
//		cap.setCapability("udid", "192.168.0.196:5555");
		// cap.setCapability("udid", "RZ8N92L161P");
		cap.setCapability("browserstack.enableCameraImageInjection", "true");
	//	cap.setCapability("platformName", "Android");
	//	cap.setCapability("platformVersion", "12");
	//	cap.setCapability("appPackage", "io.cloudgrey.the_app");
	//	cap.setCapability("appActivity", "io.cloudgrey.the_app.MainActivity");

		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

	public AppiumDriver<MobileElement> getDriver2() {

		if (driver == null)
			return setup2();
		return driver;

	}

	public AppiumDriver<MobileElement> setup2() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "And");
		cap.setCapability("udid", "USCAXWMJT4JBMVMB");
//		 cap.setCapability("udid", "emulator-5554");
		// cap.setCapability("udid", "192.168.0.135:5555");
//		cap.setCapability("udid", "RZ8N92L161P");
		cap.setCapability("browserstack.enableCameraImageInjection", "true");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "io.cloudgrey.the_app");
		cap.setCapability("appActivity", "io.cloudgrey.the_app.MainActivity");


		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

	public static void getScreenshot(String name) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH.mm.ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(
				"C:\\Users\\Nikhil\\Downloads\\Singlife\\Singlife\\Screenshots\\" + name + " " + date1 + ".png"));
	}

	/*public void database(int i) throws InterruptedException {

		// Database URL and Name
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://127.0.0.1:9999/centralDB";

		// Database credentials
		final String user = "cdbesb";
		final String pass = "7@0sCM%A";

		Connection con = null;
		Statement stmt = null;

		try {

			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// open connection
			try {
				con = DriverManager.getConnection(DB_URL, user, pass);

				// Execute Query
				stmt = con.createStatement();
				String mobile = FetchData.dataDriven(i, 0);
				String doc = FetchData.dataDriven(i, 17);

				String id = "select * from party where documentNumber='" + mobile + "'";

				ResultSet executeQuery2 = stmt.executeQuery(id);
				executeQuery2.next();
				String partyId = executeQuery2.getString(1);

				if (doc.contains("S")) {
					String sqlPartyNric = "Update party SET documentNumber = '" + doc
							+ "', documentType='NRIC' where id='" + partyId + "'";
					int executePartyNric = stmt.executeUpdate(sqlPartyNric);
					System.out.println("partytable updated NRIC   " + executePartyNric);
				}

				else {
					String sqlPartyFin = "Update party SET documentNumber = '" + doc
							+ "', documentType='FIN' where id='" + partyId + "'";
					int executePartyFin = stmt.executeUpdate(sqlPartyFin);
					System.out.println("partytable updated FIN   " + executePartyFin);
				}

				String sqlKyc = "Update kyc SET status = 'active' where partyId IN ( select id from party where documentNumber='"
						+ doc + "')";
				int executeQuery = stmt.executeUpdate(sqlKyc);

				System.out.println("Result  " + executeQuery);

				System.out.println("partyID number  " + partyId);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
}
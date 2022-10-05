package report;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	private static ExtentReports report = ExtentManager.getReport();
	private static HashMap<Long, ExtentTest> testMap = new HashMap<Long,ExtentTest>();
	
	public static synchronized void startTest(String testName) {
		testMap.put(Thread.currentThread().getId(), report.createTest(testName));
	}
	
	public static synchronized ExtentTest getTest() {
		return testMap.get(Thread.currentThread().getId());
	}
	
	public static synchronized void  finishTest() {
		report.flush();
	}

}

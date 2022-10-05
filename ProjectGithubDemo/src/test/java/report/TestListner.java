package report;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import test.BaseTest;

public class TestListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel("Test is passed", ExtentColor.GREY));

	}

	public void onTestFailure(ITestResult result) {

		ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel("Test is Failed", ExtentColor.RED));
		ExtentTestManager.getTest().fail(result.getThrowable());
		
		
		  String name = result.getName(); 
		  try { BaseTest.getScreenshot(name); 
		  } 
		  catch
		  (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
			  }
		  }
		 
	

	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel("Test is skipped", ExtentColor.ORANGE));
		ExtentTestManager.getTest().skip(result.getThrowable());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Project started");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTestManager.finishTest();
	}

}

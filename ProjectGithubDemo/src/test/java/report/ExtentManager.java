package report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentSparkReporter htmlReport;
	private static ExtentReports report;
	
	
	public static ExtentReports getReport() {
		if (report == null)
			return createReport();
		return report;
			
	}
	
	public static ExtentReports createReport() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH.mm.ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		htmlReport = new ExtentSparkReporter("extentReport "+ date1+".html");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		return report;
	}

}

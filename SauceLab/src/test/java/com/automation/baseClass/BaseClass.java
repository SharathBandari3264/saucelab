package com.automation.baseClass;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automation.driver.BrowserOpen;
import com.automation.supportLibraries.Log4jUtil;
import com.automation.supportLibraries.PropertiesRead;
import com.automation.supportLibraries.Report;
import com.automation.supportLibraries.Util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static long timeOut = 30, driverWait = 30, emailTimeOut;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static ExtentTest testFinal;
	public static ExtentReports extentFinal;
	public static ExtentHtmlReporter htmlReporterFinal;
	public static ExtentHtmlReporter htmlReporterIndividual;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static int individualRptCount = 0;
	public static String systemDir = System.getProperty("user.dir");
	public static Properties configProp;
	public static Properties prop;
	public static String ResultFolderPath;
	public String browser;
	public static String scenarioName = "";
	public static final String CurrentDateFolder = Util.DateString();
	protected static Logger log = Log4jUtil.loadLogger(BaseClass.class);
	String deviceName = "";
	String suiteName = "";
	protected String strStatus ="" ;

	@BeforeSuite()
	@Parameters({ "applicationName" })
	public void initializeWebdriver(@Optional("Test") String applicationName, ITestContext context) throws Exception  {
		if (StringUtils.isEmpty(ResultFolderPath)) {
			ResultFolderPath = systemDir + "\\TestResults" + "\\" + "Report_" + CurrentDateFolder + "\\";
			System.out.println("Results Folder Path: "+ResultFolderPath);
		}
		Util.CreateFolder(ResultFolderPath);
		configProp = PropertiesRead.readConfigProperty();
		String testName = context.getName();
		htmlReporterFinal = Report.StartHtmlFinalReport(htmlReporterFinal, testName, applicationName, ResultFolderPath);
		extent = Report.StartExtentReport(htmlReporterFinal, extent);
		driver = BrowserOpen.startBrowser();
	}

	@AfterClass
	public void quitReport(ITestContext contextContext) throws IOException {
		try {
			Report.reportLink(testFinal);
			Report.endReport(extent); //// individual test report
			String reportNamePath = Report.reportName;
			File input = new File(reportNamePath);
			Document html = Jsoup.parse(input, "UTF-8");
			String invidualTestStatus = html.getElementsByAttributeValueContaining("class", "test-status right").text();
			if (invidualTestStatus.trim().equalsIgnoreCase("fail")) {
				Report.failTest("Test Case Failed " + contextContext.getCurrentXmlTest().getName());
			} else if ((invidualTestStatus.toLowerCase().trim().contains("pass"))
					&& (html.getElementsByAttributeValueContaining("class", "label white-text teal").size() != 0)) {
				Report.passTest("Test Case Passed " + contextContext.getName());
			} else {
				Report.failTest("Partially Executed " + contextContext.getName());
			}
			driver.close();
		} catch (Exception e) {
			driver.close();
			Report.endReport(extent);
		}
	}	
}
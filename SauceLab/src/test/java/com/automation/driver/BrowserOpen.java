package com.automation.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.baseClass.BaseClass;

public class BrowserOpen extends BaseClass{
	static String systemDir = System.getProperty("user.dir");

	public static WebDriver startBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sharath.bandari\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("slApplicationUrl"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}


	/*public static ChromeDriverEx startBrowser() {

//		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });
		// chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("profile.default_content_settings.popups", 1); // 01302018
		chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1); // For allowing multiple file downloads
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.setExperimentalOption("useAutomationExtension", false); 
		options.addArguments("disable-infobars");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setBrowserName("chrome");
		try {
			driver = new ChromeDriverEx();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("slApplicationUrl"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}*/
}
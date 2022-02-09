package syndication.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
//Importing log4j
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
//Importing the selenium webdriver related libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

//Creating a Test base class
public class TestBase {

	// Create objects for Extent reports
	ExtentReports extent;
	ExtentTest test;
	// Logger variable
	static final Logger logger = Logger.getLogger(TestBase.class.getName());
	private static String urlSlackWebHook = "https://hooks.slack.com/services/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";
	private static String channelName = "automation-report";
	private static String botUserOAuthAccessToken = "xoxp-1417556211330-1569979863520-3062095825607-af06d62e419dea9d9a0efbfd7bb2764e";

	// Variable for recording the video
	private ATUTestRecorder recorder;

	// private String automationCleanUpEndpoint =
	// "https://api.dev.synpro.com/api/v1/automation/cleanup";
	// setting a variable as null
	public static WebDriver driver = null;
	// Declaring an object properties for the java class properties.
	// This props will hold the details in the properties file
	static ClassLoader loader = Thread.currentThread().getContextClassLoader();
	protected static Properties props;
	public static String browser, sessionID, jobID;;

	/**
	 * Create a setup method to run before start of every suite
	 * 
	 * @param browser
	 * @throws IOException
	 */
	public void setup(String browser) throws IOException {
		this.browser = browser;
		try {
			// Read the property file
			readPropFile();

			/*
			 * File screenRecordingFolder = new File(System.getProperty("user.dir") +
			 * "/test-output/synproTestResult"); if(!screenRecordingFolder.exists()) {
			 * screenRecordingFolder.mkdirs(); }
			 */

			// FileUtils.cleanDirectory(new File(System.getProperty("user.dir") +
			// "/test-output/synproTestResult"));
			if (browser.equalsIgnoreCase("chrome")) {
				extent = new ExtentReports(
						System.getProperty("user.dir") + "/test-output/synproTestResult/SynProAutomationreport.html",
						Boolean.TRUE);
				extent.addSystemInfo("Browser", browser);
			} else if (browser.equalsIgnoreCase("firefox")) {
				extent = new ExtentReports(
						System.getProperty("user.dir") + "/test-output/synproTestResult/SynProAutomationreport.html",
						false);
				extent.addSystemInfo("Browser", browser);
			}
			// Extent reports Setup;
			extent.addSystemInfo("Enivornment", "IT");
			extent.addSystemInfo("Team", "SynPro Testing");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

			// test setup based on the details in the property file
			// Run the browser based on user configuration and bring focus
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("enable-automation");
				// options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--enable-extensions");
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-gpu");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Long.valueOf(props.getProperty("implicitwait")),
						TimeUnit.SECONDS);

//				DesiredCapabilities caps = DesiredCapabilities.chrome();
//				caps.setCapability("version", "");
//				caps.setPlatform(Platform.LINUX);
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
//				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
//				sessionID = ((RemoteWebDriver) driver).getSessionId().toString();

				// jobID="https://app.saucelabs.com/tests/"+sessionID+"/watch";
				// Reporter.log("Sauce lab video url for Prelogin suite-->"+jobID);
				// logger.info("Sauce lab video url for Prelogin suite-->"+jobID);

				driver.manage().window().maximize();
				GetDriver.setDriver(driver);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				// options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
				GetDriver.setDriver(driver);
			} else {
				logger.info("Internet explorer");
			}

			File recordingFolder = new File(System.getProperty("user.dir") + "/test-output/Recordings");
			if (!recordingFolder.exists()) {
				recordingFolder.mkdirs();
			}
			// Delete all previous videos and recordings
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/test-output/Recordings"));
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/test-output/Screenshots"));
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

	// @BeforeMethod
	public void startRecording(String method) throws ATUTestRecorderException {

		try {
			this.recorder = new ATUTestRecorder(System.getProperty("user.dir") + "/test-output/Recordings/", method,
					false);
			recorder.start();
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

	@AfterMethod
	public void takescreenshotonfail(ITestResult result, Method method) throws IOException, ATUTestRecorderException {
		try {
			recorder.stop();
			renameFileExtension(System.getProperty("user.dir") + "/test-output/Recordings/" + method.getName() + ".mov",
					"mp4");
			String movie = test.addScreencast(
					System.getProperty("user.dir") + "/test-output/Recordings/" + method.getName() + ".mp4");

			if (ITestResult.SUCCESS == result.getStatus()) {
				// delete the file
				FileUtils.forceDelete(new File(
						System.getProperty("user.dir") + "/test-output/Recordings/" + method.getName() + ".mp4"));
				logger.info("The movie file deleted as the testcase passed");
			}

			// Here will compare if test is failing then only it capture the video and
			// provide the link
			else if (ITestResult.FAILURE == result.getStatus()) {
				// Call method to capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// result.getName() will return name of test case so that screenshot name will
				// be same
				String screenshotPath = props.getProperty("screenshotsPath") + result.getName() + ".png";
				FileUtils.copyFile(scrFile, new File((screenshotPath)));
				logger.info("Screenshot taken" + result.getName());
				// Add the screenshot to the report
				test.log(LogStatus.FAIL, result.getName(), movie);
				test.log(LogStatus.INFO, "Download the video file using right click->save videos as option");
				logger.info("The link to screen recording is captured in the report");
				String image = test.addScreenCapture(
						System.getProperty("user.dir") + "/test-output/Screenshots/" + result.getName() + ".png");
				test.log(LogStatus.FAIL, result.getName(), image);
				// test.log(LogStatus.FAIL,result.getThrowable());
				sendTestExecutionStatusToSlack("Sending Report");
			}
			extent.endTest(test);

			// sendTestExecutionReportToSlack();
		} catch (Exception e) {
			logger.info(e.toString());
			extent.endTest(test);
		}
	}

	/**
	 * Before each test load the url
	 * 
	 * @param url
	 * @param siteTitle
	 */
	public void loadUrl(String url, String siteTitle) {
		try {
			// Calling the url through the driver object
			driver.manage().deleteAllCookies();
			driver.get(url);
			// Setting time out if the credentials fails
			// Assert.assertEquals(siteTitle, driver.getTitle());
			driver.switchTo().window(driver.getTitle());
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window,focus()");
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

	/**
	 * After each and every test case, close all windows
	 */
	@AfterTest
	public void closeAllWindows() {
		try {
			String homeWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();

			// Use Iterator to iterate over windows
			Iterator<String> windowIterator = allWindows.iterator();

			// Verify next window is available
			while (windowIterator.hasNext()) {

				// Store the child window id
				String childWindow = windowIterator.next();

				if (homeWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
					driver.manage().deleteAllCookies();
					deleteAllCookiesOneByOne();

				}
			}

		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

	/**
	 * Quit driver
	 */
	@AfterSuite
	public void quitDrivers() {
		try {
			logger.info("Running after every Scenario...");
//			Response response = RestAssured.given().request().get(automationCleanUpEndpoint).andReturn();
//			logger.info(response.asString());
//			driver.quit();
//			driver.close();
//			extent.flush();
			// extent.close();
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	@BeforeSuite
	public void startDrivers() {
		try {
			logger.info("Running after before Scenario...");
//			Response response = RestAssured.given().request().get(automationCleanUpEndpoint).andReturn();
//			logger.info(response.asString());
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	/**
	 * Method to load and read the property file
	 */
	public static void readPropFile() {
		logger.info("Reading properties file");
		props = new Properties();
		InputStream stream = loader.getResourceAsStream("config.properties");
		try {
			props.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * To rename the extension of the file
	 * 
	 * @param source
	 * @param newExtension
	 * @return
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 */
	public static boolean renameFileExtension(String source, String newExtension)
			throws FileNotFoundException, NullPointerException {
		String target;
		String currentExtension = getFileExtension(source);

		if (currentExtension.equals("")) {
			target = source + "." + newExtension;
		} else {
			target = source.replaceFirst(Pattern.quote("." + currentExtension) + "$",
					Matcher.quoteReplacement("." + newExtension));
		}
		return new File(source).renameTo(new File(target));
	}

	/**
	 * @param sourceFile
	 * @return
	 */
	public static String getFileExtension(String sourceFile) {
		String ext = "";
		int i = sourceFile.lastIndexOf('.');
		if (i > 0 && i < sourceFile.length() - 1) {
			ext = sourceFile.substring(i + 1);
		}
		return ext;
	}

	// Method to delete all cookies
	public void deleteAllCookiesOneByOne() {
		try {
			int noOfCookies = driver.manage().getCookies().size();
			if (noOfCookies > 0) {
				logger.info("Number of cookies found: " + Integer.toString(noOfCookies));
			}
			Set<Cookie> cookies = driver.manage().getCookies();
			for (Cookie cookie : cookies) {
				logger.info("Cookie found with name: " + cookie.getName() + " and path: " + cookie.getPath()
						+ " and domain: " + cookie.getDomain());
				String javascriptCall = "document.cookie = \"" + cookie.getName() + " path=" + cookie.getPath()
						+ "; expires=Thu, 01-Jan-1970 00:00:01 GMT;\"";
				logger.info("Attempting to expire the cookie with the following script: " + javascriptCall);
				((JavascriptExecutor) driver).executeScript(javascriptCall);
			}
			logger.info("Number of cookies is now: " + Integer.toString(driver.manage().getCookies().size()));
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	@SuppressWarnings("deprecation")
	public void sendTestExecutionStatusToSlack(String message) throws Exception {
		try {
			StringBuilder messageBuider = new StringBuilder();
			messageBuider.append(message);
			Payload payload = Payload.builder().channel(channelName).text(messageBuider.toString()).build();
			WebhookResponse webhookResponse = Slack.getInstance().send(urlSlackWebHook, payload);
			webhookResponse.getMessage();
		} catch (IOException e) {
			System.out.println("Unexpected Error! WebHook:" + urlSlackWebHook);
		}
	}
}

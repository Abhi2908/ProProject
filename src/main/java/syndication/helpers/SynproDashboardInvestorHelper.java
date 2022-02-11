package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.pages.SynproMyAccountInvestorPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproDashboardInvestorHelper extends CommonUtils {

	static final Logger LOGGER = Logger.getLogger(SynproDashboardInvestorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();
	SynproMyAccountInvestorPage myAccountInvestorPage = new SynproMyAccountInvestorPage();

	String upload_photo_verification = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "test" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "verification.png";

	// final InputStream inputStream =
	// Thread.currentThread().getContextClassLoader()
	// .getResourceAsStream("static/file_example_PNG_3MB.png");

	/**
	 * @param login via Gmail a/c
	 * @throws Exception
	 */
	public void verifyTourAsInvestor(String dashboardInvestUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		focusStop(2000);

		// wait until Welcome pop-up page visible
		waitUntilLoadingPage("Welcome", commonPage.common_clickable_button("Welcome"));

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(dashboardInvestUrl);

		// Verifying and click on Start tour
		waitForElementToBeClickable(commonPage.common_clickable_button("Start Tour"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Start Tour"));

		// click and verify Invest pop-up
		waitUntilLoadingPage("Invest", commonPage.common_clickable_button("Invest"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify My Investments pop-up
		waitUntilLoadingPage("My Investments", commonPage.common_clickable_button("My Investments"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Updates pop-up
		waitUntilLoadingPage("Updates", commonPage.common_clickable_button("Updates"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Distributions pop-up
		waitUntilLoadingPage("Distributions", commonPage.common_clickable_button("Distributions"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Documents pop-up
		waitUntilLoadingPage("Documents", commonPage.common_clickable_button("Documents"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Profiles pop-up
		waitUntilLoadingPage("Profiles", commonPage.common_clickable_button("Profiles"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Account pop-up
		waitUntilLoadingPage("Next", commonPage.common_clickable_button("Next"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// click and verify Sharing pop-up
		waitUntilLoadingPage("Sharing", commonPage.common_clickable_button("Sharing"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Next"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Next"));

		// Close Tour and verify Email Subscription pop-up
		waitUntilLoadingPage("Email Subscription", commonPage.common_clickable_button("Email Subscription"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Close Tour"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Close Tour"));

	}

	public void verifyMyInfoPageAsInvestor(String investorAccountUrl) throws Exception {

		// click and verify My info
		waitUntilLoadingPage("My Info", commonPage.common_clickable_button("My Info"));
		waitForElementToBeClickable(commonPage.common_clickable_button("My Info"));
		moveToWebElementAndClick(commonPage.common_clickable_button("My Info"));

		// verifying the investor Account page URL
		verifyingLoadApplicationPageUrl(investorAccountUrl);

		// Assert all values
		assertString(textFromField(commonPage.common_field_value("First Name")), TestData.FIRSTNAME_AS_INVESTOR);
		assertString(textFromField(commonPage.common_field_value("Last Name")), TestData.LASTNAME_AS_INVESTOR);
		assertString(textFromField(commonPage.common_field_value("Email")), TestData.EMAIL_ID_AS_INVESTOR);
		assertString(textFromField(commonPage.common_field_value("How did you hear about us?")),
				TestData.HEAR_ABOUT_US);

		// upload photo
		waitFindUploadPhotoWithoutClick(myAccountInvestorPage.upload_file_investor, upload_photo_verification);

		// click on save
		waitUntilLoadingPage("Crop Image", commonPage.common_clickable_button("Crop Image"));
		waitForElementToBeClickable(myAccountInvestorPage.save_file_button);
		moveToWebElementAndClick(myAccountInvestorPage.save_file_button);

		// click on save changes
		waitUntilLoadingPage("Save Changes", commonPage.common_clickable_button("Save Changes"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Save Changes"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Save Changes"));
	}

	
}

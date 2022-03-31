package syndication.helpers;

import java.util.List;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproRegistrationPage;
import syndication.web.CommonUtils;
import syndication.web.ReadFile;
import syndication.web.TestData;

public class SynproRegistrationHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproRegistrationHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproRegistrationPage registrationPage = new SynproRegistrationPage();
	ReadFile read = new ReadFile();
	
	
	String emailFile = getProps().getProperty("EmailPath");
	String emailFilePath = (System.getProperty("user.dir") + emailFile);
	String passwordFile = getProps().getProperty("PasswordPath");
	String passwordFilePath = (System.getProperty("user.dir") + passwordFile);

	String Name = "Customer";
	int row = 0;

	/**
	 * @param login via Gmail a/c
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void negativeTestScenarioRegistrationAsInvestor(String registrationUrl) throws Exception {

		// wait to load page
		waitForPageLoad();
		try {
			if (checkElementPresence(commonPage.common_clickable_button("Register Now to Invest"))) {

				// Verifying the home page registration button
				waitForElementToBeClickable(commonPage.common_clickable_button("Register Now to Invest"));
				moveToWebElementAndClick(commonPage.common_clickable_button("Register Now to Invest"));

				// verifying the registration page URL
				verifyingLoadApplicationPageUrl(registrationUrl);

				logger.info("Register page visible after click on Register now button");
				assert true;
			} else {
				logger.info("Register page not visible");
				assert false;
			}
		} catch (Exception e) {
			logger.error(e);
		}

		// wait until loading page
		waitUntilLoadingPage("Email", commonPage.common_clickable_button("Email"));
		focusStop(2000);
		waitUntilLoadingPage("Register", commonPage.common_clickable_button("Register"));

		// click on register
		waitForElementToBeClickable(commonPage.common_clickable_button("Register"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Register"));

		// assert error message for registration
		assertString(textFromApplication(commonPage.common_clickable_button("First Name is required")),
				TestData.FIRST_NAME_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Last Name is required")),
				TestData.LAST_NAME_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Email is required")),
				TestData.EMAIL_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Phone number is required")),
				TestData.PHONE_NUMBER_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("State is required")),
				TestData.STATE_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Investment Capacity is required")),
				TestData.INVESTMENT_CAPACITY_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Accredited Investor is required")),
				TestData.ACCREDITED_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("How did you hear about us is required")),
				TestData.HOW_DID_YOU_HEAR_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Password is required")),
				TestData.PASSWORD_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Confirm Password is required")),
				TestData.CONFIRM_PASSWORD_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Please accept terms and conditions")),
				TestData.TERM_AND_CONDITIONS_ERROR_MSG);

		// Invalid email verification

		List<Object> itemList = read.getTableArray(emailFilePath, Name, row);
		if (!itemList.isEmpty()) {

			int lengh = itemList.size();

			for (int i = 0; i < lengh; i++) {
				// String item = itemList.get(i).toString();

				waitFindEnterTextAsList(commonPage.common_send_text("email"), itemList.get(i).toString());
				// click on login
				waitForElementToBeClickable(commonPage.common_clickable_button("Register"));
				accessLink(commonPage.common_clickable_button("Register"));
				// Assert error messages
				assertString(textFromApplication(commonPage.common_clickable_button("Invalid email address")),
						TestData.INVALID_EMAIL_ERROR_MSG);
			}

		}

		// invalid password verification

		List<Object> itemPasswordList = read.getTableArray(passwordFilePath, Name, row);
		if (!itemPasswordList.isEmpty()) {

			int lengh = itemPasswordList.size();

			for (int i = 0; i < lengh; i++) {
				// String item = itemList.get(i).toString();

				waitFindEnterTextAsList(commonPage.common_send_text("password"), itemPasswordList.get(i).toString());
				// click on login
				waitForElementToBeClickable(commonPage.common_clickable_button("Register"));
				accessLink(commonPage.common_clickable_button("Register"));
				// Assert error msges
				assertString(textFromApplication(commonPage.common_clickable_button(
						"Password must have at least 12 characters, one uppercase letter, one lowercase letter, one number and one special character.")),
						TestData.PASSWORD_TWELVE_CHARACTER_ERROR_MSG);
			}

		}
		// verify confirm match password
		waitFindEnterText(commonPage.common_send_text("confirmPassword"), TestData.PASSWORD);
		assertString(
				textFromApplication(commonPage.common_clickable_button("Password and Confirm Password does not match")),
				TestData.PASSWORD_MATCH_ERROR_MSG);

	}

	/**
	 * @param login via Gmail a/c
	 * @throws Exception
	 */
	public void registrationAsInvestor(String registrationUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// Verifying the home page registration button
		waitForElementToBeClickable(commonPage.common_clickable_button("Register Now to Invest"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Register Now to Invest"));

		// verifying the registration page URL
		verifyingLoadApplicationPageUrl(registrationUrl);

		focusStop(2000);

		// wait until loading page
		waitUntilLoadingPage("Email", commonPage.common_clickable_button("Email"));

		// Enter values in text fields
		waitFindEnterText(commonPage.common_send_text("firstName"), TestData.FIRSTNAME_AS_INVESTOR);
		waitFindEnterText(commonPage.common_send_text("lastName"), TestData.LASTNAME_AS_INVESTOR);

		// Click and select value from residency drop-down
		//waitForElementToBeClickable(registrationPage.residency_dropDown("Residency"));
		focusStop(3000);
		moveToWebElementAndClick(registrationPage.residency_dropDown);
		moveToWebElementAndClick(registrationPage.residency_dropDown);
		moveToWebElementAndClick(commonPage.common_clickable_button("California"));

		// Enter values in email and phone
		waitFindEnterTextAsList(commonPage.common_send_text("email"), TestData.EMAIL_ID_AS_INVESTOR);
		waitFindEnterText(registrationPage.phone, TestData.PHONE_AS_INVESTOR);

		// Click and select from i am looking to invest
		moveToWebElementAndClick(registrationPage.i_am_looking_to_invest);
		waitForElementToBeClickable(commonPage.common_clickable_button("$10,000 - $50,000"));
		moveToWebElementAndClick(commonPage.common_clickable_button("$10,000 - $50,000"));

		// Enter values in hear about us and password
		waitFindEnterText(commonPage.common_send_text("hearAboutUs"), TestData.HEAR_ABOUT_US);
		waitFindEnterTextAsList(commonPage.common_send_text("password"), TestData.PASSWORD);
		waitFindEnterTextAsList(commonPage.common_send_text("confirmPassword"), TestData.PASSWORD);

		// Click and select value from Are you an accredited investor ?
		moveToWebElementAndClick(registrationPage.are_you_an_accredited_investor);
		waitForElementToBeClickable(commonPage.common_clickable_button("Yes"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Yes"));

		// click on terms and conditions
		waitForElementToBeClickable(registrationPage.terms_of_service);
		moveToWebElementAndClick(registrationPage.terms_of_service);
		
		// click on register
		waitForElementToBeClickable(commonPage.common_clickable_button("Register"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Register"));
		
		focusStop(15000);
		
		if (checkElementPresence(commonPage.common_clickable_button("User with this email already exists")) == true) {
			// Login here
			waitForElementToBeClickable(commonPage.common_clickable_button("Login here"));
			accessLink(commonPage.common_clickable_button("Login here"));

			waitForPageLoad();
			Thread.sleep(2000);

			// Enter values in text fields
			waitFindEnterText(commonPage.common_send_text("email"), TestData.EMAIL_ID_AS_INVESTOR);
			waitFindEnterText(commonPage.common_send_text("password"), TestData.PASSWORD);

			// clicking on login button
			waitForElementToBeClickable(commonPage.common_clickable_button("Log in"));
			moveToWebElementAndClick(commonPage.common_clickable_button("Log in"));

		}

	}

}

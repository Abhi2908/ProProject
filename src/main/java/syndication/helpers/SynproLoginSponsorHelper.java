package syndication.helpers;

import java.util.List;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproRegistrationPage;
import syndication.web.CommonUtils;
import syndication.web.ReadFile;
import syndication.web.TestData;

public class SynproLoginSponsorHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproLoginSponsorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproRegistrationPage registrationPage = new SynproRegistrationPage();
	ReadFile read = new ReadFile();

	// file path
	String emailFile = getProps().getProperty("EmailPath");
	String emailFilePath = (System.getProperty("user.dir") + emailFile);
	String Name = "Customer";
	int row = 0;

	/**
	 * @param sending_url Verifying login URl and clicking on Buy Button
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void negativeScenarioForLoginPage(String sending_url) throws Exception {

		// wait to load page
		waitForPageLoad();

		// clicking on login button
		waitUntilLoadingPage("Enter Email", commonPage.common_clickable_button("Enter Email"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Log in"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Log in"));

		// assert email error message
		assertString(textFromApplication(commonPage.common_clickable_button("Email is required")),
				TestData.EMAIL_ERROR_MSG);
		assertString(textFromApplication(commonPage.common_clickable_button("Password is required")),
				TestData.PASSWORD_ERROR_MSG);

		// Invalid email verification

		List<Object> itemList = read.getTableArray(emailFilePath, Name, row);
		if (!itemList.isEmpty()) {

			int lengh = itemList.size();

			for (int i = 0; i < lengh; i++) {
				// String item = itemList.get(i).toString();

				waitFindEnterTextAsList(commonPage.common_send_text("email"), itemList.get(i).toString());
				// click on login
				waitForElementToBeClickable(commonPage.common_clickable_button("Log in"));
				moveToWebElementAndClick(commonPage.common_clickable_button("Log in"));
				// Assert error msges
				assertString(textFromApplication(commonPage.common_clickable_button("Invalid email address")),
						TestData.INVALID_EMAIL_ERROR_MSG);
			}

		}

	}

	public void loginPage() throws Exception {

		// wait to load page
		waitForPageLoad();

		// Enter values in text fields
		waitFindEnterTextAsList(commonPage.common_send_text("email"), "sweta.sharan@armentum.co");
		waitFindEnterTextAsList(commonPage.common_send_text("password"), "123");

		// clicking on login button
		waitForElementToBeClickable(commonPage.common_clickable_button("Log in"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Log in"));

	}

}

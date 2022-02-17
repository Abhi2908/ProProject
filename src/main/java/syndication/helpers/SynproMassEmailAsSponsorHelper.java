package syndication.helpers;

import org.apache.log4j.Logger;
import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproMassEmailAsSponsorPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproMassEmailAsSponsorHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproMassEmailAsSponsorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproMassEmailAsSponsorPage massEmailPage = new SynproMassEmailAsSponsorPage();
	
	/**
	 * @param sending_url Verifying login URl and clicking on Buy Button
	 * @throws Exception
	 */
	public void massAsSendEmail(String massEmailUrl) throws Exception {

		// wait to load page
		waitForPageLoad();
		
		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));
		
		// Verifying click on Email
		waitForElementToBeClickable(commonPage.common_clickable_button("Email"));
		accessLink(commonPage.common_clickable_button("Email"));

		// clicking on Email button
		waitUntilLoadingPage("Send Email", commonPage.common_clickable_button("Send Email"));
		accessLink(commonPage.common_clickable_button("Send Email"));
		
		// verifying the Email page URL
		verifyingLoadApplicationPageUrl(massEmailUrl);
		
		// click on drop-down and select value
		waitForElementToBeClickable(massEmailPage.recipients_dropDown);
		waitFindEnterText(massEmailPage.recipients_dropDown, "All");
		accessLink(massEmailPage.recipients_value);

		// Email Subject
		javaScriptScrollUsingBy(commonPage.common_send_text("subject"));
		waitFindEnterText(commonPage.common_send_text("subject"), TestData.EMAIL_SUBJECT);
		
		// enter name
		waitFindEnterTextAsList(commonPage.common_send_text("name"), TestData.MASS_EMAIL_NAME);
		
		// enter email id
		waitFindEnterTextAsList(commonPage.common_send_text("replyTo"), TestData.EMAIL_ID_ADD_LEADS);
		
		// click email type and select value
		waitForElementToBeClickable(massEmailPage.email_Type);
		accessLink(massEmailPage.email_Type);
		accessLink(commonPage.common_clickable_button("New Investment Announcements"));

		
	}

	public void createTemplate() throws Exception {

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

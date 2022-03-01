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

	String columnOne = "Column 1";
	String columnTwo = "Column 2";
	String columnThree = "Column 3";
	String columnFour = "Column 4";

	/**
	 * @param sending_url Verifying login URl and clicking on Buy Button
	 * @throws Exception
	 */
	public void createTemplate(String massEmailUrl) throws Exception {

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

		focusStop(2000);
		// click on drop-down and select value
		waitForElementToBeClickable(massEmailPage.recipients_dropDown);
		focusStop(2000);
		waitFindEnterTextAsList(massEmailPage.recipients_dropDown, "All");
		focusStop(2000);
		accessLink(massEmailPage.recipients_value);

		focusStop(4000);

		// select email type
		actionsMouseClick(massEmailPage.email_Type);
		accessLink(commonPage.common_clickable_button("Company Newsletter / Updates"));
		
		// Email Subject
		javaScriptScrollUsingBy(commonPage.common_send_text("subject"));
		waitFindEnterText(commonPage.common_send_text("subject"), TestData.EMAIL_SUBJECT);

		// enter name
		waitFindEnterTextAsList(commonPage.common_send_text("name"), TestData.MASS_EMAIL_NAME);

		// enter email id
		waitFindEnterTextAsList(commonPage.common_send_text("replyTo"), TestData.EMAIL_ID_ADD_LEADS);
		

	}

	public void selectColumn() throws Exception {

		// wait to load page
		waitForPageLoad();

		// i frame
		moveInSideToFrameWithTitle(massEmailPage.frame);

		// clicking and select fourth column
		javaScriptClickUsingBy(massEmailPage.column_dropType);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_Column_Four);
		focusStop(500);

		columnProperty(columnOne);
		columnProperty(columnTwo);
		columnProperty(columnThree);
		columnProperty(columnFour);

		focusStop(1000);
		
		// moving out from frame
		moveOutSideFromFrame();

	}
	
	public void scheduleToSendAndVerify() throws Exception {
		
		// schedule to send
		accessLink(commonPage.common_button("Schedule To Send"));
		// verify
		waitUntilLoadingPage("Proceed", commonPage.common_clickable_button("Proceed"));
		//proceed
		accessLink(commonPage.common_button("Proceed"));
		//proceed
		accessLink(massEmailPage.select_time);
		waitUntilLoadingPage("PM", commonPage.common_clickable_button("PM"));
		accessLink(commonPage.common_clickable_button("PM"));
		accessLink(commonPage.common_clickable_button("OK"));
		// schedule email
		accessLink(commonPage.common_button("Schedule Email"));
		// click on OK
		accessLink(commonPage.common_button("OK"));
		// click on Manage Email
		accessLink(commonPage.common_clickable_button("Manage Emails"));
		waitUntilLoadingPage("Scheduled", commonPage.common_clickable_button("Scheduled"));
		assertString(textFromApplication(massEmailPage.schedule_Time("Scheduled")), TestData.SCHEDULED_TIME);
		
	}
	
	
	public void columnProperty(String column) throws Exception {

		focusStop(2000);
		accessLink(commonPage.common_clickable_button(column));

		javaScriptClickUsingBy(massEmailPage.columnProperty_backgroundColor(column));
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_redColor);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnProperty_backgroundColor(column));
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnProperty_Padding_moreOption(column));
		focusStop(500);
		waitFindEnterTextAsList(massEmailPage.columnProperty_padding_topIncrease, "18");
		focusStop(500);
		waitFindSelect(massEmailPage.columnProperty_allSides, "Dotted");
		focusStop(500);
		waitFindEnterTextAsList(massEmailPage.columnProperty_allSidesInput, "10");
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnProperty_borderColor(column));
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_blackColor);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnProperty_borderColor(column));
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnOne_rowProperty_backgroundColor(column));
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_grayColor);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.columnOne_rowProperty_backgroundColor(column));
		waitFindEnterTextAsList(massEmailPage.columnOne_paddingAllSides(column), "15");

	}

}

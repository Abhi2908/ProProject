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
	public void createTemplate(String massEmailUrl, String sendEmail) throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Email
		waitForElementToBeClickable(commonPage.common_clickable_button("Email"));
		accessLink(commonPage.common_clickable_button("Email"));

		// clicking on Email button
		waitUntilLoadingPage("Send Email", commonPage.common_clickable_button("Send Email"));
		accessLink(commonPage.common_clickable_button(sendEmail));

		// verifying the Email page URL
		verifyingLoadApplicationPageUrl(massEmailUrl);

		focusStop(2000);

		// click on drop-down and select value
		waitForElementToBeClickable(massEmailPage.recipients_dropDown);

		focusStop(5000);
		actionsMouseClickAndHold(massEmailPage.recipients_dropDown);
		clickOnScreenThroughRobot();

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

	public void createEmailTemplate(String massEmailUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Email
		waitForElementToBeClickable(commonPage.common_clickable_button("Email"));
		accessLink(commonPage.common_clickable_button("Email"));

		// clicking on Email button
		waitUntilLoadingPage("Email Templates", commonPage.common_clickable_button("Email Templates"));
		accessLink(commonPage.common_clickable_button("Email Templates"));

		// wait for create templates
		waitUntilLoadingPage("SAVED TEMPLATES", commonPage.common_clickable_button("Saved Templates"));
		accessLink(commonPage.common_button("Create Template"));

		// verifying the Email page URL
		verifyingLoadApplicationPageUrl(massEmailUrl);

		// clicking on Email button
		waitUntilLoadingPage("Create New Template", commonPage.common_clickable_button("Create New Template"));
		accessLink(commonPage.common_clickable_button("Create New Template"));

		// wait for Create New Email Template
		waitUntilLoadingPage("Create New Email Template",
				commonPage.common_clickable_button("Create New Email Template"));
		waitFindEnterTextAsList(commonPage.common_send_text("templateName"), TestData.MASS_EMAIL_TEMPLATE);
		waitFindEnterTextAsList(commonPage.common_send_text("description"), TestData.MASS_EMAIL_DESCRIPTION);

		// click on Next button
		accessLink(commonPage.common_button("Next"));

		focusStop(2000);

	}

	public void sendEmailFromTemplate() throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Email
		waitForElementToBeClickable(commonPage.common_clickable_button("Send Email"));
		accessLink(commonPage.common_clickable_button("Send Email"));

		// clicking on Email button
		waitUntilLoadingPage("Send Email From Template",
				commonPage.common_clickable_button("Send Email From Template"));
		accessLink(commonPage.common_clickable_button("Send Email From Template"));

		focusStop(2000);
		// clicking on Email button
		accessLink(commonPage.common_clickable_button("Select from Saved Templates"));

		focusStop(2000);

		// click on Next button
		accessLink(massEmailPage.create_Template(TestData.MASS_EMAIL_TEMPLATE, "Use this Template"));

		focusStop(2000);
		// click on drop-down and select value
		waitForElementToBeClickable(massEmailPage.recipients_dropDown);

		focusStop(10000);
		actionsMouseClickAndHold(massEmailPage.recipients_dropDown);
		clickOnScreenThroughRobot();

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

		// save and close
		accessLink(commonPage.common_button("Send Now"));

		// verify
		waitUntilLoadingPage("Proceed", commonPage.common_clickable_button("Proceed"));
		// proceed
		focusStop(2000);
		accessLink(commonPage.common_button("Proceed"));

		focusStop(2000);
		accessLink(commonPage.common_button("OK"));

		// click on Manage Email
		accessLink(commonPage.common_clickable_button("Manage Emails"));
		// waitUntilLoadingPage("Scheduled",
		// commonPage.common_clickable_button("Scheduled"));
		// assertString(textFromApplication(massEmailPage.schedule_Time("Pending")),
		// TestData.STATUS_PENDING);

	}

	public void selectFromSavedTemplate() throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Email
		waitForElementToBeClickable(commonPage.common_clickable_button("Email"));
		accessLink(commonPage.common_clickable_button("Email"));

		// clicking on Email button
		waitUntilLoadingPage("Email Templates", commonPage.common_clickable_button("Email Templates"));
		accessLink(commonPage.common_clickable_button("Email Templates"));

		// wait for create templates
		waitUntilLoadingPage("SAVED TEMPLATES", commonPage.common_clickable_button("Saved Templates"));
		accessLink(commonPage.common_button("Create Template"));

		// clicking on Email button
		waitUntilLoadingPage("Select from Saved Templates",
				commonPage.common_clickable_button("Select from Saved Templates"));
		accessLink(commonPage.common_clickable_button("Select from Saved Templates"));

		focusStop(2000);

		// click on Next button
		accessLink(massEmailPage.create_Template(TestData.MASS_EMAIL_TEMPLATE, "Use this Template"));

		// save and close
		accessLink(commonPage.common_button("Save & Close"));

		// wait for Create New Email Template
		waitUntilLoadingPage("Create New Template", commonPage.common_clickable_button("Create New Template"));
		waitFindEnterTextAsList(commonPage.common_send_text("templateName"), TestData.NEW_MASS_EMAIL_TEMPLATE);
		waitFindEnterTextAsList(commonPage.common_send_text("description"), TestData.NEW_MASS_EMAIL_DESCRIPTION);

		// click on Next button
		accessLink(commonPage.common_button("Submit"));

		// verify
		waitUntilLoadingPage("Email Template Added Successfully",
				commonPage.common_clickable_button("Email Template Added Successfully"));
		accessLink(commonPage.common_button("OK"));
		// click on Asset created template
		focusStop(5000);
		waitUntilLoadingPage("AUTOMATION NEW EMAIL TEMPLATE",
				massEmailPage.create_Template("Saved Templates", TestData.NEW_MASS_EMAIL_TEMPLATE));
		assertString(
				textFromApplication(massEmailPage.create_Template("Saved Templates", TestData.NEW_MASS_EMAIL_TEMPLATE)),
				"AUTOMATION NEW EMAIL TEMPLATE");

	}

	public void deleteTemplate(String selectTemplate) throws Exception {

		// Delete template
		accessLink(massEmailPage.create_Template(selectTemplate, "Delete Template"));
		waitUntilLoadingPage("Are you sure you want to delete ?",
				commonPage.common_clickable_button("Are you sure you want to delete ?"));
		// accessLink(massEmailPage.create_Template(selectTemplate, "Delete Template"));
		accessLink(commonPage.common_button("Yes"));

	}

	public void editTemplate(String editTemplate) throws Exception {

		// Edit template
		accessLink(massEmailPage.create_Template(editTemplate, "Edit this Template"));

		selectLastTwoColumn();

		// save and close
		accessLink(commonPage.common_button("Save & Close"));
		waitUntilLoadingPage("Email Template Saved Successfully",
				commonPage.common_clickable_button("Email Template Saved Successfully"));
		accessLink(commonPage.common_button("OK"));

	}

	public void saveTemplateAndVerify() throws Exception {

		// save and close
		accessLink(commonPage.common_button("Save & Close"));
		// verify
		waitUntilLoadingPage("Email Template Added Successfully",
				commonPage.common_clickable_button("Email Template Added Successfully"));
		focusStop(2000);
		accessLink(commonPage.common_button("OK"));
		// click on Asset created template
		focusStop(5000);
		waitUntilLoadingPage("AUTOMATION MASS EMAIL TEMPLATE",
				massEmailPage.create_Template("Saved Templates", TestData.MASS_EMAIL_TEMPLATE));
		assertString(
				textFromApplication(massEmailPage.create_Template("Saved Templates", TestData.MASS_EMAIL_TEMPLATE)),
				"AUTOMATION MASS EMAIL TEMPLATE");

	}

	public void selectFirstTwoColumn() throws Exception {

		// wait to load page
		waitForPageLoad();

		// iFrame
		moveInSideToFrameWithTitle(massEmailPage.frame);

		// clicking and select fourth column
		javaScriptClickUsingBy(massEmailPage.column_dropType);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_Column_Four);
		focusStop(500);

		columnProperty(columnOne);
		columnProperty(columnTwo);

		focusStop(1000);

		// moving out from frame
		moveOutSideFromFrame();

	}

	public void selectLastTwoColumn() throws Exception {

		// wait to load page
		waitForPageLoad();

		// i frame
		moveInSideToFrameWithTitle(massEmailPage.frame);

		// clicking and select fourth column
		javaScriptClickUsingBy(massEmailPage.column_dropType);
		focusStop(500);
		javaScriptClickUsingBy(massEmailPage.select_Column_Four);
		focusStop(500);

		columnProperty(columnThree);
		columnProperty(columnFour);

		focusStop(1000);

		// moving out from frame
		moveOutSideFromFrame();

	}

	public void selectAllColumn() throws Exception {

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
		// proceed
		accessLink(commonPage.common_button("Proceed"));
		// proceed
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

	public void draftToSendAndVerify() throws Exception {

		// schedule to send
		accessLink(commonPage.common_button("Save as Draft"));
		// verify
		waitUntilLoadingPage("Proceed", commonPage.common_clickable_button("Proceed"));
		// proceed
		accessLink(commonPage.common_button("Proceed"));
		focusStop(2000);
		// click on OK
		accessLink(commonPage.common_button("OK"));
		// click on Manage Email and Drafts
		accessLink(commonPage.common_clickable_button("Manage Emails"));
		accessLink(commonPage.common_clickable_button("Drafts"));

		waitUntilLoadingPage("Subject", commonPage.common_clickable_button("Subject"));
		assertString(textFromApplication(commonPage.common_clickable_button("Test Automation Lead Subject")),
				TestData.EMAIL_SUBJECT);
		// send email
		scrollPageUpUsingActions(commonPage.common_clickable_button("Test Automation Lead Subject"));
		accessLink(massEmailPage.send_Email);
		focusStop(2000);
		// click on OK
		accessLink(commonPage.common_button("OK"));

	}

	public void sendEmailAndVerify() throws Exception {

		// schedule to send
		accessLink(commonPage.common_button("Send Now"));
		// verify
		waitUntilLoadingPage("Proceed", commonPage.common_button("Proceed"));
		// proceed and ok
		accessLink(commonPage.common_button("Proceed"));
		focusStop(2000);
		accessLink(commonPage.common_button("OK"));
		// click on Manage Email
		accessLink(commonPage.common_clickable_button("Manage Emails"));
//		waitUntilLoadingPage("Sending", commonPage.common_clickable_button("Sending"));
//		assertString(textFromApplication(massEmailPage.schedule_Time("Sending")), TestData.STATUS_PENDING);

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
		focusStop(1000);
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

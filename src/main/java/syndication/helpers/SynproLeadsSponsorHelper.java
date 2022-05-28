package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.pages.SynproLeadsSponsorPage;
import syndication.pages.SynproRegistrationPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproLeadsSponsorHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproLeadsSponsorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproRegistrationPage registrationPage = new SynproRegistrationPage();
	SynproLeadsSponsorPage leadsPage = new SynproLeadsSponsorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();

	/**
	 * @param leads page
	 * @throws Exception
	 */
	public void verifyLeadsPage(String leadsUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on leads
		waitForElementToBeClickable(commonPage.common_clickable_button("Leads"));
		accessLink(commonPage.common_clickable_button("Leads"));

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(leadsUrl);

	}

	public void addLeads(String yopMail, String leadPage) throws Exception {

		// wait to load page
		waitForPageLoad();

		// Get Yop mail
		getAnotherWindow(yopMail);

		// send email value
		waitFindEnterTextAsList(commonPage.common_send_text("login"), TestData.EMAIL_ID_ADD_LEADS);

		// click on arrow
		waitForElementToBeClickable(leadsPage.create_arrow_login);
		accessLink(leadsPage.create_arrow_login);

		// Navigate back
		getAnotherWindow(leadPage);

		// wait until loading page
		waitUntilLoadingPage("Add Leads", commonPage.common_clickable_button("Add Leads"));

		// Verifying click on add leads
		waitForElementToBeClickable(commonPage.common_clickable_button("Add Leads"));
		accessLink(commonPage.common_clickable_button("Add Leads"));

		// wait until loading page
		waitUntilLoadingPage("Invite Lead", commonPage.common_clickable_button("Invite Lead"));

		// Enter values in text fields
		waitFindEnterTextAsList(commonPage.common_send_text("firstName"), TestData.FIRSTNAME_ADD_LEADS);
		waitFindEnterTextAsList(commonPage.common_send_text("lastName"), TestData.LASTNAME_ADD_LEADS);
		waitFindEnterTextAsList(commonPage.common_send_text("nickName"), TestData.NICKNAME_ADD_LEADS);

		// Click and select value from residency drop-down
		waitForElementToBeClickable(registrationPage.residency);
		actionsMouseDoubleClick(registrationPage.residency);
		accessLink(leadsPage.select_residency_value);

		// Enter values in email and phone
		waitFindEnterTextAsList(commonPage.common_send_text("email"), TestData.EMAIL_ID_ADD_LEADS);
		waitFindEnterText(registrationPage.phone, TestData.PHONE_NUMBER);

		// Click and select from i am looking to invest
		moveToWebElementAndClick(registrationPage.i_am_looking_to_invest);
		accessLink(commonPage.select_from_dataValue("$10,000_$50,000"));

		// Enter values in hear about us
		waitFindEnterText(commonPage.common_send_text("hearAboutUs"), TestData.HEAR_ABOUT_US);

		// Click and select value from Are you an accredited investor ?
		moveToWebElementAndClick(registrationPage.are_you_an_accredited_investor);
		accessLink(commonPage.select_from_dataValue("YES"));

		// Verifying click on add leads
		waitForElementToBeClickable(commonPage.common_clickable_button("Add Leads"));
		accessLink(commonPage.click_popUp("Invite Lead"));

		if (checkElementPresence(commonPage.common_clickable_button("User with this email already exists")) == true) {
			// Verifying click on close
			waitForElementToBeClickable(commonPage.common_clickable_button("Cancel"));
			accessLink(commonPage.common_clickable_button("Cancel"));

		} else {
			// Verifying click on close
			waitForElementToBeClickable(commonPage.common_clickable_button("Close"));
			accessLink(commonPage.common_clickable_button("Close"));
		}
	}
	
	public void verifyInvitesOnEmail(String yopMail, String leadPage) throws Exception {

		// Get Yop mail
		getAnotherWindow(yopMail);

		// send email value
		waitFindEnterTextAsList(commonPage.common_send_text("login"), TestData.EMAIL_ID_ADD_LEADS);

		// click on arrow
		waitForElementToBeClickable(leadsPage.create_arrow_login);
		accessLink(leadsPage.create_arrow_login);

		iframeToBeAvailableAndSwitchToIt(leadsPage.iframe_yopInvitationMail);

		// assert
		assertString(textFromApplication(commonPage.common_clickable_button(TestData.EMAIL_INVITATION_ADD_LEADS)),
				TestData.EMAIL_INVITATION_ADD_LEADS);

		// outside the frame
		moveOutSideFromFrame();
		iframeToBeAvailableAndSwitchToIt(leadsPage.iframe_yopInvitationInbox);

		// click on checkBox
		waitForElementToBeClickable(leadsPage.click_checkBox_yopMail);
		accessLink(leadsPage.click_checkBox_yopMail);

		// outside the frame
		moveOutSideFromFrame();

		// click on delete
		waitForElementToBeClickable(leadsPage.delete_yopMail);
		accessLink(leadsPage.delete_yopMail);

		// Navigate back
		getAnotherWindow(leadPage);

		// wait until loading page
		waitUntilLoadingPage("Resend Invites", commonPage.common_clickable_button("Resend Invites"));

	}

	public void searchLeadAndVerify() throws Exception {

		// wait to load page
		waitForPageLoad();

		// Enter values in search and verify
		waitFindEnterTextAsList(leadsPage.search_addLeadPage,
				TestData.FIRSTNAME_ADD_LEADS + " " + TestData.LASTNAME_ADD_LEADS);

		// Assert all values
		assertString(
				textFromApplication(commonPage.assert_responsiveTableValues(
						TestData.FIRSTNAME_ADD_LEADS + " " + TestData.LASTNAME_ADD_LEADS)),
				TestData.FIRSTNAME_ADD_LEADS + " " + TestData.LASTNAME_ADD_LEADS);
		assertString(textFromApplication(commonPage.assert_responsiveTableValues(TestData.EMAIL_ID_ADD_LEADS)),
				TestData.EMAIL_ID_ADD_LEADS);
		assertString(textFromApplication(commonPage.assert_responsiveTableValues(TestData.RESIDENCY)),
				TestData.RESIDENCY);
		
		//click on created lead
		accessLink(commonPage.common_span(TestData.FIRSTNAME_ADD_LEADS));
		
		waitUntilLoadingPage("Archive", commonPage.common_clickable_button("Archive"));
		
		// click on reservation
		waitForElementToBeClickable(commonPage.common_button("Reservation"));
		accessLink(commonPage.common_button("Reservation"));
		
		// Add reservation
		waitForElementToBeClickable(commonPage.common_button("Add Reservation"));
		moveToWebElementAndClick(commonPage.common_button("Add Reservation"));
		
		// Amount
		focusStop(3000);
		waitFindEnterText(commonPage.common_send_text("investedAmount"), TestData.OFFERING_MIN_INVESTMENT);
		
		//profile
		moveToWebElementAndClick(leadsPage.profile);
		moveToWebElementAndClick(leadsPage.profile_synPro);
		
		// confidence
		moveToWebElementAndClick(leadsPage.confidenceLevel);
		moveToWebElementAndClick(leadsPage.veryLikely);
		
		// reservation
		moveToWebElementAndClick(leadsPage.select_reservation);
		moveToWebElementAndClick(leadsPage.seedIntoApart);
		
		// save
		waitForElementToBeClickable(commonPage.common_button("Save"));
		moveToWebElementAndClick(commonPage.common_button("Save"));
		
		focusStop(10000);
		
		// click on eye for Archive
		waitForElementToBeClickable(leadsPage.eyeArchive);
		accessLink(leadsPage.eyeArchive);
		
		focusStop(2000);
		
		// click on eye for Archive
		waitForElementToBeClickable(commonPage.common_clickable_button("Archive"));
		accessLink(commonPage.common_clickable_button("Archive"));
		
		// click on yes
		waitForElementToBeClickable(commonPage.common_clickable_button("Yes"));
		accessLink(commonPage.common_clickable_button("Yes"));
		
		// click on Investment
		waitForElementToBeClickable(commonPage.common_button("Investments"));
		accessLink(commonPage.common_button("Investments"));
				
		// Add investment
		waitForElementToBeClickable(commonPage.common_button("Add Investment"));
		moveToWebElementAndClick(commonPage.common_button("Add Investment"));
		
		//offering
		focusStop(2000);
		waitForElementToBeClickable(leadsPage.offering);
		moveToWebElementAndClick(leadsPage.offering);
		focusStop(2000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Automation Offering"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Automation Offering"));
				
		// profile
		focusStop(2000);
		waitForElementToBeClickable(leadsPage.select_profile);
		moveToWebElementAndClick(leadsPage.select_profile);
		focusStop(2000);
		waitForElementToBeClickable(commonPage.common_clickable_button(TestData.FIRSTNAME_ADD_LEADS));
		moveToWebElementAndClick(commonPage.common_clickable_button(TestData.FIRSTNAME_ADD_LEADS));
				
		// status
		focusStop(2000);
		waitForElementToBeClickable(leadsPage.status);
		moveToWebElementAndClick(leadsPage.status);
		focusStop(2000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Approved"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Approved"));
		
		// click on yes
		waitForElementToBeClickable(commonPage.common_clickable_button("Save"));
		accessLink(commonPage.common_clickable_button("Save"));
		
		// click on edit profile
		waitForElementToBeClickable(commonPage.common_button("Edit Profile"));
		accessLink(commonPage.common_button("Edit Profile"));
				
		// update profile
		waitForElementToBeClickable(commonPage.common_button("Update Profile"));
		moveToWebElementAndClick(commonPage.common_button("Update Profile"));
		

	}

	public void resendInvites() throws Exception {

		// wait to load page
		waitForPageLoad();

		// Verifying click on Re-send Invites
		waitForElementToBeClickable(commonPage.common_clickable_button("Resend Invites"));
		accessLink(commonPage.common_clickable_button("Resend Invites"));

		// Verifying click on yes and ok
		waitForElementToBeClickable(commonPage.popUp_Button(TestData.POPUP_RESEND_MESSAGE, "Yes"));
		accessLink(commonPage.popUp_Button(TestData.POPUP_RESEND_MESSAGE, "Yes"));

		waitForElementToBeClickable(commonPage.popUp_Button("", "OK"));
		accessLink(commonPage.popUp_Button("", "OK"));

	}

	public void verifyLeadTitles() throws Exception {

		// wait to load page
		waitForPageLoad();

		// Verifying click on investment capacity drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Investment Capacity: "));
		accessLink(commonPage.common_clickable_button("Investment Capacity: "));
		accessLink(commonPage.popUp_Button("Investment Capacity: ", TestData.INVESTMENT_CAPACITY));

		// Verifying click on residency drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Residency:"));
		accessLink(commonPage.common_clickable_button("Residency:"));
		accessLink(commonPage.popUp_Button("Residency:", "California"));

		// Verifying click on self accreditation capacity drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Self Acc:"));
		accessLink(commonPage.common_clickable_button("Self Acc:"));
		accessLink(commonPage.popUp_Button("Self Acc:", "Yes"));

		// Verifying click on registration type capacity drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Reg Type:"));
		accessLink(commonPage.common_clickable_button("Reg Type:"));
		accessLink(commonPage.popUp_Button("Reg Type:", "Invited"));

		// Verifying click on verified capacity drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Verified:"));
		accessLink(commonPage.common_clickable_button("Verified:"));
		accessLink(commonPage.popUp_Button("Verified:", "No"));

		// Assert all values
		assertString(
				textFromApplication(commonPage.assert_responsiveTableValues(
						TestData.FIRSTNAME_ADD_LEADS + " " + TestData.LASTNAME_ADD_LEADS)),
				TestData.FIRSTNAME_ADD_LEADS + " " + TestData.LASTNAME_ADD_LEADS);
		assertString(textFromApplication(commonPage.assert_responsiveTableValues(TestData.EMAIL_ID_ADD_LEADS)),
				TestData.EMAIL_ID_ADD_LEADS);
		assertString(textFromApplication(commonPage.assert_responsiveTableValues(TestData.RESIDENCY)),
				TestData.RESIDENCY);

		// click on leads
		accessLink(commonPage.common_clickable_button("Leads"));

		verifyDeleteAddTagsAndSendEmail();

		// Verifying click on verified capacity drop-down
		waitForElementToBeClickable(commonPage.common_clickable_button("Reset All"));
		accessLink(commonPage.common_clickable_button("Reset All"));

	}

	public void verifyDeleteAddTagsAndSendEmail() throws Exception {

		// wait to load page
		waitForPageLoad();

		// click on check box
		waitForElementToBeClickable(leadsPage.checkBox_addLeadPage);
		accessLink(leadsPage.checkBox_addLeadPage);

		// add tags
		waitUntilLoadingPage("Add Tag", commonPage.common_clickable_button("Add Tag"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Add Tag"));
		accessLink(commonPage.common_clickable_button("Add Tag"));

		// wait until pop up visible
		waitUntilLoadingPage("Create a new tag or select an existing tag",
				commonPage.common_clickable_button("Create a new tag or select an existing tag"));
		waitFindEnterTextAsList(leadsPage.create_tagField, TestData.CREATE_TAG);

		// click on created tag
		waitForElementToBeClickable(leadsPage.click_Create_tagField);
		accessLink(leadsPage.click_Create_tagField);

		// click on save pop up
		waitForElementToBeClickable(commonPage.popUp_Button("", "Save"));
		accessLink(commonPage.popUp_Button("", "Save"));

		// wait and verify email
		waitUntilLoadingPage(TestData.EMAIL_ID_ADD_LEADS,
				commonPage.common_clickable_button(TestData.EMAIL_ID_ADD_LEADS));

		// Assert added tag
		assertString(textFromApplication(commonPage.popUp_Button(TestData.EMAIL_ID_ADD_LEADS, TestData.CREATE_TAG)),
				TestData.CREATE_TAG);

		// click on tag and delete
		waitForElementToBeClickable(commonPage.popUp_Button(TestData.EMAIL_ID_ADD_LEADS, TestData.CREATE_TAG));
		accessLink(commonPage.popUp_Button(TestData.EMAIL_ID_ADD_LEADS, TestData.CREATE_TAG));

		// wait until pop up visible
		waitForElementToBeClickable(commonPage.common_button("Delete"));
		accessLink(commonPage.common_button("Delete"));

		// Delete Group
		waitForElementToBeClickable(commonPage.popUp_Button(TestData.DELETE_CREATE_TAG, "Yes"));
		accessLink(commonPage.popUp_Button(TestData.DELETE_CREATE_TAG, "Yes"));

		// send email
		waitUntilLoadingPage("Send Email", commonPage.common_clickable_button("Send Email"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Send Email"));
		accessLink(commonPage.common_clickable_button("Send Email"));

		// wait until email page visible
		waitUntilLoadingPage("Subject", commonPage.common_clickable_button("Subject"));

		// Email Subject
		waitFindEnterText(commonPage.common_send_text("subject"), TestData.EMAIL_SUBJECT);
		waitFindEnterTextAsList(commonPage.common_send_text("replyTo"), TestData.EMAIL_ID_ADD_LEADS);

		// click on enter type
		moveToWebElementAndClick(leadsPage.select_emailType);

		// select type new investment announcement
		waitForElementToBeClickable(commonPage.common_clickable_button("New Investment Announcements"));
		accessLink(commonPage.common_clickable_button("New Investment Announcements"));

		// Email click inside Text box
		moveToWebElementAndClick(dashboardPage.email_text);

		// click on plus icon
		waitForElementToBeClickable(dashboardPage.email_plus);
		moveToWebElementAndClick(dashboardPage.email_plus);

		// click on table
		waitForElementToBeClickable(dashboardPage.email_plus_table);
		moveToWebElementAndClick(dashboardPage.email_plus_table);

		// Send email
		waitForElementToBeClickable(commonPage.common_button("Send"));
		moveToWebElementAndClick(commonPage.common_button("Send"));

		// click on OK and confirm send
		waitForElementToBeClickable(commonPage.popUp_Button("", "OK"));
		accessLink(commonPage.popUp_Button("", "OK"));

		// click and close email
		waitForElementToBeClickable(dashboardPage.cross_tour);
		accessLink(dashboardPage.cross_tour);

		// delete User
		waitForElementToBeClickable(commonPage.common_clickable_button("Delete User"));
		accessLink(commonPage.common_clickable_button("Delete User"));

		// click on permanently delete
		waitForElementToBeClickable(commonPage.popUp_Button(TestData.PERMANENTLY_DELETE_LEAD, "Yes"));
		accessLink(commonPage.popUp_Button(TestData.PERMANENTLY_DELETE_LEAD, "Yes"));

	}

}

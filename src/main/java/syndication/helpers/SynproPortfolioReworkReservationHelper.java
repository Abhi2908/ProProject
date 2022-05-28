package syndication.helpers;

import org.apache.log4j.Logger;
import org.testng.Assert;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.pages.SynproPortfolioReworkReservationPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproPortfolioReworkReservationHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproPortfolioReworkReservationHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();
	SynproPortfolioReworkReservationPage reworkReservation = new SynproPortfolioReworkReservationPage();

	String upload_photo_verification = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "test" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "verification.png";

	String eSign_document = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "test" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "sample-three.pdf";

	public void removeOffering() throws Exception {

		// wait to load page
		waitForPageLoad();
		focusStop(5000);
		try {
			// Verifying click on Investors
			scrollPageDownUsingActions(reworkReservation.remove_Offering);
			waitForElementToBeClickable(reworkReservation.remove_Offering);
			moveToWebElementAndClick(reworkReservation.remove_Offering);

			waitUntilLoadingPage("Are you sure you want to archive this offering?",
					commonPage.common_clickable_button("Are you sure you want to archive this offering?"));
			waitForElementToBeClickable(commonPage.common_button("Yes"));
			javaScriptClickUsingBy(commonPage.common_button("Yes"));
			focusStop(5000);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void addNewOffering(String massEmailUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Portfolio
		waitForElementToBeClickable(commonPage.common_clickable_button("Portfolio"));
		accessLink(commonPage.common_clickable_button("Portfolio"));

		// clicking on Add New Offering
		waitUntilLoadingPage("Offerings", commonPage.common_clickable_button("Offerings"));
		accessLink(commonPage.common_button("Add New Offering"));

		// verifying the Portfolio page URL
		verifyingLoadApplicationPageUrl(massEmailUrl);

		// wait for Offering Type and submit form
		waitUntilLoadingPage("Offering Type", commonPage.common_clickable_button("Offering Type"));
		waitFindEnterTextAsList(commonPage.common_send_text("name"), TestData.NEW_OFFERING_NAME);
		moveToWebElementAndClick(reworkReservation.offering_type_dropdown);
		moveToWebElementAndClick(reworkReservation.select_investment_type);
		waitFindEnterTextAsList(commonPage.common_send_text("entityName"), TestData.OFFERING_ENTITY);
		moveToWebElementAndClick(reworkReservation.offering_status_dropdown);
		moveToWebElementAndClick(reworkReservation.select_accepting_reservation);
		waitFindEnterTextAsList(commonPage.common_send_text("totalAmount"), TestData.OFFERING_SIZE);
		waitFindEnterTextAsList(commonPage.common_send_text("minimumInvestment"), TestData.OFFERING_MIN_INVESTMENT);
		waitFindEnterTextAsList(reworkReservation.offering_visibility_dropdown, TestData.VISIBILITY_ALL_USERS);
		focusStop(2000);
		clickOnScreenThroughRobot();

		// click on Next
		accessLink(reworkReservation.form_next_button);

		focusStop(15000);

//		waitUntilLoadingPage("Prorated Pricing", commonPage.common_clickable_button("Prorated Pricing"));
//		waitForElementToBeClickable(commonPage.common_button("Pay now"));
//		javaScriptClickUsingBy(commonPage.common_button("Pay now"));
//
//		focusStop(15000);
//		waitUntilLoadingPage("Success", commonPage.common_clickable_button("Success"));
//		waitForElementToBeClickable(commonPage.common_button("Okay"));
//		javaScriptClickUsingBy(commonPage.common_button("Okay"));

	}

	public void offeringDetailForm() throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// waiting for Offering Details
		waitUntilLoadingPage("Offering Details", commonPage.common_clickable_button("Offering Details"));

		// submit Gallery
		focusStop(5000);
		waitUntilLoadingPage("Gallery", commonPage.common_clickable_button("Gallery"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Gallery"));
		waitUntilLoadingPage("Upload", commonPage.common_button("Upload"));
		javaScriptClickUsingBy(commonPage.common_button("Upload"));
		// upload photo
		waitUntilLoadingPage("Upload Images", commonPage.common_clickable_button("Upload Images"));
		waitFindUploadPhotoWithoutClick(reworkReservation.gallery_image, upload_photo_verification);
		javaScriptClickUsingBy(commonPage.common_button("Save and Upload"));
		// save order
		javaScriptClickUsingBy(commonPage.common_button("Save Order"));
		// close gallery
		javaScriptClickUsingBy(commonPage.common_clickable_button("Gallery"));
		focusStop(3000);

		// Submit Summary
		javaScriptClickUsingBy(commonPage.common_clickable_button("Summary"));
		focusStop(6000);
		// waitForPresenceOfElement(reworkReservation.textEditor);
		// Email click inside Text box
		javaScriptTextEditor(reworkReservation.textEditor);
		// update profile
		Thread.sleep(2000);
		waitForElementToBeClickable(reworkReservation.gallery_saveButton);
		javaScriptClickUsingBy(reworkReservation.gallery_saveButton);
		// close summary
		javaScriptClickUsingBy(commonPage.common_clickable_button("Summary"));
		focusStop(3000);

		// Submit Documents
		javaScriptClickUsingBy(commonPage.common_clickable_button("Documents"));
		// upload doc
		javaScriptClickUsingBy(reworkReservation.document_uploadButton);
		waitUntilLoadingPage("Upload Documents", commonPage.common_clickable_button("Upload Documents"));
		// welcome doc
		waitFindUploadPhotoWithoutClick(reworkReservation.welcome_document, upload_photo_verification);
		waitFindUploadPhotoWithoutClick(reworkReservation.upload_document, upload_photo_verification);
		// save and upload
		javaScriptClickUsingBy(commonPage.common_button("Save and Upload"));
		focusStop(3000);
		// click public toggle
		if (checkElementPresence(reworkReservation.toggle_public) == true) {
			javaScriptClickUsingBy(reworkReservation.toggle_public);
		}
		waitUntilLoadingPage("Make Documents As Public",
				commonPage.common_clickable_button("Make Documents As Public"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Okay"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Documents"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Documents"));
		focusStop(3000);

		// Set Location Map
		javaScriptClickUsingBy(commonPage.common_clickable_button("Location Map"));
		waitUntilLoadingPage("Enter Location", commonPage.common_clickable_button("Enter Location"));
		waitFindEnterTextAsList(commonPage.common_send_text("address"), TestData.LOCATION_MAP);
		javaScriptClickUsingBy(reworkReservation.select_location);
		waitForElementToBeClickable(commonPage.common_button("Save Location"));
		javaScriptClickUsingBy(commonPage.common_button("Save Location"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Location Map"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Location Map"));
		focusStop(3000);

		// Set Key Highlights
		javaScriptClickUsingBy(commonPage.common_clickable_button("Key Highlights"));
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[0].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[1].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[2].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[3].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[4].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[5].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[6].value"), TestData.KEY_HIGHLIGHT_VALUE);
		waitFindEnterTextAsList(commonPage.common_send_text("primaryKeys[7].value"), TestData.KEY_HIGHLIGHT_VALUE);
		javaScriptClickUsingBy(reworkReservation.keyHighlight_Save);
		javaScriptClickUsingBy(commonPage.common_clickable_button("Key Highlights"));

		// Set funding Instructions
		focusStop(3000);
		javaScriptClickUsingBy(commonPage.common_clickable_button("Funding Instructions"));
		waitForElementToBeClickable(reworkReservation.select_wireTransfer);
		javaScriptClickUsingBy(reworkReservation.select_wireTransfer);

		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.receivingBank"),
				TestData.RECEIVING_BANK);
		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.bankAddress"), TestData.BANK_ADDRESS);
		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.federalReserve"),
				TestData.ROUTING_NUMBER);
		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.accountNumber"),
				TestData.ACCOUNT_NUMBER);

		waitForElementToBeClickable(reworkReservation.select_Savings);
		javaScriptClickUsingBy(reworkReservation.select_Savings);

		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.beneficiaryAccountName"),
				TestData.BENEFICIARY_ACCOUNT_NAME);
		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.beneficiaryAddress"),
				TestData.BENEFICIARY_ADDRESS);
		waitFindEnterTextAsList(commonPage.common_send_text("payment.wireTransfer.reference"), TestData.REFERENCE);

		javaScriptClickUsingBy(reworkReservation.click_on_fundingInstruction_Save);
		focusStop(3000);
		javaScriptClickUsingBy(commonPage.common_clickable_button("Funding Instructions"));

	}

	public void eSignTemplateForm() throws Exception {

		// wait to load page
		waitForPageLoad();

		waitForElementToBeClickable(commonPage.common_clickable_button("eSign Templates"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("eSign Templates"));
		waitForElementToBeClickable(commonPage.common_clickable_button("eSign Tutorial"));
		waitUntilLoadingPage("eSign Tutorial", commonPage.common_clickable_button("eSign Tutorial"));

		// upload Document
		javaScriptClickUsingBy(commonPage.common_button("Upload Document"));
		waitFindUploadPhotoWithoutClick(reworkReservation.eSign_document, eSign_document);

		// select profile
		focusStop(2000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Select Profile"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Select Profile"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Select All"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Select All"));

		// sponsor signing order
		focusStop(2000);
		moveToWebElementAndClick(reworkReservation.sponsor_signing_order);
		javaScriptClickUsingBy(commonPage.common_clickable_button("Sponsor will eSign after the investor(s)"));

		// Number of investors signing
		focusStop(2000);
		moveToWebElementAndClick(reworkReservation.number_of_investor_sign);
		javaScriptClickUsingBy(reworkReservation.number_of_investor_one);

		// save and upload
		javaScriptClickUsingBy(commonPage.common_button("Save and Upload"));

		// move inside frame
		focusStop(10000);
		moveInSideToFrame("x-hellosign-embedded");
		focusStop(5000);
		moveInSideToFrameWithTitle(reworkReservation.eSign_frame);

		// wait for Create Your Template
		waitUntilLoadingPage("Create Your Template", commonPage.common_clickable_button("Create Your Template"));
		moveToWebElementAndClick(reworkReservation.gotIt);

		// drag and drop investor sign column
		focusStop(5000);
		dragAndDrop(reworkReservation.drag_Investor_sign, reworkReservation.drop_Investor_sign, 300);
		focusStop(3000);
		waitForElementToBeClickable(reworkReservation.drop_Investor_sign);
		moveToWebElementAndClick(reworkReservation.drop_Investor_sign);

		// select drop down for signer
		focusStop(3000);
		moveToWebElementAndClick(reworkReservation.dropDown_signer);
		moveToWebElementAndClick(reworkReservation.dropDown_select_sponsor);

		// drag and drop investor sign column
		focusStop(5000);
		dragAndDrop(reworkReservation.drag_Investor_sign, reworkReservation.drop_Investor_sign, 200);
		focusStop(3000);
		waitForElementToBeClickable(reworkReservation.drop_Investor_sign);
		accessLink(reworkReservation.drop_Investor_sign);

		// click on continue button
		javaScriptClickUsingBy(reworkReservation.continue_button);

		moveOutSideFromFrame();
		moveOutSideFromFrame();

		// waiting for Create eSign Template
		waitUntilLoadingPage("Create eSign Template", commonPage.common_clickable_button("Create eSign Template"));
		focusStop(5000);

	}

	public void accreditationsForm() throws Exception {

		// wait to load page
		waitForPageLoad();

		waitForElementToBeClickable(commonPage.common_clickable_button("Accreditations"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Accreditations"));
		focusStop(3000);
		waitForElementToBeClickable(commonPage
				.accreditations_toggleButtons("Enable Automated Accreditation Verification via Parallel Markets."));
		javaScriptClickUsingBy(commonPage
				.accreditations_toggleButtons("Enable Automated Accreditation Verification via Parallel Markets."));
		focusStop(1000);
		waitForElementToBeClickable(commonPage
				.accreditations_toggleButtons("Restrict eSign & Funding instructions only to Accredited Investors."));
//		javaScriptClickUsingBy(commonPage
//				.accreditations_toggleButtons("Restrict eSign & Funding instructions only to Accredited Investors."));
		focusStop(1000);
		waitForElementToBeClickable(
				commonPage.accreditations_toggleButtons("Add Custom instructions for the investors."));
		javaScriptClickUsingBy(commonPage.accreditations_toggleButtons("Add Custom instructions for the investors."));

	}

	public void investFromInvestorsPageWhileLogout() throws Exception {

		// wait to load page
		waitForPageLoad();
		focusStop(5000);
		// Verifying click on Investors
		waitForElementToBeClickable(reworkReservation.logOut_eSign);
		accessLink(reworkReservation.logOut_eSign);

	}

	public void eSignCompleteAsSponsor() throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Portfolio
		waitForElementToBeClickable(commonPage.common_clickable_button("Portfolio"));
		accessLink(commonPage.common_clickable_button("Portfolio"));

		// clicking on automation offering
		waitUntilLoadingPage("Offerings", commonPage.common_clickable_button("Offerings"));
		accessLink(reworkReservation.button_automation_offering(TestData.NEW_OFFERING_NAME));

		waitUntilLoadingPage("Subscriptions", commonPage.common_clickable_button("Subscriptions"));

		// click on Subscriptions
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Subscriptions"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Subscriptions"));

		// wait for eSign and click
		focusStop(3000);
		waitForElementToBeClickable(reworkReservation.button_sign_now);
		javaScriptClickUsingBy(reworkReservation.button_sign_now);

		focusStop(10000);
		moveInSideToFrame("x-hellosign-embedded");
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_span("OK"));
		javaScriptClickUsingBy(commonPage.common_span("OK"));

		// click to sign
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Click to sign"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Click to sign"));

		// click to try it in
		focusStop(3000);
		waitForElementToBeClickable(commonPage.select_tryInIt);
		javaScriptClickUsingBy(commonPage.select_tryInIt);

		// Enter signature name
		focusStop(3000);
		waitFindEnterTextAsList(commonPage.investor_Signature, TestData.INVESTOR_SPONSOR);

		// click Insert
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_button("Insert"));
		javaScriptClickUsingBy(commonPage.common_button("Insert"));

		// click on continue
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_span("Continue"));
		moveToWebElementAndClick(commonPage.common_span("Continue"));

		// click on I agree
		focusStop(3000);
		waitForElementToBeClickable(commonPage.signature_Iagree);
		moveToWebElementAndClick(commonPage.signature_Iagree);

		moveOutSideFromFrame();

		// close pop up
		waitUntilLoadingPage("eSign completed successfully",
				commonPage.common_clickable_button("eSign completed successfully"));
		waitForElementToBeClickable(reworkReservation.button_close);
		javaScriptClickUsingBy(reworkReservation.button_close);

		String complete = textFromApplication(reworkReservation.text_completed);
		Assert.assertEquals("Completed", complete);

	}

	public void approvedInvestorStatus() throws Exception {

		// wait to load page
		waitForPageLoad();

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Portfolio
		waitForElementToBeClickable(commonPage.common_clickable_button("Portfolio"));
		accessLink(commonPage.common_clickable_button("Portfolio"));

		// clicking on automation offering
		waitUntilLoadingPage("Offerings", commonPage.common_clickable_button("Offerings"));
		accessLink(reworkReservation.button_automation_offering(TestData.NEW_OFFERING_NAME));

		waitUntilLoadingPage("Subscriptions", commonPage.common_clickable_button("Subscriptions"));

		// click on edit
		focusStop(3000);
		accessLink(reworkReservation.edit_investor_status(TestData.AUTOMATION_DEMO_RESERVATION));
		waitUntilLoadingPage("Edit Investor - Automation Demo",
				commonPage.common_clickable_button("Edit Investor - Automation Demo"));

		// wait for eSign and click
		focusStop(3000);
		waitForElementToBeClickable(reworkReservation.select_status_dropdown);
		moveToWebElementAndClick(reworkReservation.select_status_dropdown);

		// select Approved
		waitForElementToBeClickable(reworkReservation.select_approved);
		javaScriptClickUsingBy(reworkReservation.select_approved);

		// click on update
		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_button("Update"));
		moveToWebElementAndClick(commonPage.common_button("Update"));

		focusStop(3000);

		// verify Dash-board page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on Portfolio
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		accessLink(commonPage.common_clickable_button("Dashboard"));

	}

}

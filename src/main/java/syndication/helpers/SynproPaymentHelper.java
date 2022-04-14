package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproPaymentPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproPaymentHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproPaymentHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproPaymentPage paymentPage = new SynproPaymentPage();

	String upload_photo_verification = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "test" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "verification.png";

	/**
	 * @param verify payment page
	 * @throws Exception
	 */
	public void verifyPaymentPage() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		// Verifying click on leads
		waitForElementToBeClickable(commonPage.common_clickable_button("Payments"));
		accessLink(commonPage.common_clickable_button("Payments"));

	}

	/**
	 * @param Add Basic info
	 * @throws Exception
	 */
	public void addBasicInfoEntity(String sending_url) throws Exception {

		// wait and click on settings
		waitForElementToBeClickable(paymentPage.settings);
		javaScriptClickUsingBy(paymentPage.settings);

		// clicking on Add New Offering
		waitUntilLoadingPage("Payment Entities", commonPage.common_clickable_button("Payment Entities"));
		accessLink(commonPage.common_button("Add New Entity"));

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(sending_url);

		// adding Basis - info
		waitUntilLoadingPage("Add New Entity - Basic Information",
				commonPage.common_clickable_button("Add New Entity - Basic Information"));

		// Enter first and last name as Admin
		waitFindEnterTextAsList(commonPage.common_send_text("firstName"), TestData.ADMIT_FIRST_NAME);
		waitFindEnterTextAsList(commonPage.common_send_text("lastName"), TestData.ADMIT_LAST_NAME);

		// Enter automation value
		waitFindEnterTextAsList(paymentPage.select_automationOffeting, TestData.NEW_OFFERING_NAME);
		focusStop(2000);
		clickOnScreenThroughRobot();

		// Entity name
		waitFindEnterTextAsList(commonPage.common_send_text("businessName"), TestData.ENTITY_NAME);
		// select and enter entity type
		moveToWebElementAndClick(paymentPage.select_entityType);
		javaScriptClickUsingBy(paymentPage.entityType_LLC);

		// select Business Classification
		moveToWebElementAndClick(paymentPage.select_businessClassification);
		javaScriptClickUsingBy(paymentPage.realStateHolder_businessClassification);
		// enter EIN number
		waitFindEnterTextAsList(commonPage.common_send_text("employerEin"), TestData.NINE_DIGIT_NUMBER);
		// enter street
		waitFindEnterTextAsList(commonPage.common_send_text("addressLine1"), TestData.STREET_ADDRESS);
		// enter city
		waitFindEnterTextAsList(commonPage.common_send_text("city"), TestData.BENEFICIARY_ADDRESS);
		// pin code
		waitFindEnterTextAsList(commonPage.common_send_text("postalCode"), TestData.PIN_CODE);
		// preferred name
		waitFindEnterTextAsList(commonPage.common_send_text("checkPreferredName"), TestData.PREFERRED_NAME);
		// select state
		moveToWebElementAndClick(paymentPage.select_state);
		moveToWebElementAndClick(paymentPage.select_california);
		// save and proceed
		javaScriptClickUsingBy(commonPage.common_button("Save & Proceed"));

	}

	/**
	 * @param Add Controller Information
	 * @throws Exception
	 */
	public void addControllerInformationEntity() throws Exception {

		// adding Controller Information
		waitUntilLoadingPage("Controller Information", commonPage.common_clickable_button("Controller Information"));

		// Enter first and last name
		waitFindEnterTextAsList(commonPage.common_send_text("firstName"), TestData.ADMIT_FIRST_NAME);
		waitFindEnterTextAsList(commonPage.common_send_text("lastName"), TestData.ADMIT_CONTROLLER_NAME);
		// Enter phone number
		waitFindEnterTextAsList(paymentPage.phone_number, TestData.PHONE_NMBR);
		// Email
		waitFindEnterTextAsList(paymentPage.email_ID, TestData.EMAIL_ID_ADD_LEADS);
		// Job title
		waitFindEnterTextAsList(commonPage.common_send_text("jobTitle"), TestData.JOB_TITLE);
		// enter DOB
		moveToWebElementAndClick(commonPage.common_send_text("dateOfBirth"));
		javaScriptClickUsingBy(commonPage.common_span("Select Year:"));
		javaScriptClickUsingBy(paymentPage.select_year);
		javaScriptClickUsingBy(commonPage.common_clickable_button("OK"));
		// 9 digit code
		waitFindEnterTextAsList(commonPage.common_send_text("ssn"), TestData.NINE_DIGIT_NUMBER);
		// Address
		waitFindEnterTextAsList(commonPage.common_send_text("addressLine1"), TestData.STREET_ADDRESS);
		// select state
		moveToWebElementAndClick(paymentPage.select_state);
		moveToWebElementAndClick(paymentPage.select_california);
		// City
		waitFindEnterTextAsList(commonPage.common_send_text("city"), TestData.BENEFICIARY_ADDRESS);
		// pin code
		waitFindEnterTextAsList(commonPage.common_send_text("postalCode"), TestData.PIN_CODE);
		// save and proceed
		javaScriptClickUsingBy(commonPage.common_button("Save & Proceed"));

	}

	/**
	 * @param upload documents
	 * @throws Exception
	 */
	public void uploadControllerIDs() throws Exception {

		// wait to load page
		waitForPageLoad();
		focusStop(2000);
		// wait for pop up
		waitUntilLoadingPage("Add New Entity - Upload Documents",
				commonPage.common_clickable_button("Add New Entity - Upload Documents"));
		// upload Business Doc
		waitFindUploadPhotoWithoutClick(paymentPage.upload_document, upload_photo_verification);
		// select controller
		focusStop(4000);
		waitFindUploadPhotoWithoutClick(paymentPage.controller_ID, "Controller ID - Passport");
		clickOnScreenThroughRobot();
		focusStop(2000);
		// upload Controller ID
		waitFindUploadPhotoWithoutClick(paymentPage.upload_document, upload_photo_verification);
		// select business
		focusStop(4000);
		waitFindUploadPhotoWithoutClick(paymentPage.business_doc, "Business Document");
		clickOnScreenThroughRobot();
		
		// verify error message
		if (checkElementPresence(commonPage.common_clickable_button(
				"The current document count exceed the limit of 2 documents, please ensure that the total document count is not more than 2 (Current:3). ")) == true) {
			focusStop(1000);
			waitForElementToBeClickable(paymentPage.verify_delete);
			moveToWebElementAndClick(paymentPage.verify_delete);
		}
		
		// submit
		javaScriptClickUsingBy(commonPage.common_button("Submit"));
		
		// click ok//Documents uploaded successfully.
		waitUntilLoadingPage("Documents uploaded successfully.",
				commonPage.common_clickable_button("Documents uploaded successfully."));
		waitForElementToBeClickable(commonPage.common_button("OK"));
		moveToWebElementAndClick(commonPage.common_button("OK"));
	}

	/**
	 * @param verify created entity
	 * @throws Exception
	 */
	public void verifyAddedEntity() throws Exception {

		// wait to load page
		waitForPageLoad();
		// wait until loading page
		assertString(textFromApplication(paymentPage.text_entityName),TestData.ENTITY_NAME);
		assertString(textFromApplication(paymentPage.doc_verfication_pending),TestData.PENDING_DOCUMENT);
	}

}

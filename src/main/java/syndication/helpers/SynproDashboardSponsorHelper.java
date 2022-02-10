package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;
import static io.restassured.RestAssured.given;

public class SynproDashboardSponsorHelper extends CommonUtils {

	static final Logger LOGGER = Logger.getLogger(SynproDashboardSponsorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();

	String upload_photo_verification = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
			+ System.getProperty("file.separator") + "test" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "verification.png";

	// final InputStream inputStream =
	// Thread.currentThread().getContextClassLoader()
	// .getResourceAsStream("static/file_example_PNG_3MB.png");

	/**
	 * @param Dashboard
	 * @throws Exception
	 */
	public void verifyDashboardAsSponsor(String dashboardUrl, String productTourUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Dashboard", commonPage.common_clickable_button("Dashboard"));

		focusStop(2000);

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(dashboardUrl);

		// Verifying the product tour
		waitForElementToBeClickable(dashboardPage.product_tour);
		moveToWebElementAndClick(dashboardPage.product_tour);
		waitForElementToBeClickable(commonPage.common_clickable_button("Product Tour"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Product Tour"));

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(productTourUrl);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

	}

	public void verifyLeadsEmail() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Leads", commonPage.common_clickable_button("Leads"));

		// verifying toggle
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Verify Lead"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Verify Lead"));

		// Enable toggle button
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		javaScriptClickUsingBy(dashboardPage.toggle_enable);

		// Email verification
		waitForElementToBeClickable(dashboardPage.email);
		accessLink(dashboardPage.email);

		// Email compose
		waitForElementToBeClickable(commonPage.common_clickable_button("Compose"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Compose"));

		// Email to CC
		waitFindEnterText(commonPage.common_send_text("cc"), TestData.EMAIL_ID_AS_INVESTOR);

		// Email Subject
		waitFindEnterText(commonPage.common_send_text("subject"), TestData.EMAIL_SUBJECT);

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

	}

	public void verifyLeadsEdit() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Leads", commonPage.common_clickable_button("Leads"));

		// click and open edit profile
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		waitForElementToBeClickable(dashboardPage.email_edit);
		accessLink(dashboardPage.email_edit);

		// Edit nick name
		Thread.sleep(2000);
		waitUntilLoadingPage("Edit Profile", commonPage.common_clickable_button("Edit Profile"));
		waitFindEnterText(commonPage.common_send_text("nickName"), TestData.EMAIL_ID_AS_INVESTOR);

		// update profile
		waitForElementToBeClickable(commonPage.common_button("Update Profile"));
		moveToWebElementAndClick(commonPage.common_button("Update Profile"));

	}

	public void verifyLeadsNotes() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Leads", commonPage.common_clickable_button("Leads"));

		// click and open edit profile
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		waitForElementToBeClickable(dashboardPage.email_notes);
		accessLink(dashboardPage.email_notes);

		// delete existing
		Thread.sleep(2000);
		waitUntilLoadingPage("Add Notes", commonPage.common_clickable_button("Add Notes"));

		if (checkElementPresence(commonPage.common_clickable_button("Delete")) == true) {
			// Delete text
			waitForElementToBeClickable(commonPage.common_button("Delete"));
			moveToWebElementAndClick(commonPage.common_button("Delete"));
		}

		// Add a notes
		moveToWebElementAndClick(commonPage.common_button("Write a note"));

		// Write note inside the text
		Thread.sleep(2000);
		waitUntilLoadingPage("Add Notes", commonPage.common_clickable_button("Add Notes"));

		// Email click inside Text box
		moveToWebElementAndClick(dashboardPage.email_text);

		// click on plus icon
		waitForElementToBeClickable(dashboardPage.email_plus);
		moveToWebElementAndClick(dashboardPage.email_plus);

		// click on table
		waitForElementToBeClickable(dashboardPage.email_plus_table);
		moveToWebElementAndClick(dashboardPage.email_plus_table);

		// update profile
		Thread.sleep(2000);
		waitForElementToBeClickable(commonPage.common_button("Save"));
		moveToWebElementAndClick(commonPage.common_button("Save"));

		// close Notes pop up
		waitForElementToBeClickable(commonPage.close_popup);
		moveToWebElementAndClick(commonPage.close_popup);

	}

	public void verifyOfferingsUpdates(String offeringsUrl) throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Offerings", commonPage.common_clickable_button("Offerings"));

		// click on offerings and verify portfolio page
		waitForElementToBeClickable(commonPage.common_clickable_button("Offerings"));
		accessLink(commonPage.common_clickable_button("Offerings"));

		// verifying the dash-board page URL
		verifyingLoadApplicationPageUrl(offeringsUrl);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// click on send updates
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		waitForElementToBeClickable(dashboardPage.offerings_update);
		accessLink(dashboardPage.offerings_update);

		// Add updates
		Thread.sleep(2000);
		waitUntilLoadingPage("Date", commonPage.common_clickable_button("Date"));

		// Enter date
		waitForElementToBeClickable(commonPage.common_send_text("creationDate"));
		accessLink(commonPage.common_send_text("creationDate"));
		accessLink(dashboardPage.calender_date);

		// Email Subject
		waitFindEnterText(commonPage.common_send_text("subject"), TestData.OFFERINGS_EMAIL_SUBJECT);

		// enter from name
		waitFindEnterText(commonPage.common_send_text("name"), TestData.OFFERINGS_FROM_NAME);

		// Email click inside Text box
		moveToWebElementAndClick(dashboardPage.email_text);

		// click on plus icon
		waitForElementToBeClickable(dashboardPage.email_plus);
		moveToWebElementAndClick(dashboardPage.email_plus);

		// click on table
		waitForElementToBeClickable(dashboardPage.email_plus_table);
		moveToWebElementAndClick(dashboardPage.email_plus_table);

		// send copy to me
		waitForElementToBeClickable(commonPage.common_clickable_button("Send copy to me"));
		accessLink(commonPage.common_clickable_button("Send copy to me"));

		// upload photo
		waitFindUploadPhotoWithoutClick(dashboardPage.upload_file, upload_photo_verification);

		Thread.sleep(2000);
		waitForElementToBeClickable(commonPage.common_button("Save"));
		moveToWebElementAndClick(commonPage.common_button("Save"));

		// Add updates and shopping malls
		Thread.sleep(2000);
		waitUntilLoadingPage("Alert", commonPage.common_clickable_button("Alert"));
		waitForElementToBeClickable(commonPage.common_button("Okay"));
		moveToWebElementAndClick(commonPage.common_button("Okay"));

	}

	public void verifyOfferingsEdit() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Offerings", commonPage.common_clickable_button("Offerings"));

		// click on send updates
		scrollPageUpUsingActions(commonPage.common_clickable_button("Active Investments"));
		waitForElementToBeClickable(dashboardPage.offerings_edit);
		accessLink(dashboardPage.offerings_edit);

		// Add updates and shopping malls
		waitUntilLoadingPage("Investors", commonPage.common_clickable_button("Investors"));

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

	}

	public void verifyUsersInvestors(String allUsersURL, String verifiedUsersURL, String unVerifiedUsersURL,
			String investorURL, String openOfferingsURL, String manageOfferingsURL) throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on All users and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("All Users"));
		waitForElementToBeClickable(commonPage.common_clickable_button("All Users"));
		accessLink(commonPage.common_clickable_button("All Users"));

		// verify URL
		verifyingLoadApplicationPageUrl(allUsersURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on Verified Users and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("Verified Users"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Verified Users"));
		accessLink(commonPage.common_clickable_button("Verified Users"));

		// verify URL
		verifyingLoadApplicationPageUrl(verifiedUsersURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on Verified Users and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("Unverified Users"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Unverified Users"));
		accessLink(commonPage.common_clickable_button("Unverified Users"));

		// verify URL
		verifyingLoadApplicationPageUrl(unVerifiedUsersURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on investorURL and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("Investors"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Investors"));
		accessLink(commonPage.common_clickable_button("Investors"));

		// verify URL
		verifyingLoadApplicationPageUrl(investorURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on Open Offerings and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("Open Offerings"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Open Offerings"));
		accessLink(commonPage.common_clickable_button("Open Offerings"));

		// verify URL
		verifyingLoadApplicationPageUrl(openOfferingsURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

		// wait until loading page
		waitUntilLoadingPage("Users & Investors", commonPage.common_clickable_button("Users & Investors"));

		// click on Managed Offerings and verify URL
		scrollPageUpUsingActions(commonPage.common_clickable_button("Managed Offerings"));
		waitForElementToBeClickable(commonPage.common_clickable_button("Managed Offerings"));
		accessLink(commonPage.common_clickable_button("Managed Offerings"));

		// verify URL
		verifyingLoadApplicationPageUrl(manageOfferingsURL);

		// wait for loader
		waitForElementToBeClickable(commonPage.common_clickable_button("Dashboard"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Dashboard"));

	}

	public void verifyPagination() throws Exception {

		// wait to load page
		waitForPageLoad();

		// click on next for pagination leads
		scrollPageUpUsingActions(commonPage.common_clickable_button("Distributions"));
		waitForElementToBeClickable(commonPage.common_pagination_button("Offerings"));
		accessLink(commonPage.common_pagination_button("Offerings"));

		// click on next for pagination offerings
		scrollPageUpUsingActions(commonPage.common_clickable_button("Distributions"));
		waitForElementToBeClickable(commonPage.common_pagination_button("Leads"));
		accessLink(commonPage.common_pagination_button("Leads"));

	}
	
	/**
	 * @param verify values
	 * @throws Exception
	 */
	public void verifyDashboardKPI() throws Exception {

		// https://dev-backend.synprointernal.com/graphql

		// RestAssured.baseURI = "https://dev-backend.synprointernal.com/graphql";
		// ";

		// given().log().all().contentType("application/json").body(query).when().post("https://dev-backend.synprointernal.com/graphql").then().assertThat().statusCode(200);
		// https://swapi-graphql.netlify.app/.netlify/functions/index

	//	RestAssured.baseURI = "https://dev-backend.synprointernal.com/graphql";
		String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";

		given().log().all().contentType("application/json").header("hostname", "predev.dev.synprointernal.com")
				.body(query).when().log().all().post("https://dev-backend.synprointernal.com/graphql").then().log()
				.all().assertThat().statusCode(200);
	}


}

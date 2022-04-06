package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproMyInvestmentInvestorPage;
import syndication.pages.SynproPortfolioReworkReservationPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproMyInvestmentInvestorHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproMyInvestmentInvestorHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproMyInvestmentInvestorPage investPage = new SynproMyInvestmentInvestorPage();
	SynproPortfolioReworkReservationPage reworkReservation = new SynproPortfolioReworkReservationPage();

	public void verifyInvestmentInvestor() throws Exception {

		// wait to load page
		waitForPageLoad();

		// wait until Welcome pop-up page visible
		focusStop(2000);
		waitUntilLoadingPage("Welcome", commonPage.common_clickable_button("Welcome"));

		// Cancel Start tour
		focusStop(1000);
		waitForElementToBeClickable(commonPage.common_clickable_button("Cancel"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Cancel"));

		// Verifying and click on Invest
		waitForElementToBeClickable(commonPage.common_clickable_button("Invest"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Invest"));

		// wait to load page
		waitForPageLoad();

		// Create eSign Template
		waitUntilLoadingPage("Schedule a Call", commonPage.common_button("Schedule a Call"));
		focusStop(2000);

		// Automation offering Invest
		scrollPageDownUsingActions(investPage.invest_button("Automation Offering"));

		focusStop(2000);
		waitForElementToBeClickable(investPage.invest_button("Automation Offering"));
		javaScriptClickUsingBy(investPage.invest_button("Automation Offering"));

		// Diligence and confirm
		waitUntilLoadingPage("Diligence", commonPage.common_clickable_button("Diligence"));
		waitForElementToBeClickable(investPage.confirm_review_doc);
		javaScriptClickUsingBy(investPage.confirm_review_doc);
		javaScriptClickUsingBy(commonPage.common_button("Next"));

		// Invest and confirm
		focusStop(3000);
		waitUntilLoadingPage("Invest", commonPage.common_clickable_button("Invest"));
		waitForElementToBeClickable(investPage.select_investing_as_dropdown);
		moveToWebElementAndClick(investPage.select_investing_as_dropdown);
		waitForElementToBeClickable(investPage.select_automationDemo);
		javaScriptClickUsingBy(investPage.select_automationDemo);
		waitFindEnterTextAsList(commonPage.common_send_text("investedAmount"), TestData.INVESTMENT_AMOUNT);
		javaScriptClickUsingBy(commonPage.common_button("Next"));

		// Add missing profile
		waitUntilLoadingPage("Profile Setup Alert", commonPage.common_clickable_button("Profile Setup Alert"));
		javaScriptClickUsingBy(commonPage.common_button("Continue"));
		waitUntilLoadingPage("Update Profile", commonPage.common_clickable_button("Update Profile"));
		javaScriptClickUsingBy(commonPage.common_button("Save Profile"));

		focusStop(2000);
		waitUntilLoadingPage("Profile Not Complete", commonPage.common_clickable_button("Profile Not Complete"));
		javaScriptClickUsingBy(commonPage.common_button("Continue Anyway"));
		waitUntilLoadingPage("Profile Updated", commonPage.common_clickable_button("Profile Updated"));
		javaScriptClickUsingBy(commonPage.common_button("OK"));

		// Verify Accreditation
		focusStop(3000);
		waitUntilLoadingPage("Verify Accreditation", commonPage.common_clickable_button("Verify Accreditation"));
		waitForElementToBeClickable(commonPage.common_button("Continue"));
		javaScriptClickUsingBy(commonPage.common_button("Continue"));
		System.out.println("Already Accredited? Upload letter for review");

	}

	public void verifyEsignDocument() throws Exception {

		// wait for eSign template
		focusStop(3000);
		waitUntilLoadingPage("Choose an Available Document",
				commonPage.common_clickable_button("Choose an Available Document"));
		waitForElementToBeClickable(commonPage.common_button("Sign Now"));
		javaScriptClickUsingBy(commonPage.common_button("Sign Now"));

		focusStop(10000);
		moveInSideToFrame("x-hellosign-embedded");

		focusStop(3000);
		waitForElementToBeClickable(commonPage.common_span("OK"));
		javaScriptClickUsingBy(commonPage.common_span("OK"));

		// click to sign
		focusStop(3000);
		try {
			if (checkElementIsEnabled(commonPage.common_clickable_button("Click to sign")) == true) {
				waitForElementToBeClickable(commonPage.common_clickable_button("Click to sign"));
				moveToWebElementAndClick(commonPage.common_clickable_button("Click to sign"));
				moveToWebElementAndClick(commonPage.common_clickable_button("Click to sign"));
			}
		} catch (Exception e) {
			System.out.println("Facing error");
		}

		// click to try it in
		focusStop(3000);
		waitForElementToBeClickable(commonPage.select_tryInIt);
		javaScriptClickUsingBy(commonPage.select_tryInIt);

		// Enter signature name
		focusStop(3000);
		waitFindEnterTextAsList(commonPage.investor_Signature, TestData.INVESTOR_SIGNATURE);

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

	}

	public void verifyFundInvestment() throws Exception {

		// wait for Funding Instructions
		focusStop(3000);
		waitUntilLoadingPage("Funding Instructions", commonPage.common_clickable_button("Funding Instructions"));

		// click on select date
		waitForElementToBeClickable(commonPage.common_send_text("fundTransferDate"));
		javaScriptClickUsingBy(commonPage.common_send_text("fundTransferDate"));

		// select date
		focusStop(2000);
		waitForElementToBeClickable(commonPage.common_span("OK"));
		javaScriptClickUsingBy(commonPage.common_span("OK"));

		// click Submit
		waitForElementToBeClickable(commonPage.common_button("Submit"));
		javaScriptClickUsingBy(commonPage.common_button("Submit"));

		// wait for Pending Investments
		waitUntilLoadingPage("Pending Investments", commonPage.common_clickable_button("Pending Investments"));
		textFromApplication(commonPage.common_clickable_button("Pending Signature"));

	}

}

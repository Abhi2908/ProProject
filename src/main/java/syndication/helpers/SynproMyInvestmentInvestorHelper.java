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

		focusStop(2000);

		// wait until Welcome pop-up page visible
		waitUntilLoadingPage("Welcome", commonPage.common_clickable_button("Welcome"));

		focusStop(1000);

		// click on cancel Start tour
		waitForElementToBeClickable(commonPage.common_clickable_button("Cancel"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Cancel"));

		// Verifying and click on Invest
		waitForElementToBeClickable(commonPage.common_clickable_button("Invest"));
		moveToWebElementAndClick(commonPage.common_clickable_button("Invest"));

		// wait to load page
		waitForPageLoad();

		// waiting for Create eSign Template
		waitUntilLoadingPage("Schedule a Call", commonPage.common_button("Schedule a Call"));
		focusStop(2000);

		// click on Automation offering Invest
		scrollPageDownUsingActions(investPage.invest_button("Automation Offering"));
		focusStop(2000);
		waitForElementToBeClickable(investPage.invest_button("Automation Offering"));
		javaScriptClickUsingBy(investPage.invest_button("Automation Offering"));

		// wait for Diligence and confirm
		waitUntilLoadingPage("Diligence", commonPage.common_clickable_button("Diligence"));
		waitForElementToBeClickable(investPage.confirm_review_doc);
		javaScriptClickUsingBy(investPage.confirm_review_doc);
		javaScriptClickUsingBy(commonPage.common_button("Next"));

		// wait for Invest and confirm
		focusStop(3000);
		waitUntilLoadingPage("Invest", commonPage.common_clickable_button("Invest"));
		waitForElementToBeClickable(investPage.select_investing_as_dropdown);
		moveToWebElementAndClick(investPage.select_investing_as_dropdown);
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
		
		try {
			focusStop(3000);
			javaScriptClickUsingBy(commonPage.common_button("Yes"));
		} catch (Exception e) {

		}
		
		waitFindEnterTextAsList(commonPage.common_send_text("investedAmount"), TestData.INVESTMENT_AMOUNT);

		// wait for eSign template
		focusStop(3000);
		waitUntilLoadingPage("Invest", commonPage.common_clickable_button("Invest"));
		waitForElementToBeClickable(investPage.select_investing_as_dropdown);
		javaScriptClickUsingBy(investPage.select_investing_as_dropdown);
		javaScriptClickUsingBy(investPage.select_automationDemo);
		waitFindEnterTextAsList(commonPage.common_send_text("investedAmount"), TestData.INVESTMENT_AMOUNT);

		if (checkElementIsEnabled(commonPage.common_clickable_button("Subscriptions"))) {

			waitForElementToBeClickable(commonPage.common_clickable_button("Subscriptions"));

		}

		waitForElementToBeClickable(commonPage.common_clickable_button("eSign Tutorial"));

		// upload Document

		// select profile
		javaScriptClickUsingBy(commonPage.common_clickable_button("Select Profile"));
		javaScriptClickUsingBy(commonPage.common_clickable_button("Retirement Plan"));

		// sponsor signing order
		moveToWebElementAndClick(reworkReservation.sponsor_signing_order);
		javaScriptClickUsingBy(commonPage.common_clickable_button("Sponsor will eSign after the investor(s)"));

		// Number of investors signing
		focusStop(2000);
		moveToWebElementAndClick(reworkReservation.number_of_investor_sign);

		// save and upload

		// move inside frame
		focusStop(10000);
		moveInSideToFrame("x-hellosign-embedded");
		focusStop(5000);
		moveInSideToFrameWithTitle(reworkReservation.eSign_frame);

		// wait for Create Your Template

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

		// waiting for Create eSign Template

		focusStop(2000);

	}

}

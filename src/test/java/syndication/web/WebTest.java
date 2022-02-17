package syndication.web;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import syndication.helpers.SynproApiResponseCode;
import syndication.helpers.SynproDashboardInvestorHelper;
import syndication.helpers.SynproDashboardSponsorHelper;
import syndication.helpers.SynproHomeHelper;
import syndication.helpers.SynproLeadsSponsorHelper;
import syndication.helpers.SynproLoginSponsorHelper;
import syndication.helpers.SynproLogoutHelper;
import syndication.helpers.SynproMassEmailAsSponsorHelper;
import syndication.helpers.SynproRegistrationHelper;

public class WebTest extends TestBase {
	
	static final Logger logger = Logger.getLogger(WebTest.class.getName());

	SynproHomeHelper landingHomePage;
	SynproLoginSponsorHelper loginAsSponsor;
	SynproDashboardSponsorHelper dashboardAsSponsor;
	SynproLeadsSponsorHelper leadsAsSponsor;
	SynproRegistrationHelper registrationScenario;
	SynproDashboardInvestorHelper dashboardAsInvestor;
	SynproLogoutHelper logoutScenario;
	SynproApiResponseCode apiResponse;
	SynproMassEmailAsSponsorHelper massEmail;
	
	@BeforeSuite
	@Parameters("browser")
	public void setup(String browser) throws IOException {
		super.setup(browser);
		
		landingHomePage = new SynproHomeHelper();
		loginAsSponsor = new SynproLoginSponsorHelper();
		dashboardAsSponsor = new SynproDashboardSponsorHelper();
		leadsAsSponsor = new SynproLeadsSponsorHelper();
		registrationScenario = new SynproRegistrationHelper();
		logoutScenario = new SynproLogoutHelper();
		dashboardAsInvestor = new SynproDashboardInvestorHelper();
		apiResponse = new SynproApiResponseCode();
		massEmail = new SynproMassEmailAsSponsorHelper();
	}

	@BeforeMethod
	public void beforeMethodSetup(Method method) {
		test = extent.startTest(method.getName().toString());
		test.assignCategory(browser);
		try {
			//String browserName = CommonUtils.getBrowserDetails();
			startRecording(method.getName().toString());

		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// *************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
	
	/**
	 * Syndication-Pro test scenario : Verify Negative Use Case for Registration.
	 */
	//@Test(priority=0)
	public void synProNegativeTestForRegistrationPage() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			test.log(LogStatus.PASS, "SUCCESSFUL!! User was navigate to Login page successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User was not able to navigate to Login page!!");
			assert (false);
		}
		try {
			registrationScenario.negativeTestScenarioRegistrationAsInvestor(getProps().getProperty("SyndicationDevRegistrationUrl"));
			test.log(LogStatus.PASS, "SUCCESSFUL!! Negative use case pass successfully for Sign up page!!");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed!! Negative use case fail for Sign up page!!");
			Assert.fail(); 
			assert (false);
		}
	}
	
	/**
	 * Syndication-Pro test scenario : Verify Registration Successfully.
	 */
	//@Test(priority=1)
	public void synProRegistrationPage() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			registrationScenario.registrationAsInvestor(getProps().getProperty("SyndicationDevRegistrationUrl"));
			dashboardAsInvestor.verifyTourAsInvestor(getProps().getProperty("SyndicationDevInvestUrl"));
			dashboardAsInvestor.verifyAndUpdateMyInfoPageAsInvestor(getProps().getProperty("SyndicationDevInvestorAccountUrl"));
			logoutScenario.logoutPage();
			test.log(LogStatus.PASS, "SUCCESSFUL!! User registration successfully!!");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! User not able to registration successfully!!");
			Assert.fail(); 
			assert (false);
		}
	}
	
	
	
	/**
	 * Syndication-Pro test scenario : Verify Negative Use Case for login page as Sponsor.
	 */
	//@Test(priority=2)
	public void synProNegativeTestForLoginAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.negativeScenarioForLoginPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified Negative test cases");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! to Negative test cases");
			Assert.fail(); 
			assert (false);
		}
	}
	
	/**
	 * Syndication-Pro test scenario : Verify login successfully as Sponsor.
	 */
	//@Test(priority=3)
	public void synProLoginAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.loginPage();
			dashboardAsSponsor.verifyDashboardAsSponsor(getProps().getProperty("SyndicationDevDashboardUrl"), getProps().getProperty("SyndicationDevProductTourUrl"));
			logoutScenario.logoutPage();
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified login page as Sponsor");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! not able to login page as Sponsor");
			Assert.fail(); 
			assert (false);
		}
	}
	
	/**
	 * Syndication-Pro test scenario : Verify Dash-board as sponsor.
	 */
	//@Test(priority=4)
	public void synProDashboardAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.loginPage();
			String str = SynproApiResponseCode.getActiveInvestmentAmount();
			System.out.println(str);
			//dashboardAsSponsor.verifyLeadsEmail();
			dashboardAsSponsor.verifyLeadsEdit();
			//dashboardAsSponsor.verifyLeadsNotes();
			dashboardAsSponsor.verifyOfferingsUpdates(getProps().getProperty("SyndicationDevOfferingsUrl"));
			dashboardAsSponsor.verifyOfferingsEdit();
			dashboardAsSponsor.verifyUsersInvestors(getProps().getProperty("SyndicationDevLeadsUrl"), getProps().getProperty("SyndicationDevLeadsUrl"), getProps().getProperty("SyndicationDevLeadsUrl"), getProps().getProperty("SyndicationDevInvestorsUrl"), getProps().getProperty("SyndicationDevOfferingsUrl"), getProps().getProperty("SyndicationDevOfferingsUrl"));
			dashboardAsSponsor.verifyPagination();
			logoutScenario.logoutPage();
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified Dashboard");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! to Verified Dashboard");
			Assert.fail(); 
			assert (false);
		}
	}
	
	
	/**
	 * Syndication-Pro test scenario : Verify Leads as sponsor.
	 */
	//@Test(priority=5)
	public void synProLeadsAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.loginPage();
			leadsAsSponsor.verifyLeadsPage(getProps().getProperty("SyndicationDevLeadsUrl"));
			leadsAsSponsor.addLeads(getProps().getProperty("YopMail"), getProps().getProperty("SyndicationDevLeadsUrl"));
			leadsAsSponsor.verifyInvitesOnEmail(getProps().getProperty("YopMail"), getProps().getProperty("SyndicationDevLeadsUrl"));
			leadsAsSponsor.searchLeadAndVerify();
			leadsAsSponsor.resendInvites();
			leadsAsSponsor.verifyInvitesOnEmail(getProps().getProperty("YopMail"), getProps().getProperty("SyndicationDevLeadsUrl"));
			leadsAsSponsor.verifyLeadTitles();
			logoutScenario.logoutPage();
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified Leads Page");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! to Verified Leads page");
			Assert.fail(); 
			assert (false);
		}
	}
	
	/**
	 * Syndication-Pro test scenario : Verify Mass Email as sponsor.
	 */
	@Test(priority=5)
	public void synProMassEmailAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.loginPage();
			massEmail.massAsSendEmail(getProps().getProperty("SyndicationDevMassEmailUrl"));
			massEmail.createTemplate();
			//logoutScenario.logoutPage();
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified Dashboard");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! to Verified Dashboard");
			Assert.fail(); 
			assert (false);
		}
	}

}

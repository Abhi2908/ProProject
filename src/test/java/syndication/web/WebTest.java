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
import syndication.helpers.SynproRegistrationHelper;

public class WebTest extends TestBase {
	
	static final Logger logger = Logger.getLogger(WebTest.class.getName());

//	String emailFile = props.getProperty("EmailPath");
//	String emailFilePath = (System.getProperty("user.dir") + emailFile);
//	String passwordFile = props.getProperty("PasswordPath");
//	String passwordFilePath = (System.getProperty("user.dir") + passwordFile);
	
	
	SynproHomeHelper landingHomePage;
	SynproLoginSponsorHelper loginAsSponsor;
	SynproDashboardSponsorHelper dashboardAsSponsor;
	SynproLeadsSponsorHelper leadsAsSponsor;
	SynproRegistrationHelper registrationScenario;
	SynproDashboardInvestorHelper dashboardAsInvestor;
	SynproLogoutHelper logoutScenario;
	SynproApiResponseCode apiResponse;
	
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
	@Test(priority=0)
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
	@Test(priority=1)
	public void synProRegistrationPage() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			registrationScenario.registrationAsInvestor(getProps().getProperty("SyndicationDevRegistrationUrl"));
			dashboardAsInvestor.verifyTourAsInvestor(getProps().getProperty("SyndicationDevInvestUrl"));
			dashboardAsInvestor.verifyMyInfoPageAsInvestor(getProps().getProperty("SyndicationDevInvestorAccountUrl"));
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
	 * Syndication-Pro test scenario : Verify login successfully as Sponsor with negative scenarios.
	 */
	//@Test(priority=2)
	public void synProLoginAsSponsor() {
		try {
			SynproApiResponseCode.userAdminConfigSetup();
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.negativeScenarioForLoginPage(getProps().getProperty("EmailPath"), getProps().getProperty("SyndicationDevLoginPageUrl"));
			loginAsSponsor.loginPage();
			dashboardAsSponsor.verifyDashboardAsSponsor(getProps().getProperty("SyndicationDevDashboardUrl"), getProps().getProperty("SyndicationDevProductTourUrl"));
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
	 * Syndication-Pro test scenario : Verify Dash-board as sponsor.
	 */
	//@Test(priority=3)
	public void synProDashboardAsSponsor() {
		try {
			loadUrl(getProps().getProperty("SyndicationDevPageUrl"), getProps().getProperty("SyndicationDevSitetitle"));
			landingHomePage.landingPage(getProps().getProperty("SyndicationDevLoginPageUrl"));
			//loginAsSponsor.loginPage();
			dashboardAsSponsor.verifyDashboardKPI();
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
	//@Test(priority=4)
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
			test.log(LogStatus.PASS, "SUCCESSFUL!! Verified Dashboard");
		} catch (Exception e) {
			// To fail test in case of any element identification
			test.log(LogStatus.FAIL, "Failed!! to Verified Dashboard");
			Assert.fail(); 
			assert (false);
		}
	}
	
}

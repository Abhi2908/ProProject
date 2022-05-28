package syndication.web;

import com.github.javafaker.Faker;

public class TestData extends TestBase {

	static Faker faker = new Faker();
	
	/**
	 * Syndication-Pro Sign up Test data for Investor
	 */
	public static final String FIRSTNAME_AS_INVESTOR = "Automation";
	public static final String LASTNAME_AS_INVESTOR = "Demo";
	public static final String EMAIL_ID_AS_INVESTOR = "automation.demo@yopmail.com";
	public static final String PHONE_NUMBER = "1234567890";
	public static final String HEAR_ABOUT_US = "Social-Media";
	public static final String PASSWORD = "Test@1234567";
	
	/**
	 * Syndication-Pro Error Messages for Sign up Page
	 */
	public static final String FIRST_NAME_ERROR_MSG = "First Name is required";
	public static final String INVALID_EMAIL_ERROR_MSG = "Invalid email address";
	public static final String LAST_NAME_ERROR_MSG = "Last Name is required";
	public static final String EMAIL_ERROR_MSG = "Email is required";
	public static final String PHONE_NUMBER_ERROR_MSG = "Phone number is required";
	public static final String STATE_ERROR_MSG = "State is required";
	public static final String INVESTMENT_CAPACITY_ERROR_MSG = "Investment Capacity is required";
	public static final String ACCREDITED_ERROR_MSG = "Accredited Investor is required";
	public static final String HOW_DID_YOU_HEAR_ERROR_MSG = "How did you hear about us is required";
	public static final String PASSWORD_ERROR_MSG = "Password is required";
	public static final String CONFIRM_PASSWORD_ERROR_MSG = "Confirm Password is required";
	public static final String TERM_AND_CONDITIONS_ERROR_MSG = "Please accept terms and conditions";
	public static final String PASSWORD_TWELVE_CHARACTER_ERROR_MSG = "Password must have at least 12 characters, one uppercase letter, one lowercase letter, one number and one special character.";
	public static final String PASSWORD_MATCH_ERROR_MSG = "Password and Confirm Password does not match";
	
	/**
	 * Syndication-Pro Login Test data for Sponsor
	 */
	public static final String EMAIL_SUBJECT = "Test Automation Lead Subject";
	public static final String EMAIL_TEXT = "Show this message in rich text editor";
	public static final String OFFERINGS_EMAIL_SUBJECT = "Test Automation Offerings Subject";
	public static final String OFFERINGS_FROM_NAME = "QA Test Automation";
	
	/**
	 * Syndication-Pro Add Leads for Sponsor
	 */
	public static final String FIRSTNAME_ADD_LEADS = "Syndication";
	public static final String LASTNAME_ADD_LEADS = "Pro2";
	public static final String NICKNAME_ADD_LEADS = "synpro";
	public static final String EMAIL_ID_ADD_LEADS = "pyouinp.iopp@yopmail.com";
	public static final String INVESTMENT_CAPACITY = "$10,000 - $50,000";
	public static final String RESIDENCY = "CA";
	public static final String SELF_ACC = "Yes";
	
	/**
	 * Syndication-Pro Assert email messages
	 */
	public static final String EMAIL_INVITATION_ADD_LEADS = "You have been invited to join Predev . Please complete the sign-up process to get access and join our investor network.";
	public static final String POPUP_RESEND_MESSAGE = "Are you sure you want to send the invitation to register to everyone who has not registered?";
	public static final String INVITATION_POPUP = "";
	public static final String CREATE_TAG = "Automation Tag Created";
	public static final String DELETE_CREATE_TAG = "Are you sure you want to delete this group?";
	public static final String PERMANENTLY_DELETE_LEAD = "Are you sure you want to permanently delete selected users?";

	/**
	 * Generate bugs report path for slack
	 */	
	public static final String SLACK_URL = "https://slack.com/api/files.upload";
	public static final String SLACK_TOKEN = "Bearer xoxb-1417556211330-3087799714273-oItUj6BAz8fNevUJgTJiCQyc";
	public static final String WEBHOOK_SLACK_PRIVACY_URL = "https://hooks.slack.com/services/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";
	public static final String CHANNEL_NAME = "automation-report";
	
	/**
	 * Api end points
	 */
	public static final String LOGIN_ENDPOINT = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
	public static final String ACTIVE_INVESTMENT_ENDPOINT = "{\"query\":\"query syndicatorDashboardMetrics {\\n  syndicatorDashboardMetrics {\\n    activeInvestmentAmount\\n    activeInvestmentsCount\\n    averageActiveInvestmentsAmount\\n    allUsersCount\\n    verifiedUsersCount\\n    unverifiedUsersCount\\n    investorsCount\\n    activeOfferingsCount\\n    closedOfferingsCount\\n    offeringInvestmentAmount\\n    reservationInvestmentAmount\\n    distributionAmount\\n  }\\n}\\n\",\"variables\":null,\"operationName\":\"syndicatorDashboardMetrics\"}";
	
	/**
	 * Api end points
	 */
	public static final String MASS_EMAIL_NAME = "Automation Mass Email";
	public static final String SCHEDULED_TIME = "Scheduled";
	public static final String STATUS_PENDING = "Pending";
	public static final String MASS_EMAIL_TEMPLATE = "Automation Mass Email Template";
	public static final String MASS_EMAIL_DESCRIPTION = "Mass Email Description";
	public static final String NEW_MASS_EMAIL_TEMPLATE = "Automation New Email Template";
	public static final String NEW_MASS_EMAIL_DESCRIPTION = "New Email Description";
	
	/**
	 * ReworkReservation
	 */
	public static final String NEW_OFFERING_NAME = "Automation Offering";
	public static final String OFFERING_ENTITY = "Automation Offering Entity";
	public static final String OFFERING_SIZE = "123456";
	public static final String OFFERING_MIN_INVESTMENT = "50";
	public static final String VISIBILITY_ALL_USERS = "All Users";
	public static final String LOCATION_MAP = "California USA";
	public static final String KEY_HIGHLIGHT_VALUE = "2";
	public static final String AUTOMATION_DEMO_RESERVATION = "Automation Demo";
	
	/**
	 * Wire Transfer
	 */
	public static final String RECEIVING_BANK = "Bank of America";
	public static final String BANK_ADDRESS = "California Bank";
	public static final String ROUTING_NUMBER = "8970897893";
	public static final String ACCOUNT_NUMBER = "1000";
	public static final String BENEFICIARY_ACCOUNT_NAME = "Automation Beneficiary";
	public static final String BENEFICIARY_ADDRESS = "California";
	public static final String REFERENCE = "Automation Reference";
	public static final String OTHER_INSTRUCTIONS = "Keep Safe";
	
	/**
	 *Investment Value
	 */
	public static final String INVESTMENT_AMOUNT = "1000";
	public static final String INVESTMENT_PENDING = "Pending";
	public static final String INVESTMENT_ACCREDITED = "Accredited";
	public static final String INVESTOR_SIGNATURE = "Auto Investor Signature";
	public static final String INVESTOR_SPONSOR = "Auto Sponsor Signature";
	
	/**
	 *Payment New Entity
	 */
	public static final String ADMIT_FIRST_NAME = "Automation";
	public static final String ADMIT_LAST_NAME = "Payment";
	public static final String ADMIT_CONTROLLER_NAME = "Controller";
	public static final String ENTITY_NAME = "Automation Test";
	public static final String NINE_DIGIT_NUMBER = "904384474";
	public static final String PHONE_NMBR = "12345678908";
	public static final String STREET_ADDRESS = "12092, 82 Ave, Rogger Street";
	public static final String PIN_CODE = "78628";
	public static final String PREFERRED_NAME = "Preferred Name";
	public static final String JOB_TITLE = "QA Job";
	public static final String PENDING_DOCUMENT = "Document Verification Pending";
	
	public static final String ROUTING_BANK = "222222226";
	
}

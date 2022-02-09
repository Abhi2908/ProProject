package syndication.web;

import org.apache.log4j.Logger;
import com.github.javafaker.Faker;

public class TestData extends TestBase {

	static final Logger LOGGER = Logger.getLogger(TestData.class.getName());
	static Faker faker = new Faker();
	
	/**
	 * Syndication-Pro Sign up Test data for Investor
	 */
	public static final String FIRSTNAME_AS_INVESTOR = "Automation";
	public static final String LASTNAME_AS_INVESTOR = "Demo";
	public static final String EMAIL_ID_AS_INVESTOR = "automation.demo@yopmail.com";
	public static final String PHONE_AS_INVESTOR = "1234567890";
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
	public static final String ADD_EMAIL = "add.leads";
	public static final String EMAIL_ID_ADD_LEADS = "add.leads@yopmail.com";
	public static final String INVESTMENT_CAPACITY = "$10,000 - $50,000";
	public static final String RESIDENCY = "CA";
	public static final String SELF_ACC = "Yes";
	public static final String INVITED = "Invited";
	
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
	public static final String SLACK_URL = "https://hooks.slack.com/services/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	";
	public static final String SLACK_TOKEN = "xoxb-1417556211330-3087799714273-oItUj6BAz8fNevUJgTJiCQyc";
	
}
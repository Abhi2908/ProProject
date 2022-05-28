package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproLeadsSponsorPage {
	
	static final Logger logger = Logger.getLogger(SynproLeadsSponsorPage.class.getName());
	
	/**
	 * Syndication-Pro login page locators
	 */
	public By create_arrow_login = By.xpath("//*[@id=\"refreshbut\"]/button");
	public By iframe_yopInvitationMail = By.xpath("//*[@id=\"ifmail\"]");
	public By iframe_yopInvitationInbox = By.xpath("//*[@id=\"ifinbox\"]");
	public By select_residency_value = By.xpath("//*[@id=\"react-select-2-option-1-4\"]");
	public By click_checkBox_yopMail = By.xpath("//input[@type=\"checkbox\"]");
	public By delete_yopMail = By.xpath("//*[@id=\"delsel\"]");
	public By search_addLeadPage = By.xpath("//input[@type=\"text\"][@placeholder=\"Search\"]");
	public By profile = By.xpath("//*[@id=\"mui-component-select-profileId\"]/div");
	public By profile_synPro = By.xpath("//*[@id=\"menu-profileId\"]/div[3]/ul/li[2]/div/div");
	public By confidenceLevel = By.xpath("//*[@id=\"mui-component-select-reservationInterest\"]/div");
	public By veryLikely = By.xpath("//*[@id=\"menu-reservationInterest\"]/div[3]/ul/li[2]/div/div");
	public By select_reservation = By.xpath("//*[@id=\"mui-component-select-propertyId\"]/div");
	public By seedIntoApart = By.xpath("//*[@id=\"menu-propertyId\"]/div[3]/ul/li[3]/div/div");
	public By eyeArchive = By.xpath("//*[contains(text(),\"Very likely\")]/../button[2]");
	public By offering = By.xpath("//*[@id=\"mui-component-select-propertyId\"]/div");
	public By select_profile = By.xpath("//*[@id=\"mui-component-select-profileId\"]/div");
	public By status = By.xpath("//*[@id=\"mui-component-select-status\"]/div");
	public By checkBox_addLeadPage = By.xpath("//*[contains(text(),\"Syndication Pro2\")]/../../../../../../../td/div[2]//div[@class=\"form__checkbox form-unchecked\"]");
	public By create_tagField = By.xpath("//*[@id=\"react-select-single\"]");
	public By click_Create_tagField = By.xpath("//div[@role=\"menuitem\"]");
	public By select_emailType = By.xpath("//*[@id=\"mui-component-select-emailSubscriptionType\"]");
}

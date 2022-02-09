package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproLeadsSponsorPage {
	
	static final Logger LOGGER = Logger.getLogger(SynproLeadsSponsorPage.class.getName());
	
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
	public By checkBox_addLeadPage = By.xpath("//*[contains(text(),\"Syndication Pro2\")]/../../../../../../../td/div[2]//div[@class=\"form__checkbox form-unchecked\"]");
	public By create_tagField = By.xpath("//*[@id=\"react-select-single\"]");
	public By click_Create_tagField = By.xpath("//div[@role=\"menuitem\"]");
	public By select_emailType = By.xpath("//*[@id=\"mui-component-select-emailSubscriptionType\"]");
}

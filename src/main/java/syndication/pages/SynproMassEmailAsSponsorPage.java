package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproMassEmailAsSponsorPage {

	static final Logger logger = Logger.getLogger(SynproMassEmailAsSponsorPage.class.getName());

	/**
	 * Syndication-Pro mass email page locators
	 */
	public By recipients_value = By.xpath("//*[@id=\"react-select-2-option-0\"]");
	public By recipients_dropDown = By.xpath("//*[@id=\"react-select-single\"]");
	public By email_Type = By.xpath("//*[@id=\"mui-component-select-emailSubscriptionType\"]/div");
}

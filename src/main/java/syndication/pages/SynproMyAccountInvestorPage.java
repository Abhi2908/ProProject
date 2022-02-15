package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproMyAccountInvestorPage {
	
	static final Logger logger = Logger.getLogger(SynproMyAccountInvestorPage.class.getName());

	/**
	 * Syndication-Pro my account locators
	 */

	public By save_file_button = By.xpath("//*[contains(text(),\"Crop Image\")]/../..//*[contains(text(),\"Save\")]");
	public By upload_file_investor = By.xpath("//input[@id=\"exampleCustomFileBrowser\"][@type=\"file\"]");

}

package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import syndication.helpers.SynproApiResponseCode;

public class SynproCommonLocatorPage {
	
	static final Logger logger = Logger.getLogger(SynproCommonLocatorPage.class.getName());

	/**
	 * Syndication-Pro common page locators
	 */

	public By close_popup = By.id("test-id__close__button");

	public By common_clickable_button(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"" + select_name + "\")]");
		return webElement;
	}

	public By common_button(String select_name) {
		By webElement = By.xpath("//button[contains(text(),\"" + select_name + "\")]");
		return webElement;
	}

	public By common_send_text(String select_name) {
		By webElement = By.xpath("//input[@name=\"" + select_name + "\"]");
		return webElement;
	}

	public By common_field_value(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"" + select_name + "\")]/../..//input");
		return webElement;
	}

	public By common_pagination_button(String select_name) {
		By webElement = By.xpath("//div[@class=\"main__wrapper\"]//*[contains(text(),\"" + select_name
				+ "\")]/../../../..//*[contains(text(),\"Next\")]");
		return webElement;
	}

	public By select_from_dataValue(String select_name) {
		By webElement = By.xpath("//div/ul/li[@role=\"option\"][@data-value=\"" + select_name + "\"]");
		return webElement;
	}

	public By click_popUp(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"" + select_name + "\")]/../form//button[2]");
		return webElement;
	}
	
	public By popUp_Button(String select_name, String value) {
		By webElement = By.xpath("//*[contains(text(),\""+select_name+"\")]/../../..//*[contains(text(),\""+value+"\")]");
		return webElement;
	}
	
	

	public By assert_responsiveTableValues(String select_name) {
		By webElement = By.xpath("//*[@class=\" responsiveTable\"]//*[contains(text(),\"" + select_name + "\")]");
		return webElement;
	}
}

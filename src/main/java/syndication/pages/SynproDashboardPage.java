package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproDashboardPage {
	
	static final Logger LOGGER = Logger.getLogger(SynproDashboardPage.class.getName());

	/**
	 * Syndication-Pro login page locators
	 */
	public By product_tour = By.xpath("//img[@class=\"mr-2\"]");
	public By toggle_enable = By.xpath("//*[contains(text(),\"Anna bella\")]/../../../../../../td[2]//div[@class=\"react-switch\"]");
	public By email = By.xpath("//button[@class=\"button-transparent\"]/span[@class=\"action-icon lnr lnr-envelope\"]");
	public By email_text = By.xpath("//div[@class=\"fr-element fr-view\"]/div");
	public By email_plus = By.xpath("//div[@class=\"fr-quick-insert fr-visible\"]");
	public By email_plus_table = By.xpath("//div[@class=\"fr-qi-helper\"]/a[3]");
	public By email_edit = By.xpath("//button[@class=\"button-transparent\"]/span[@class=\"action-icon lnr lnr-pencil\"]");
	public By email_notes = By.xpath("//button[@class=\"button-transparent\"]/span[@class=\"action-icon lnr lnr-file-empty\"]");
	public By offerings_update = By.xpath("//button[@class=\"button-transparent\"]/span[@class=\"action-icon lnr lnr-bullhorn\"]");
	public By offerings_edit = By.xpath("//button[@class=\"button-transparent\"]/span[@class=\"action-icon lnr lnr-pencil\"]");
	public By calender_date = By.xpath("//p[contains(text(),'15')]");
	public By upload_file = By.xpath("//img[@alt=\"Add Action\"]//../../input[@type=\"file\"]");
	public By cross_tour = By.id("test-id__close__button");
}


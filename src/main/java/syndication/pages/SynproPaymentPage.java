package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproPaymentPage {
	
	static final Logger logger = Logger.getLogger(SynproPaymentPage.class.getName());

	/**
	 * Syndication-Pro Payment Page locators
	 */

	public By select_automationOffeting = By.xpath("//*[@id=\"react-select-single\"]");
	public By select_entityType = By.xpath("//*[@id=\"mui-component-select-businessType\"]");
	public By entityType_LLC = By.xpath("//*[@id=\"menu-businessType\"]/div[3]/ul/li[2]/div");
	public By select_businessClassification = By.xpath("//*[@id=\"mui-component-select-businessClassfication\"]");
	public By realStateHolder_businessClassification = By.xpath("//*[@id=\"menu-businessClassfication\"]/div[3]/ul/li[2]/div/div");
	public By select_state = By.xpath("//*[@id=\"mui-component-select-state\"]");
	public By select_california = By.xpath("//*[@id=\"menu-state\"]/div[3]/ul/li[6]/div");
	public By settings = By.xpath("//*[@id=\"PAYMENTS_TAB\"]/div/ul/div[2]/span/li/a");
	public By phone_number = By.xpath("//input[@class=\" form-control\"][@value=\"+1\"]");
	public By email_ID = By.xpath("//*[contains(text(),\"Controller Information\")]/..//input[@name=\"email\"]");
	public By select_year = By.xpath("//div[@class=\"MuiPickersBasePicker-pickerView\"]/div//*[contains(text(),\"1984\")]");
	public By upload_document = By.xpath("//form[@class=\"material-forms\"]//table/../../../../../input");
	public By controller_ID = By.xpath("//*[@id=\"react-select-4-input\"]");
	public By business_doc = By.xpath("//*[@id=\"react-select-5-input\"]");
	public By verify_delete = By.xpath("//div[@class=\"file-dropzone-component\"]/div[5]/div[3]/button");
	public By text_entityName = By.xpath("//*[contains(text(),\"Entity Name\")]/../../../../tbody/tr[1]/td[1]/div[2]/div[1]");
	public By doc_verfication_pending = By.xpath("//*[contains(text(),\"Entity Name\")]/../../../../tbody/tr[1]/td[1]/div[2]/div[2]/div");
}

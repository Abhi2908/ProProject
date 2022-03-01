package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproMassEmailAsSponsorPage{

	static final Logger logger = Logger.getLogger(SynproMassEmailAsSponsorPage.class.getName());

	/**
	 * Syndication-Pro mass email page locators
	 */
	public By recipients_value = By.xpath("//div[@class=\"css-11unzgr\"]/div");
	public By recipients_dropDown = By.xpath("//*[@id=\"react-select-single\"]");
	public By email_Type = By.cssSelector("#mui-component-select-emailSubscriptionType > div");
	public By column_Type = By.xpath("//*[@id=\"editor\"]//*[contains(text(),\"Columns\")]");
	public By button_Type = By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]");
	public By drop_Container = By.xpath("//*[@id=\"u_body\"]");
	public By column_dropType = By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div");
	public By frame = By.xpath("//iframe[@src=\"https://editor.unlayer.com/1.2.140/editor.html\"]");
	                                                                
	public By select_Column_Four = By.xpath("//div[@class=\"collapse show\"]/div/div/div/div/div[4]/div/div[2]/div");
	public By columnProperty_backgroundColor(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"Column Properties\")]/../../..//*[contains(text(),\""
				+ select_name + "\")]/../../..//*[contains(text(),\"Background Color\")]/../../../../div[2]/div/div");
		return webElement;
	}
	public By select_redColor = By.xpath("//div[@title=\"#E03E2D\"]");
	public By select_blackColor = By.xpath("//div[@title=\"#000000\"]");
	public By select_grayColor = By.xpath("//div[@title=\"#95A5A6\"]");
	
	public By columnProperty_Padding_moreOption(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"Column Properties\")]/../../..//*[contains(text(),\""
				+ select_name + "\")]/../../..//*[contains(text(),\"Padding\")]/../../../label[2]/div");
		return webElement;
	}

	public By columnProperty_padding_topIncrease = By
			.xpath("//*[contains(text(),\"Column Properties\")]/../../..//*[contains(text(),\"Top\")]/../..//input");
	
	public By columnProperty_allSides = By.xpath("//select[@class=\"sc-iqHYGH HDKDT form-control\"]");
	
	public By columnProperty_allSidesInput = By.xpath(
			"//*[contains(text(),\"Column Properties\")]/../../..//*[contains(text(),\"Border\")]/../../../..//input[@class=\"blockbuilder-counter-control-value\"]");
	
	public By columnProperty_borderColor(String select_name) {
		By webElement = By.xpath(
			"//*[contains(text(),\"Column Properties\")]/../../..//*[contains(text(),\""+select_name+"\")]/../../..//div[@class=\"float-right\"]/div/div/div");
		return webElement;
	}
	
	public By columnOne_rowProperty_backgroundColor(String select_name) {
		By webElement = By.xpath("//*[@id=\"editor\"]/div/div/div/div/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]//*[contains(text(),\""+ select_name +"\")]/../../../../../../..//div[3]/div/div/div/div[1]/div/div[2]/div/div/div");
		return webElement;
	}

	public By columnOne_paddingAllSides(String select_name) {
		By webElement = By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[3]/div/div/div[2]/div/div[2]/div[1]//*[contains(text(),\""+select_name+"\")]/../../../../../../..//div[3]/div/div/div/div[4]/div/div/div[2]/div/div[2]/input");
		return webElement;
	}
	public By select_time = By.xpath("//span/img[@alt=\"Add Action\"]");
	public By calendar_date = By.xpath("//p[contains(text(),\"30\")]");
	
	public By schedule_Time(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"Test Automation Lead Subject\")]/../../..//*[contains(text(),\""+select_name+"\")]");
		return webElement;
	}
}

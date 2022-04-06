package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproMyInvestmentInvestorPage {

	static final Logger logger = Logger.getLogger(SynproMyInvestmentInvestorPage.class.getName());

	/**
	 * Syndication-Pro Invest page
	 */
	public By invest_button(String select_name) {
		By webElement = By.xpath("//div[@class=\"card-item__content_name_wrapper\"]/*[contains(text(),\""+select_name+"\")]/../../../../../../div[@class=\"card-item__second-row\"]//button[contains(text(),\"Invest\")]");
		return webElement;
	}
	public By confirm_review_doc = By.xpath("//label[@class=\"material-label\"]//span[@class=\"checkbox-btn__label checkbox__width\"]");
	public By select_investing_as_dropdown = By.xpath("//*[@id=\"root\"]/div/div[1]/div/main/div/div[2]/div/div/div[3]/div/div/div/div/form/div/div[1]/div/div/div/div/div/div");
	public By select_automationDemo = By.xpath("//ul[@class=\"MuiList-root MuiMenu-list MuiList-padding\"]//li[2]");
	public By text_Pending(String select_name) {
		By webElement = By.xpath("//table//*[contains(text(),\"" + select_name + "\")]/../../../td[5]/div[2]/div");
		return webElement;
	}
}

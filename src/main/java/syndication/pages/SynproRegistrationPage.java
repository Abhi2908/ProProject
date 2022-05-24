package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproRegistrationPage {
	
	
	static final Logger logger = Logger.getLogger(SynproRegistrationPage.class.getName());
	/**
	 * Syndication-Pro registration page locators
	 */
	
	// Sign Up 
	public By phone = By.xpath("//input[@class=\" form-control\"]");
	
	// Sign up Drop-downs
	public By residency_dropDown = By.xpath("//*[@id=\"root\"]/div/div[1]/div/main/div/div/div/div[3]/form/div[3]/div/div/div/div/div/div/div[2]/span");
	public By residency = By.xpath("/html/body/div[3]/div/div[1]/div/div/div[2]/div/div[1]/form/div[3]/div[2]/div/div/div/div/div/div[1]");
	public By residency_dropDown(String select_name) {
		By webElement = By.xpath("//*[contains(text(),\"" + select_name + "\")]/../div/div/div/div/div[@class=\"css-bg1rzq-control\"]/div[1]");
		return webElement;
	}
	
	public By i_am_looking_to_invest = By.xpath("//*[@id=\"mui-component-select-investmentCapacity\"]");
	public By are_you_an_accredited_investor = By.xpath("//*[@id=\"mui-component-select-accreditatedInvestor\"]");
	public By recaptcha = By.xpath("//div[@class=\"form__checkbox form-unchecked\"]");
	public By terms_of_service = By.xpath("//div[(@class=\"form__checkbox form-unchecked\")]");
	
	

}

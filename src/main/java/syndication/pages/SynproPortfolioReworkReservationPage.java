package syndication.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SynproPortfolioReworkReservationPage  {
	
	static final Logger logger = Logger.getLogger(SynproPortfolioReworkReservationPage.class.getName());

	/**
	 * Syndication-Pro Rework Reservation Page locators
	 */
	public By title_offering(String select_name) {
		By webElement = By.xpath("//h3[contains(text(),\"" + select_name + "\")]");
		return webElement;
	}
	public By offering_type_dropdown = By.xpath("//*[contains(text(),\"Offering Type\")]/../div/div/div/div");
	public By select_investment_type = By.xpath("//li/div/div[contains(text(),\"Investment\")]");
	public By remove_Offering = By.xpath("//*[contains(text(),\"Automation Offering Entity\")]/../../../../..//span[@class=\"action-icon lnr lnr-trash\"]");
	public By offering_status_dropdown = By.xpath("//*[contains(text(),\"Status\")]/../div/div/div/div");
	public By select_accepting_reservation = By.xpath("//li/div/div[contains(text(),\"Accepting Investments\")]");
	public By offering_visibility_dropdown = By.xpath("//*[@id=\"react-select-single\"]");
	public By form_next_button = By.xpath("//form//button[contains(text(),\"Next\")]");
	public By textEditor = By.cssSelector("#PORTFOLIO__OFFERING__LANDING > div > div > div > div > div:nth-child(3) > div > div > div > div > div > form > div.undefined.style_form__field--wrapper__3thCK > div > div > div > div.fr-wrapper.show-placeholder > div");
	public By gallery_saveButton = By.xpath("//*[contains(text(),\"Summary\")]/../../../../..//button[contains(text(),\"Save\")]");
    public By gallery_image = By.xpath("//div[@class=\"dropzone__input\"]/input");
    public By welcome_document = By.xpath("//div[@class=\"file-dropzone-component__wrapper\"]/div[1]//input");
    public By upload_document = By.xpath("//div[@class=\"file-dropzone-component__wrapper\"]/div[2]//input");
    public By document_uploadButton = By.xpath("//*[contains(text(),\"Documents\")]/../../../../..//button[contains(text(),\"Upload\")]");
    public By document_SaveOrder_button = By.xpath("//*[contains(text(),\"Documents\")]/../../../../..//button[contains(text(),\"Save Order\")]");
    public By toggle_public = By.xpath("//*[contains(text(),\"Private\")]/../span[2]/div/div/div/div");
    public By select_location = By.xpath("//div[@class=\"pac-container pac-logo\"]/div");
    public By keyHighlight_Save = By.xpath("//*[contains(text(),\"Key Highlights\")]/../../../../..//button[contains(text(),\"Save\")]");
    public By select_wireTransfer = By.xpath("//span[contains(text(),\"Wire Transfer\")]");
    public By select_Savings = By.xpath("//span[contains(text(),\"Savings\")]");
    public By click_on_fundingInstruction_Save = By.xpath("//form[@class=\"material-forms\"]/div/div[7]/button");
    public By eSign_document = By.xpath("//div[@class=\"dropzone__input\"]/input");
    public By sponsor_signing_order = By.xpath("//*[@id=\"mui-component-select-adminSignatureOrder\"]");
    public By number_of_investor_sign = By.xpath("//*[@id=\"mui-component-select-investorCount\"]");
    public By number_of_investor_one = By.xpath("//*[@id=\"menu-investorCount\"]/div[3]/ul/li[2]");
    public By eSign_frame = By.xpath("//*[@id=\"root\"]/div/div[2]/div/iframe[@data-qa-ref=\"editor-iframe\"]");
    public By gotIt = By.xpath("/html/body/div[5]/div/div/div/div[3]/div/button");
    public By drag_Investor_sign = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/button");
    public By drop_Investor_sign = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[@data-qa-ref=\"page-0\"]/div/div/img");
    public By dropDown_signer = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/button");
    public By dropDown_select_sponsor = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[5]/button");
    public By continue_button = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[3]/div/button");
    public By logOut_eSign = By.xpath("//div[@class=\"sidebar__wrapper sidebar__wrapper--desktop\"]//ul[2]/a//p");
   
    public By button_automation_offering(String select_name) {
		By webElement = By.xpath("//table//button/div[1][contains(text(),\"" + select_name + "\")]");
		return webElement;
	}
    
    public By button_sign_now = By.xpath("//table[@class=\"common-table responsiveTable\"]//*[contains(text(),\"Automation Demo\")]/../../..//button[5]/span");
    public By button_close = By.xpath("//*[@id=\"test-id__close__button\"]");
    public By text_completed = By.xpath("//*[@id=\"PORTFOLIO__OFFERING__LANDING\"]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div[2]");
    
    public By edit_investor_status(String select_name) {
		By webElement = By.xpath("//table//button/div[1][contains(text(),\"" + select_name + "\")]/../../../../../td[8]//span[1]/button/span");
		return webElement;
	}
    
    public By select_status_dropdown = By.xpath("//*[@id=\"mui-component-select-status\"]");
    public By select_approved = By.xpath("//*[@id=\"menu-status\"]/div[3]/ul/li[3]/div/div");
}

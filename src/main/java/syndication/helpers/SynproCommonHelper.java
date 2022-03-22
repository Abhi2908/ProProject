package syndication.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproMassEmailAsSponsorPage;
import syndication.web.CommonUtils;
import syndication.web.GetDriver;

public class SynproCommonHelper extends GetDriver {

	static final Logger logger = Logger.getLogger(SynproCommonHelper.class.getName());
	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproMassEmailAsSponsorPage massEmailPage = new SynproMassEmailAsSponsorPage();

	
	

}

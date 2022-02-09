package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.web.CommonUtils;

public class SynproCommonHelper extends CommonUtils {

	static final Logger LOGGER = Logger.getLogger(SynproCommonHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();

	/**
	 * @param login via Gmail a/c
	 * @throws Exception
	 */
	public void verifyTourAsInvestor(String dashboardInvestUrl) throws Exception {

		// wait to load page
		waitForPageLoad();
	}
}

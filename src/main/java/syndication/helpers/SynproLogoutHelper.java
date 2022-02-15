package syndication.helpers;

import org.apache.log4j.Logger;

import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.web.CommonUtils;

public class SynproLogoutHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproLogoutHelper.class.getName());

	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproDashboardPage dashboardPage = new SynproDashboardPage();

	/**
	 * @param logout
	 * @throws Exception
	 */
	public void logoutPage() throws Exception {

		waitForPageLoad();

		focusStop(2000);
		
		// log out
		accessLink(commonPage.common_clickable_button("Log Out"));
		
	}

}

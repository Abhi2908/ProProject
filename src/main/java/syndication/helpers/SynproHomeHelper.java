package syndication.helpers;

import org.apache.log4j.Logger;
import syndication.web.CommonUtils;

public class SynproHomeHelper extends CommonUtils {

	static final Logger LOGGER = Logger.getLogger(SynproHomeHelper.class.getName());

	/**
	 * @param sending_url Verifying login URl and clicking on Buy Button
	 * @throws InterruptedException 
	 */
	public void landingPage(String sending_url) throws InterruptedException {

		// wait to load page
		waitForPageLoad();
			
		// verifying the home page URL
		//verifyingLoadApplicationPageUrl(sending_url);
		 
	}

}

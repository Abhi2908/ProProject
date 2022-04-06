package syndication.helpers;

import org.apache.log4j.Logger;
import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproMassEmailAsSponsorPage;
import syndication.web.GetDriver;

public class SynproCommonHelper extends GetDriver {

	static final Logger logger = Logger.getLogger(SynproCommonHelper.class.getName());
	SynproCommonLocatorPage commonPage = new SynproCommonLocatorPage();
	SynproMassEmailAsSponsorPage massEmailPage = new SynproMassEmailAsSponsorPage();

	
	

}

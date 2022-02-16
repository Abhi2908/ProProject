package syndication.helpers;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import syndication.pages.SynproCommonLocatorPage;
import syndication.pages.SynproDashboardPage;
import syndication.web.CommonUtils;
import syndication.web.TestData;

public class SynproCommonHelper extends CommonUtils {

	static final Logger logger = Logger.getLogger(SynproCommonHelper.class.getName());

}

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

public class SynproApiResponseCode {

	static final Logger LOGGER = Logger.getLogger(SynproApiResponseCode.class.getName());
	static JSONObject responseJson;
	static String getToken = "/data/token";


//	public static JSONObject userAdminConfigSetup() {
//		String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
//		Response req = given().log().all().contentType(ContentType.JSON)
//				.header("hostname", "predev.dev.synprointernal.com").body(query).when()
//				.post("https://dev-backend.synprointernal.com/graphql");
//
//		String body = req.getBody().asString();
//		System.out.println(body);
//	}	
	

}

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

	static final Logger logger = Logger.getLogger(SynproApiResponseCode.class.getName());
	static JSONObject responseJson;
	static String getToken = "/data/token";


	public static JSONObject userAdminConfigSetup() {
		String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
		Response req = given().log().all().contentType(ContentType.JSON)
				.header("hostname", "predev.dev.synprointernal.com").body(query).when()
				.post("https://dev-backend.synprointernal.com/graphql");

		String body = req.getBody().asString();
		System.out.println(body);
		


		//-----------------------------++------------------------//
			
			JSONObject responseJson = null;
			try {
				responseJson = new JSONObject(body);
				System.out.println("The response from API is:" + responseJson);
			} catch (JSONException e) {
				e.printStackTrace();

			}
			System.out.println(responseJson);
			return responseJson;

		}
		
		public static String getToken() throws JsonGenerationException, JsonMappingException, IOException {
			responseJson = userAdminConfigSetup();
			return getValueByJPath(responseJson, getToken);

		}
		
		public static String getValueByJPath(JSONObject responsejson, String jpath){
			Object obj = responsejson;
			for(String s : jpath.split("/")) 
				if(!s.isEmpty()) 
					if(!(s.contains("[") || s.contains("]")))
						obj = ((JSONObject) obj).get(s);
					else if(s.contains("[") || s.contains("]"))
						obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
			return obj.toString();
		}
	

}

package syndication.helpers;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import org.apache.log4j.Logger;

import io.restassured.response.Response;

public class SynproApiResponseCode {
	
	static final Logger LOGGER = Logger.getLogger(SynproApiResponseCode.class.getName());

//	public static Response getToken(String authCode) {
//
//		String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
//		return given().log().all().contentType("application/json").header("hostname", "predev.dev.synprointernal.com")
//				.body(query).when().log().all().post("https://dev-backend.synprointernal.com/graphql").then().log()
//				.all().assertThat().statusCode(200).extract().response();
//	}
//
//	public static String parseForAccessToken(Response loginResponse) {
//        return loginResponse.jsonPath().getString("access_token");
//    }
//
//	public void iShouldGetCode() {
//		
//		  String code = parseForOAuth2Code(response);
//		 Response tokenResponse = getToken(code);
//	        String accessToken = parseForAccessToken(tokenResponse);
//
//	}
	
	
	
//	  public static Response response;
//	
//	
//	
//	 public void userAdminConfigSetup() {
//	        requestSpecification = given().auth().oauth2(getAccessToken())
//	                .header("Accept", ContentType.JSON.getAcceptHeader())
//	                .header("hostname", "predev.dev.synprointernal.com")
//	                .contentType(ContentType.JSON);
//	    }
//
//	    public String getAccessToken() {
//	    	String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
//	        return given()
//	        		.log().all().contentType(ContentType.JSON).header("hostname", "predev.dev.synprointernal.com")
//					.body(query).when().log().all().post("https://dev-backend.synprointernal.com/graphql").then().log()
//					.all().assertThat().statusCode(200).extract().response().jsonPath().getString("access_token");
//	    }
//
//	 
//
//	    public void createUser() {
//	        userAdminConfigSetup();
//	        response = given(requestSpecification)
//	                .body(createUserPayload)
//	                .post("/user")
//	                .then().extract().response();
//
//	       
//	    }
	
	 public void userAdminConfigSetup() {
		 String query = "{\"query\":\"mutation login{\\nlogin(email: \\\"sweta.sharan@armentum.co\\\", password: \\\"123\\\"){\\nid\\ntoken\\n}\\n}\",\"variables\":null,\"operationName\":\"login\"}";
	Response req = given().log().all().contentType(ContentType.JSON).header("hostname", "predev.dev.synprointernal.com")
			.body(query).when().post("https://dev-backend.synprointernal.com/graphql");
	
	String body = req.getBody().asString();
	  System.out.println(body);

		 
	 }
	
	
	
	

}

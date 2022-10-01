package practice1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	void testRun() {
		
		//Base URI
		//RestAssured.baseURI = "https://mcinterview2022.testrail.io/index.php?/api/v2/add_result_for_case/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Body Params 
		JSONObject params = new JSONObject();
		params.put("status_id", "1");
		httpRequest.body(params.toJSONString());
		
		//Header
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.auth().preemptive().basic("jhernandez+012@zigatta.com", "Interview1@");
		
		//Authentication
//		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//		authScheme.setUserName("jhernandez+012@zigatta.com");
//		authScheme.setPassword("Interview1@");
//		RestAssured.authentication = authScheme;
		
		//Response Object 
		Response response = httpRequest.request(Method.POST, "https://mcinterview2022.testrail.io/index.php?/api/v2/add_result_for_case/16/1");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Assertions
		//Assert.assertEquals(response.getStatusCode(), 200);
		//Assert.assertEquals(response.getStatusLine(), "Success");
		
		
	}

}

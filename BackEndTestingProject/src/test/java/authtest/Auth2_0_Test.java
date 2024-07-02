package authtest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2_0_Test {

	@Test
	public void Auth2Test()
	{
		//pre-condition(Auth)
		Response resp = given()
		// before post request pass the the client id,secret
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then()
		.log().all();
		
		//capture token from the response [keyClock (Outh2.0)]
		String token =resp.jsonPath().get("access_token");
		
		//pre-condition(basic Auth)
				given()
				.auth().oauth2(token)
				.log().all()
				//Execution
				.when()
				.get("http://49.249.28.218:8091/projects")
				
				//Validation
				.then()
				.log().all();
	
	}

}


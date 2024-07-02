package RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario_3_getPayrollInfo {
	
	@Test
	public void sampleTest() {
		
		//API-1 get Authentication details given by developer
Response resp=		given()
		.formParam("client_id","ninza-client")
		.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type","client_credentials")
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().log().all();
/*
 * .when() .post(
 * "http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
 * resp.then().log().all();
 */
		
		
		
		//capture the token from the response
		String token = resp.jsonPath().get("access_token");
		
		//API-2 get payroll info
		/*    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MTkyMzcwNTUsImlhdCI6MTcxOTIzNTI1NSwianRpIjoiNjgzOWM4NmItZTVhZC00MmIyLTliZmEtOWE5NjBjY2E2NGI1IiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJjZTg3NTllNC03ZjhlLTQ4YmEtOGU3My05MjJkZmQ2MDBlYWMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHA6Ly80OS4yNDkuMjguMjE4OjgwOTEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbmluemEiLCJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJjbGllbnRIb3N0IjoiMTAuMTAuMjAuMSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SWQiOiJuaW56YS1jbGllbnQiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtbmluemEtY2xpZW50IiwiY2xpZW50QWRkcmVzcyI6IjEwLjEwLjIwLjEifQ.Cz4KrXzGsNLFBD9S_3pQt1ML6Ux4pyrJ__IS3mV2Z24BA69pPLk42wxrMHeRwdJfBQSAqlN5ys6cCjFxWOPFoVnuCFPGGB0KPMhG5AyXKvgj3C1JAteTRCqyCkNtZVkitApKdD7064jJQDA9mGjAJCfTddXnjzO5Ll93RgjGlQQqxlE6HQ5vFqhxaq5AkB4szOQnJKB-QXX8WdyJJUAsiiqnImLk6h-J5RS2jVHNucmzDub3OcnLs_ZWMabolPMj6MjywbUitp6tcxrHED_HEq1v79CkcG79d_S4U0nmlUYepTbJZDTqpxHiMDhUmP-xV0Rl2N3wJsZwu5nvuo0XSg",
*/
		 given().auth().oauth2(token)
		 .get("http://49.249.28.218:8091/admin/payrolls").then().log().all();
		 
		
		
	}

}

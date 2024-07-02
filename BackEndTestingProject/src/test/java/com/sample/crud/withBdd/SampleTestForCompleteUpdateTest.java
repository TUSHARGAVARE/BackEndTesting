package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Tusshar");
		jsonObj.put("projectName", "FishermanWarf");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 1);
		/*pre-condition*/
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		/*http methods*/
		.when().put("http://49.249.28.218:8091/project/NH_PROJ_222")
		/*response validation/post-condition*/
		.then().assertThat().statusCode(200).log().all();
		
	}
}
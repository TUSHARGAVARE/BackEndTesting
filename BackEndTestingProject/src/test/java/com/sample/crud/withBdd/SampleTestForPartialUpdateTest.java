package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {

	@Test
	public void putDataToServer() {
		JSONObject jsonObj = new JSONObject();

		
		jsonObj.put("projectName", "Bonder");
	

		//"http://49.249.28.218:8091/project/NH_PROJ_194"
		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_221")
		.then().assertThat().statusCode(200)
		.log().all();
	
	}
}
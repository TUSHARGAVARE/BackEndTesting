package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCreateTest {

	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Macaeeew");
		jsonObj.put("projectName", "Affviahhhry");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 100);

	 given().contentType(ContentType.JSON).body(jsonObj.toJSONString())
	 .when().post("http://49.249.28.218:8091/addProject").
	 then().assertThat().statusCode(201).log().all();

	
	}
}
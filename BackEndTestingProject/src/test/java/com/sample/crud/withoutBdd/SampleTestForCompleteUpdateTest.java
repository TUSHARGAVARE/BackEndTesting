package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Tusshara");
		jsonObj.put("projectName", "UpdateTask");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 11);

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);// contenttype-json
		req.body(jsonObj.toJSONString());

		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_194");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
}
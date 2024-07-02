package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {

	@Test
	public void putDataToServer() {
		JSONObject jsonObj = new JSONObject();

		
		jsonObj.put("projectName", "LaserBeamGun");
	

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);// contenttype-json
		req.body(jsonObj.toJSONString());

		Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_194");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
}
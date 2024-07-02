package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	
	@Test
	public void getDataFromServer() {
		Response resp =  RestAssured.get("http://49.249.28.218:8091/projects");
		System.out.println(resp.prettyPrint());//pretteyprint going to format response into Json format
		resp.then().assertThat().statusCode(200);//assertion or validation
		resp.then().log().all();//display complete response header info
		
	}

}

package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	
	@Test
	public void getDataFromServer() {
		Response resp =  RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_201");
		System.out.println(resp.prettyPrint());//pretteyprint going to format response into Json format
		resp.then().assertThat().statusCode(204);//assertion or validation
		resp.then().log().all();//display complete response header info
		
	}

}

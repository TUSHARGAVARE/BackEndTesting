package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	
	@Test
	public void getDataFromServer() {
		
		given().delete("http://49.249.28.218:8091/project/NH_PROJ_232")
		.then().assertThat().statusCode(204).log().all();
		
		
		
	}

}

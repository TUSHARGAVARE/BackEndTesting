package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameterTest {
	@Test
	
	public void formParamTest() {
		
		given()
		.formParam("teamSize",10) //form param for passing sensitive data in body
		.log().all()// display logs of request header and body
		.when()
		.post("http://49.249.28.218:8091/project")//cannot use get with form param (to hide) 
		.then()
		.log().all();//display logs of response header and body
	}

}

package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	
	public void pathParamTest() {
		
		given()
		.pathParam("projectId","NH_PROJ_994")
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then()
		.log().all();
	}

}

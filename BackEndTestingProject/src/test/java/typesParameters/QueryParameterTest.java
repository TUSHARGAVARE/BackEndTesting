package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
	@Test
	
	public void queryParamTest() {
		
		given()
		//.pathParam("projectId","NH_PROJ_994")//path param
		.queryParam("projectId","NH_PROJ_994") //not hardcode
		.when()
		//.get("http://49.249.28.218:8091/project?projectId=NH_PROJ_994")//query param
		//.get("http://49.249.28.218:8091/project?teamSize=10")//query param with filter with hard code
		.get("http://49.249.28.218:8091/project")//not hard code
		//Is used to Search specific data from Server & also filtering
		.then()
		.log().all();
	}

}

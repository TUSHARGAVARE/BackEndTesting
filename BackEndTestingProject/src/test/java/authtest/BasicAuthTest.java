package authtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BasicAuthTest {

	@Test
	public void bascAuthTest()
	{
		//pre-condition(basic Auth)
		given()
		.auth().basic("rmgyantra","rmgy@9999")
		.log().all()
		//Execution
		.when()
		.get("http://49.249.29.5:8091/login")
		
		//Validation
		.then()
		.log().all();
	}

}

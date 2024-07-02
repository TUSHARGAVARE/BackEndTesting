package authtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DigestiveAuthTest {

	@Test
	public void DigestAuthTest()
	{
		//pre-condition(basic Auth)
		given()
		.auth().digest("rmgyantra","rmgy@9999")
		.log().all()
		//Execution
		.when()
		.get("http://49.249.29.5:8091/login")
		
		//Validation
		.then()
		.log().all();
	}

}
//in bacckend username & password is encrypted and encoded by MD5 protocol
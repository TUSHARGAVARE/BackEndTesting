package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParamParameterTest {
	@Test

	public void paramParaTest() {

		given().param("teamSize", 10) // param for passing  data in body
		.log().all()// display logs of request header and body
		.when()
		//.get("http://49.249.28.218:8091/project")
		/* with get request acts like query parameter where data is attached along with query*/
		.post("http://49.249.28.218:8091/project")
		//with post request acts like form parameter where data not attach in url(data sensitive)
		.then().log().all();// Display logs of response header and body
	}

}

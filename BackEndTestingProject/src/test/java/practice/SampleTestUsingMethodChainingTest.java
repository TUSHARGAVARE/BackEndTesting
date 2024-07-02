package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChainingTest {
	@Test
	public void getRequestTest() {
		get("https://reqres.in/api/users?page=2").then().log().all();
		// Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		// System.out.println(resp.prettyPrint());

	}

}

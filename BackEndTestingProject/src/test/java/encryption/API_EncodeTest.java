package encryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class API_EncodeTest {
	@Test
	
	public void encodeTest()
	{
		//Passing  credentials before sending get request
		given()
		.auth()
		.preemptive()//display sensitive password in header which can be decrypted and easily used by  hacker
		//So we are not going to use preemptive instead wee use digestive auth
		.basic("rmgyantra","rmgy@9999").log().all()//To display header request
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then().log().all();
		

	}

}

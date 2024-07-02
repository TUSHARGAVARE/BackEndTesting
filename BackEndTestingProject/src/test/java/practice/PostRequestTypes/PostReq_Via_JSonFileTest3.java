package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
// program using  JSonFile

public class PostReq_Via_JSonFileTest3 {
	
	@Test
	public void postDataToServer() {

		File fileObj = new File("./proj.json");

	 given()
	 .contentType(ContentType.JSON)
	 .body(fileObj)
	 .when()
	 .post("http://49.249.28.218:8091/addProject").
	 then()
	 .assertThat().statusCode(201)
	 .log().all();

	
	}

	

}

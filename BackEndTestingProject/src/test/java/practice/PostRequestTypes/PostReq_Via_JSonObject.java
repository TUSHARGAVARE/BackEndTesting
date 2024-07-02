package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
// program using  JSon Object

public class PostReq_Via_JSonObject {
	
	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Pedru");
		jsonObj.put("projectName", "Poder");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 1);

	 given()
	 .contentType(ContentType.JSON)
	 .body(jsonObj.toJSONString())
	 .when()
	 .post("http://49.249.28.218:8091/addProject").
	 then()
	 .assertThat().statusCode(201)
	 .log().all();

	
	}

	

}

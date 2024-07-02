package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
// program using  Hash Map

public class PostReq_Via_HashMapTest {
	
	@Test
	public void postDataToServer() {
		HashMap<String,Object> map = new HashMap();

		map.put("createdBy", "Pedru");
		map.put("projectName", "XakistavAlmma");
		map.put("status", "Created");
		map.put("teamSize", 1);

	 given()
	 .contentType(ContentType.JSON)
	 .body(map)
	 .when()
	 .post("http://49.249.28.218:8091/addProject").
	 then()
	 .assertThat().statusCode(201)
	 .log().all();

	}

}

package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;

// program using  POJO Class

public class PostReq_Via_PojoClassTest4 {
	
	@Test
	public void postDataToServer() {
  
		 //create an Object to Pojo class
	
		Random random=  new Random();
		int ranNum = random.nextInt(1000);
		ProjectPojo pObj = new ProjectPojo("BondoNaal_"+ranNum,"Created","Tusshara",1);

	 given()
	 .contentType(ContentType.JSON)
	 .body(pObj)
	 .when()
	 .post("http://49.249.28.218:8091/addProject").
	 then()
	 .assertThat().statusCode(201)
	 .log().all();

	
	}

	

}

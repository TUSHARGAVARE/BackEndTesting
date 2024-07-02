package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

// program using  POJO Class

public class Scenario_1_DeleteProjectTest {
	
	@Test
	public void postDataToServer() {
  
		 //create an Object to Pojo class
	
		Random random=  new Random();
		int ranNum = random.nextInt(1000);
		
		
		//Api-1 ===> Add a project inside the Server
		ProjectPojo pObj = new ProjectPojo("BondoNaal_"+ranNum,"Created","Tusshara",1);

	Response resp =  given()
	 .contentType(ContentType.JSON).body(pObj).when().post("http://49.249.28.218:8091/addProject");
	resp.then().assertThat().statusCode(201)
	.and()
	.assertThat().body("msg",Matchers.equalTo("Successfully Added"))
	.log().all();

	//capture projectName from the response
	String projectID = resp.jsonPath().get("projectId");
	System.out.println(projectID);
	
	
	//Api-2 Delete Project
	
	        given().delete("http://49.249.28.218:8091/project/"+projectID)
	.then().log().all();
	
	
	
	}

	

}

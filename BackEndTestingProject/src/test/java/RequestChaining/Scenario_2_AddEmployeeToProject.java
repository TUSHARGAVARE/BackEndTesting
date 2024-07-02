package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmpPOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddEmployeeToProject {

	@Test
	public void sampleTest() {
		 //create an Object to Pojo class
		
		Random random=  new Random();
		int ranNum = random.nextInt(1000);
		
		
		//Api-1 ===> Add a project inside the Server
		ProjectPojo pObj = new ProjectPojo("BondoNaal_"+ranNum,"Created","Tusshara",1);
	Response resp =  given()
	 .contentType(ContentType.JSON).body(pObj)
	 .when().post("http://49.249.28.218:8091/addProject");
	resp.then().assertThat().statusCode(201)
	.and()
	.assertThat().body("msg",Matchers.equalTo("Successfully Added")).log().all();

	//capture projectName from the response
	String projName = resp.jsonPath().get("projectName");
	System.out.println(projName);
	
	//API-2 ===>Add Employee to same Project
	
	
	EmpPOJO empObj = new EmpPOJO("Tester","10/03/1996","tusshargavare52@gmail.com","Tusshara_"+ranNum,
			18,"9096388835", projName,"ROLE_EMPLOYEE", "Tusshara_"+ranNum);
	
	 given()
	 .contentType(ContentType.JSON).body(empObj)
	 .when().post("http://49.249.28.218:8091/employees")
	 .then().assertThat().statusCode(201)
	 .log().all();
	
	
	
	
	
	
	
	
	
	
	
	
	}
}

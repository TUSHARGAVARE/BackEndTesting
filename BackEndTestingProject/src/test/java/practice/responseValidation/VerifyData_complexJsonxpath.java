package practice.responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_complexJsonxpath
{

	@Test
	public void sampleTest() 
	{
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();

		List<String> list = JsonPath.read(resp.asString(), ".content[*].projectName");
		for (String data : list)
		{
			System.out.println(data);
		}

		List<String> list0 = JsonPath.read(resp.asString(), ".content[*].projectId");
		for (String data0 : list0) 
		{
			System.out.println(data0);
		}

		List<String> list1 = JsonPath.read(resp.asString(), ".content[*].[?(@.projectName=='Airtel_3217')].projectId");
		System.out.println("project ID : "+ list1.get(0));
		String actProjectID = list1.get(0);

		Assert.assertEquals(actProjectID, "NH_PROJ_862");

		// Extract first ProjectId
		// Data Base validation
		// Request Chaining
		
	}

}

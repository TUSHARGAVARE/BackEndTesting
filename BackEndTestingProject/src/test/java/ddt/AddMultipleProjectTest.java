package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest  {
	
	@Test(dataProvider = "getData")
	public void multipleProjTest(String projName,String status) {
		// passing body by simple way
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Tusshar\",\r\n"
				+ "  \"projectName\": \""+projName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";

		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();

	}

	//Instead of Hardcode getting the data from Excel
	//Execute Same Request Multiple Times with different set of Data for that we use data provider
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int count =eLib.getRowcount("project");//project sheet name
		
		Object[][] objarr = new Object[count][2];//no change in column every time need to pass 2 set of data
		
		for (int i =0;i<count;i++) {
			objarr[i][0] = eLib.getDataFromExcel("project",i+1,0);//(i+1) i dont want to get data from 0th row ,so that my obj arr always start from 0
			objarr[i][1] = eLib.getDataFromExcel("project",i+1,1);
		
		}
		return objarr;
	}
}

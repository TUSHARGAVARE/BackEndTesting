package encryption;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayrollInfoViaAESEncrytionTest {
	
	@Test
	public void aESTest() throws Exception {
		
		//for Encryption
		EncrypAndDecryptUtility ed = new EncrypAndDecryptUtility();
		
		//4 ways to post request haspmap,json object,json file,pojo object
		
		//doing with another easy way
		String jsonBody = " { \"employee\": { \"empId\":\"NH_PROJ_1649\", \"designation\": \"TeamManager\", \"dob\": \"10/03/1985\", \"email\": \"tusshargavare52@gmail.com\", \"empName\": \"Tushar\", \"experience\": 4, \"mobileNo\": \"9096288835\", \"project\": \"Viva SaoJao\", \"role\": \"created\", \"username\": “tzar” }, \"basicPlusVda\": 700, \"hra\": 5000, \"insurance\": 3000, \"lta\": 2000, \"lwf\": 7000, \"netPay\": 100000, \"payroll_id\": 10, \"pf\": 10, \"pt\":10, \"stat_bonus\": 2000, \"status\": “Active” }";
		String jsonReqBody = ed.encrypt(jsonBody,"Ac03tEam@j!tu_#1");
		System.out.println(jsonReqBody);
		Response resp =     given()
							.body(jsonReqBody)
							.when()
							.put("http://49.249.28.218:8091/payroll");
							resp.then().log().all();
		String respBody	=ed.decrypt(resp.getBody().asString(),"Ac03tEam@j!tu_#1");
		System.out.println(respBody);
	}

}

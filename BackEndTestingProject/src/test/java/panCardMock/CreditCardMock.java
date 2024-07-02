package panCardMock;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;
import spark.Spark;

public class CreditCardMock {

	public static void main(String[] args) {
		
		//develop mocking solution for post request /creditcard is a end point

		Spark.port(8889);//spark is class, set port no.
		//bcoz once mocking solution developed i want to run this mocking solution using port no.
		Spark.post("/credit-card",(req,resp)->{
			
		String response = "";
		String card = JsonPath.read(req.body().toString(), "$.creditcard");//capture data from response
			if(StringUtils.equalsAny(card,"1234567891234","1234567891235")) //can add multiple credit cards using string utils
			{
				response = "{\"status\":\"Payment success\"}";
				resp.status(200);
			}
			else
			{
				response = "{\"status\":\"Payment failed\"}";
				resp.status(404);
						}
			resp.type("applicaton/json");
			
			return response;
		});
		System.out.println("============================Running............===============================");
	}

}

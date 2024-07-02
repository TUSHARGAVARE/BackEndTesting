package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {

	@Test
	public  void verifyHeader()
	{
		Response resp = given().get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		long timeTakenMs =  resp.time();//display in milli-seconds
		long timeTakenSec =  resp.timeIn(TimeUnit.SECONDS);//display in  seconds
		
		System.out.println(timeTakenMs);
		System.out.println(timeTakenSec);

		resp.then().assertThat().time(Matchers.lessThan(2000L)); // compare response time in milli-sec by  less than
		resp.then().assertThat().time(Matchers.greaterThan(1000L)); //compare response time in milli-sec by  greater than

		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(2000L)).and(Matchers.greaterThan(1000L)));
		

	}

}

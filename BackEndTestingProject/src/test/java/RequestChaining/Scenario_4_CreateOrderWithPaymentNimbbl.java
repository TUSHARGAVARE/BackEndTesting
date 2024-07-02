package RequestChaining;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_4_CreateOrderWithPaymentNimbbl {

	private static String orderId;

	public static void main(String[] args) {

		// https://nimbbl.biz/docs/api-reference/introduction/

		baseURI = "https://api.nimbbl.tech";

		System.out.println("*************************post request***************");
		// authorization post request to generate token
		String accesskey = "access_key_pKx7rWVgVpbXQvq2";
		String accesssecret = "access_secret_DX3w55VKAkXbx7aB";
		String authorizationRequestBody = "{\"access_key\":\"" + accesskey + "\",\"access_secret\":\"" + accesssecret
				+ "\"}";
		Response authorizationresponsebody = given().body(authorizationRequestBody).contentType(ContentType.JSON)
				.post("/api/v3/generate-token");
		authorizationresponsebody.then().log().all();
		String token = authorizationresponsebody.jsonPath().get("token");
		String bearertoken = "Bearer " + token;
		System.out.println(bearertoken);

		System.out.println("*****************************create post request******************");
		// create an order request
		String invoiceid = "inv_" + new Random().nextInt();
		System.out.println(invoiceid);

		String createorderresponsebody = "{\r\n" + "  \"amount_before_tax\": 2100,\r\n" + "  \"tax\": 105,\r\n"
				+ "  \"total_amount\": 2205,\r\n" + " \"user\": {\r\n"
				+ "    \"email\": \"wonderwoman@themyscira.gov\",\r\n" + "    \"first_name\": \"Diana\",\r\n"
				+ "    \"last_name\": \"Prince\",\r\n" + "    \"country_code\": \"+91\",\r\n"
				+ "    \"mobile_number\": \"9876543210\"\r\n" + "  },\r\n" + "  \"shipping_address\": {\r\n"
				+ "    \"address_1\": \"1080 Beach Mansion\",\r\n" + "    \"street\": \"Magic Beach Drive\",\r\n"
				+ "    \"landmark\": \"Opposite Magic Mountain\",\r\n" + "    \"area\": \"Elyria\",\r\n"
				+ "    \"city\": \"Atlantis\",\r\n" + "    \"state\": \"Castalia\",\r\n"
				+ "    \"pincode\": \"100389\",\r\n" + "    \"address_type\": \"Beach House\"\r\n" + "  },\r\n"
				+ "  \"currency\": \"INR\",\r\n" + "  \"invoice_id\": \"" +invoiceid+"\",\r\n"
				+ "  \"referrer_platform\": \"aba\",\r\n" + "  \"referrer_platform_version\": \"123\",\r\n"
				+ "  \"order_line_items\": {\r\n" + "    \"items\": {\r\n"
				+ "      \"sku_id\": \"item_2783027490\",\r\n" + "      \"title\": \"Best Sliced Alphonso Mango\",\r\n"
				+ "      \"description\": \"The Alphonso mango is a seasonal fruit harvested from mid-April through the end of June. The time from flowering to harvest is about 90 days, while the time from harvest to ripening is about 15 days.The fruits generally weigh between 150 and 300 grams (5.3 and 10.6 oz), have a rich, creamy, tender texture and delicate, non-fibrous, juicy pulp. As the fruit matures, the skin of an Alphonso mango turns golden-yellow with a tinge of red across the top of the fruit\",\r\n"
				+ "      \"image_url\": \"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\",\r\n"
				+ "      \"rate\": 1,\r\n" + "      \"quantity\": \"5\",\r\n"
				+ "      \"amount_before_tax\": \"2100.00\",\r\n" + "      \"tax\": \"105.00\",\r\n"
				+ "      \"total_amount\": \"2205.00\"\r\n" + "    }\r\n" + "  },\r\n"
				+ "  \"custom_attributes\": {\r\n" + "      \"name\": \"Diana\",\r\n"
				+ "    \"place\": \"Themyscira\",\r\n" + "    \"animal\": \"Jumpa\",\r\n"
				+ "    \"thing\": \"Tiara\"\r\n" + "  }\r\n" + "}";

		Response gk1 = given().header("Authorization", bearertoken).body(createorderresponsebody)
				.contentType(ContentType.JSON).log().all().post("/api/v3/create-order");
		gk1.then().log().all();
		String ordrid = gk1.jsonPath().get("order_id");
		String usertoken = gk1.jsonPath().get("user.token");
		given().auth();

		System.out.println("*************************Initiate Payment POST Request******************************");
		// Initiate Payment POST Request
		LinkedHashMap<String, String> initiatePaymentHeader = new LinkedHashMap<String, String>();
		initiatePaymentHeader.put("Authorization", "Bearer" + bearertoken);
		initiatePaymentHeader.put("x-nimbbl-user-token", usertoken);
		String initiatePaymentRequestBody = "{\r\n" + "  \"order_id\": \"" + orderId + "\",\r\n"
				+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
				+ "  \"payment_mode_code\": \"net_banking\",\r\n" + "  \"bank_code\": \"hdfc\"\r\n" + "}";
		Response initiatePaymentResponseBody = given().headers(initiatePaymentHeader).body(initiatePaymentRequestBody)
				.contentType(ContentType.JSON).post("/api/v3/initiate-payment");
		initiatePaymentResponseBody.then().log().all();
		String redirectUrl = initiatePaymentResponseBody.jsonPath().get("next[0].url");
		String transactionId = initiatePaymentResponseBody.jsonPath().get("transaction_id");

		System.out.println("Transaction ID:" + transactionId);
		System.out.println("Redirect URL:" + redirectUrl);

		System.out.println("******************************WEBHOOK payment confirmation**************");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(redirectUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("payu");
		driver.findElement(By.id("password")).sendKeys("payu");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("*****************************Transaction Enquiry POST Request*********************");
		LinkedHashMap<String, String> transactionEnquiryHeader = new LinkedHashMap<String, String>();
		transactionEnquiryHeader.put("Authorization", "Bearer" + bearertoken);
		transactionEnquiryHeader.put("x-nimbbl-user-token", usertoken);
		String transactionEnquiryRequestBody = "{\r\n" + "  \"transaction_id\": \"" + transactionId + "\",\r\n"
				+ "  \"order_id\": \"" + ordrid + "\",\r\n" + "  \"invoice_id\": \"" + invoiceid + "\"\r\n" + "}";
		Response transactionEnquiryResponseBody = given().headers(transactionEnquiryHeader)
				.body(transactionEnquiryRequestBody).contentType(ContentType.JSON).log().all().when()
				.post("/api/v3/transaction-enquiry");
		transactionEnquiryResponseBody.then().log().all();
		String orderStatus = transactionEnquiryResponseBody.jsonPath().get("order.status");

		// Print Order Status
		System.out.println("Order status:" + orderStatus);

	}

}

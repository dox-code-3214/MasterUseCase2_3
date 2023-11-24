package com.sdetlabs.masterusecase2.mcu2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;


public class RestfulWS {

	static int StatusCode;
//	private String baseURI;
	private final static String restapi = "https://jsonplaceholder.typicode.com";
	@BeforeTest
	public static void setup() {
		RestAssured.baseURI = RestfulWS.restapi;
		RestAssured.given();
	}

	@Test(groups = "BaseTest")
	public static  int testResponseCode() {
		StatusCode = RestAssured.given().when().get(restapi).getStatusCode();
		return StatusCode;
//		assertEquals(RestAssured.given().when().get(restapi).getStatusCode(), 200);
	}

	@Test
	public static int PostRequestStatusCode() {
		String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

		StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when()
				.post("/posts").getStatusCode();
		return StatusCode;
	}

	@Test
	public static int PutRequestStatusCode() {
		String requestBody = "{ \"id\": 1, \"title\": \"updated foo\", \"body\": \"updated bar\", \"userId\": 1 }";

		StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when()
				.put("/posts/1").getStatusCode();
		return StatusCode;
	}

	@Test
	public static int PatchRequestStatusCode() {
		String requestBody = "{ \"title\": \"patched foo\" }";

		StatusCode = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when()
				.patch("/posts/1").getStatusCode();
		return StatusCode;
	}

	@Test
	public static int DeleteRequestStatusCode() {
		StatusCode = RestAssured.given().when().delete("/posts/1").getStatusCode();
		return StatusCode;
	}
}

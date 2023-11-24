package com.sdetlabs.masterusecase2.mcu2;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestfulWS_Test {

	@BeforeTest
	  public static void beforeTest() {
//		  RestfulWS restfulWS = new RestfulWS();
		  RestfulWS.setup();
	  }

	  @Test
	  public static void GetRequestTest() {
		  Assert.assertEquals(RestfulWS.testResponseCode(),200);
	  }

	  @Test
	  public void PatchRequestTest() {
		  Assert.assertEquals(RestfulWS.PatchRequestStatusCode(),200);
	  }

	  @Test
	  public void PostRequestTest() {
		  Assert.assertEquals(RestfulWS.PostRequestStatusCode(),201);
	  }

	  @Test
	  public void PutRequestTest() {
		  Assert.assertEquals(RestfulWS.PutRequestStatusCode(),200);
	  }
	  
	  @Test
	  public void DeleteRequestTest() {
		  Assert.assertEquals(RestfulWS.DeleteRequestStatusCode(),200);
	  }

}

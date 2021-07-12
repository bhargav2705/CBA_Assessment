package StepDefinitions;

import static org.testng.Assert.assertEquals;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusableMethods.HeadersList;
import reusableMethods.Payload;

public class PostUser {

	 private Scenario scenario;
     private Response response;
	private  String endpoint;
	
	@Before
	public void before(Scenario scenario)
	{
	 this.scenario=scenario;
	}

	
	@Then("^I run the POST user request with the details$")
	public void i_run_the_POST_user_request_with_the_details() throws Throwable {
	    
	response=(Response) RestAssured.
			given().headers(HeadersList.getMultipleHeaders())
			.when().body(Payload.postBody()).post("https://supervillain.herokuapp.com/v1/user")
			.then().log().all()
			.extract();
	
	
	}

	@And("^I verify the response code$")
	public void i_verify_the_response_c() throws Throwable
	{
		
	    scenario.write("status code is :" +response.getStatusCode());
	    if(response.getStatusCode()==201)
	    {
	    
	   scenario.write("status is:" +response.jsonPath().get("status")+ "message is:" +response.jsonPath().get("message"));
	  
       assertEquals(response.jsonPath().get("message:"),"User added.");

	    }
	    
	
	    else {
	    	
	    	scenario.write("Invalid Request: status code is:"+response.getStatusCode());
	    }

	}
}

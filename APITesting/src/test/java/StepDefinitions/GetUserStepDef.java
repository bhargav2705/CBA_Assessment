package StepDefinitions;



import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusableMethods.HeadersList;

public class GetUserStepDef {

	
	 private Scenario scenario;
     private Response response;
	private  String endpoint;
	
	@Before
	public void before(Scenario scenario)
	{
	 this.scenario=scenario;
	}
	
	@Given("^I have the URI and other information$")
	public void i_have_the_URI_and_other_information() throws Throwable {
	    
		endpoint="https://supervillain.herokuapp.com/v1/user";
		
	}

	@Then("^I run the GET user request with the details$")
	public void i_run_the_GET_user_request_with_the_details() throws Throwable {
	    
	response=(Response) RestAssured.
			given().headers(HeadersList.getMultipleHeaders())
			.when().get("https://supervillain.herokuapp.com/v1/user")
			.then().log().all()
			.extract();
	
	
	}

	@And("^I verify the response contains list of users$")
	public void i_verify_the_response_c() throws Throwable
	{
		
	    scenario.write("status code is :" +response.getStatusCode());
	    if(response.getStatusCode()==200)
	    {
	    
	   scenario.write("response is:" +response.jsonPath().get("username:")+ "score is:" +response.jsonPath().get("score:"));
	}
	    
	
	    else {
	    	
	    	scenario.write("Invalid Request: status code is:"+response.getStatusCode());
	    }

	}
}

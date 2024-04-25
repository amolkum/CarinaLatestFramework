//package com.qapropsoft.carina.demo;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.requestSpecification;
//import static io.restassured.RestAssured.responseSpecification;
//
//import java.io.File;
//
//import org.testng.Assert;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
//import utils.ApiHelper;
//
//public class APIBasicTest {
//
//	public Response response;
//	public Scenario scenario;
//	long petID;
//
//	@Given("Get the API Base URI")
//	public void get_the_api_base_uri() {
//		ApiHelper.reqResBuilder();
//	}
//
//	@Given("Get call to url test the API")
//	public void get_call_to_https_reqres_in_api_users_page() {
//		System.out.println("Start1--------------");
//
//		System.out.println("Get resquest - check response by status");
//		Response response = given().spec(requestSpecification).expect().spec(responseSpecification).when()
//				.get("/v2/pet/findByStatus?status=pending");
//
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200, "Correct status code returned");
//
//		System.out.println("1----------------------------------get response ended");
//	}
//
//	@Then("Response code is storing PostPet")
//	public void response_code_is() {
//		System.out.println("-------------Test 2 Post pet ------------");
//		System.out.println("Post request - Send the post request to the API");
//
//		Response response = given().spec(requestSpecification).header("accept", "application/json")
//				.body(new File("./payload.json")).expect().spec(responseSpecification).when().post("/v2/pet");
//
//		petID = response.path("id");
//		System.out.println("Newly created pet ID: " + petID);
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200, "Correct status code returned");
//		System.out.println("2------------------------post request submited successfully ended");
//
//	}
//
//	@And("Update pet details PutPet")
//	public void update_pet_details_put_pet() {
//		System.out.println("-------------Test 3 put pet ------------");
//		System.out.println("PUT - update the pet details by petID");
//
//		String jsonBody = ApiHelper.buildJsonBody(petID);
//
//		Response response = given().spec(requestSpecification).header("accept", "application/json")
//
//				.body(jsonBody).expect().spec(responseSpecification).when().put("/v2/pet/");
//
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200, "Correct status code returned");
//		System.out.println("3rd -------------------------end");
//
//	}
//
//	@And("Update pet details PostUpdate")
//	public void update_pet_details_post_update() {
//		System.out.println("Start4--------------");
//		System.out.println("----------Patch Update---------");
//		System.out.println("patch - update the specific parameters by petID");
//
//		Response response = given().spec(requestSpecification)
//				.header("Content-Type", "application/x-www-form-urlencoded").formParam("name", "DogUpdated")
//				.formParam("status", "sold").expect().spec(responseSpecification).when().post("/v2/pet/" + petID);
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200, "Correct status code returned");
//		System.out.println("4th -------------------end");
//	}
//
//	@Then("Delete the pet DeletePet")
//	public void delete_the_pet_delete_pet() {
//		System.out.println("Start5--------------");
//		System.out.println("---------Delete---------------");
//		System.out.println("delete the response by the petID");
//
//		Response response = given().spec(requestSpecification).expect().spec(responseSpecification).when()
//				.delete("/v2/pet/" + petID);
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200, "Correct status code returned");
//		System.out.println("5th ---------------------end");
//	}
//}

package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPagePage(Integer page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list users")
    public void sendReqGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body name should be {string} and job is {string}")
    public void statusCodeShouldBeJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @Given("Update user with valid json and parameter id <id1{id}>") // disini
    public void updateUserWithValidJsonAndParameterIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        reqresAPI.putUpdateUser(id, jsonReq);
    }

    @When("Send Request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("Status code should {int} OK")
    public void statusCodeShouldOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body name should be {string} job is {string}")
    public void responseBodyNameShouldBeJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @Given("Delete user with valid id {id}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


    @And("Status code should bex <id_number> OK")
    public void statusCodeShouldBexId_numberOK() {

    }


    @Given("Update user with valid json and parameter id <id_number>")
    public void updateUserWithValidJsonAndParameterIdId_number() {
        System.console();
    }
}

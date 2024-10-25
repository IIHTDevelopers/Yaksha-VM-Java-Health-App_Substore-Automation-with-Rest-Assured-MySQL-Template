package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import pages.StartupPage;
import pages.substore_page;
import testBase.AppTestBase;
import testBase.UserActions;
import testdata.LocatorsFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreUtilities.utils.FileOperations;
import io.restassured.response.Response;
import testBase.AppTestBase;

public class substore_testcase extends AppTestBase {

	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.xlsx";
	String loginFilePath = loginDataFilePath + "Login.xlsx";
	StartupPage startupPage;
	String randomInvoiceNumber;
	LocatorsFactory locatorsFactoryInstance;
	UserActions userActionsInstance;
	substore_page substorePageInstance;
	
	private final String FILEPATH = "src/main/java/pages/substore_page.java";

	@Parameters({ "browser", "environment" })
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readExcelPOI(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);

		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl,
				configData.get("url") + " might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}

	@Test(priority = 1, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the healthapp section\n"
					+ "1. Login in the healthapp application\n" + "2. Scroll down menu till Substore\n"
					+ "3. Click on the Substore" + "4. SubStore module should be present")

	public void verifySubstoreCounterSubModule() throws Exception {
		substorePageInstance = new substore_page(driver);

		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");
		Map<String, String> loginData = new FileOperations().readExcelPOI(loginFilePath, "credentials");

		Assert.assertTrue(substorePageInstance.loginToHealthAppByGivenValidCredetial(loginData),
				"Login failed, Invalid credentials ! Please check manually");
		Assert.assertTrue(substorePageInstance.scrollDownAndClickSubstoreTab());
		System.out.println("Substore Page url : " + substoreExpectedData.get("URL"));
		Assert.assertEquals(substorePageInstance.verifySubstorePageUrl(), substoreExpectedData.get("URL"));
	}

	@Test(priority = 2, groups = { "sanity" }, description = "1. Login in the healthapp application\r\n"
			+ "2. Click on the substore \r\n" + "3. \"Select your Substore\" pop up "
			+ "4. Expected value that should be present in \"Select your Substore\" modal\r\n"
			+ "Expected sub-modals button:  Accounts,male ward SubStore,SubStore1,SubStore1")

	public void verifySubstoreSubModules() {
		try {
			substorePageInstance = new substore_page(driver);

			Assert.assertTrue(substorePageInstance.clickFourthCounterIfAvailable());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3, groups = {
			"sanity" }, description = "Precondition: User should be logged in and on the Verification section\\n\"\r\n"
					+ "	+ \"1. Click on the Inventory Module\r\n"
					+ "	+ \"2. Hover over on module signout button and get text"
					+ "3. Verify text To change, you can always click here.")

	public void verifySubstoreModule() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");
		Assert.assertTrue(substorePageInstance.verifyModuleSignoutHoverText(substoreExpectedData));
	}

	@Test(priority = 4, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on SubStore module\r\n"
					+ "1. Login in the healthapp application\r\n" + "2. Click on the Substore\r\n"
					+ "3. \"Select your Substore\" pop up \r\n" + "4. Click on \"Account\" sub-modal\r\n"
					+ "5. Click on the \"Inventory\" sub-module\r\n" + "6. Click on\" Pharmacy\" sub-module\r\n"
					+ "7. All sub-modules should be displayed correctly.\r\n"
					+ "8. Expected Sub modules are : Pharmacy, Inventory")

	public void verifySubstoreSubModule() throws Exception {
		substorePageInstance = new substore_page(driver);

		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertTrue(substorePageInstance.verifySubstoreSubModule(substoreExpectedData));
	}

	@Test(priority = 5, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on SubStore module\r\n"
					+ "1. Click on the SubStore Module drop-down arrow   \r\n"
					+ "2. Click on Inventory module. Expected Sub modules are : Stock, Inventory Requisition, Consumption, Reports, Patient Consumption,Return")

	public void verifyAllSubstoreModulesAreDisplayedInSublist() throws Exception {
		substorePageInstance = new substore_page(driver);

		Assert.assertTrue(substorePageInstance.subModulePresent("Inventory"));
	}

	@Test(priority = 6, groups = { "sanity" }, description = "Pre condition: User should be logged in \r\n"
			+ "1. Click on the Substore Module drop-down arrow" + "2. Verify navigation between sub-modules")

	public void verifyNavigationBetweenSubmodules() throws Exception {

		substorePageInstance = new substore_page(driver);
		Assert.assertTrue(substorePageInstance.verifyNavigationBetweenSubmodules());
	}

	@Test(priority = 7, groups = { "sanity" }, description = "Under Substore module > INventory Section\"\r\n"
			+ "			+ \"Take the screenshot of the current page")
	public void takingScreenshotOfCurrentPage() throws Exception {
		substorePageInstance = new substore_page(driver);
		Assert.assertTrue(substorePageInstance.takingScreenshotOfTheCurrentPage());
	}

	@Test(priority = 8, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on SubStore module\r\n"
					+ "1. Click on the SubStore module drop-down arrow \r\n" + "2. Click on Inventory sub-module\r\n"
					+ "3. Click on Inventory Requisition section")

	public void verifyInventoryRequisitionSection() throws Exception {

		Assert.assertTrue(substorePageInstance.verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot());
	}

	@Test(priority = 9, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Click on \"Inventory Requisition\" section\r\n"
					+ "2. Click on \"Create Requisition\" button\r\n"
					+ "3. Click on \"Target Inventory \" field and Select \"GENERAL-INVENTORY\" option\r\n"
					+ "4. Click on \"Item Category\" drop down and select \" Consumables\"  option\r\n"
					+ "5. Enter \"tissue\" in ItemName field\r\n" + "6. Enter the \"Required Quantity\" field \r\n"
					+ "7. Click on \"Request\" button\r\n" + "8. Click on \"Close\" icon\r\n"
					+ "9. Verify popup message Requisition is Generated and Saved")

	public void verifyCreateRequisitionButton() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertEquals(substorePageInstance.verifyCreateRequisitionButton(),
				substoreExpectedData.get("requisitionGenerationMsg"));
	}

	@Test(priority = 10, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory Sub-module\r\n"
					+ "1. Navigate to \"Inventory Requisition\" section\r\n"
					+ "2. Click on the \"From\" date and select the \"Jan 2022\" date\r\n"
					+ "3. Click on the \"To\" date and Select \"Current date\" \r\n" + "4. Click on \"OK\" button\r\n"
					+ "5. The 'Date' column date must fall within the selected date ")
	public void verifyDateRangeFilterFunctionality() throws Exception {
		substorePageInstance = new substore_page(driver);
		userActionsInstance = new UserActions(driver);

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = currentDate.format(formatter);

		userActionsInstance.click(substorePageInstance.getAnchorTagLocatorByText("Inventory Requisition"));
		substorePageInstance.applyDateFilter("01-01-2022", toDate);
		Thread.sleep(3000);
		substorePageInstance.verifyRequisitionDatesAsPerTheDateRange("01-01-2022", toDate);
	}

	@Test(priority = 11, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module > List Request section \r\n"
					+ "1. Click on the data range button. \r\n" + "2. select \"one week\" option from the drop down.")

	public void VerifyDateRangeButton() throws Exception {
		substorePageInstance = new substore_page(driver);

		Assert.assertTrue(substorePageInstance.VerifyDateRangeButton());
	}

	@Test(priority = 12, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Navigate to \"Inventory Requisition\" section\r\n" + "2. Select option ar per the choice")
	public void verifyFilterByStoreFunctionality() throws Exception {
		substorePageInstance = new substore_page(driver);
		Assert.assertTrue(substorePageInstance.verifyFilterByStoreFunctionality());
	}

	@Test(priority = 13, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Naviaget to \"Inventory Requisition\" section\r\n" + "2. Select \"Pending\" radio button\r\n"
					+ "3. Select \"Complete\" radio button\r\n" + "4. Select \"Canceled\" radio button\r\n"
					+ "5. Select \"Withdrawn\" radio button\r\n" + "6. Select \"All\" radio button\r\n"
					+ "7. Ensure that all radio buttons in the \"List by Requisition Status\" field are functional and clickable.")

	public void verifyInventoryRequisitionRadioButtonSection() throws Exception {
		substorePageInstance = new substore_page(driver);
		Assert.assertTrue(substorePageInstance.verifyInventoryRequisitionRadioButtonSection());
	}

	@Test(priority = 14, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Naviagte to the \"Inventory Requisition\" section\r\n"
					+ "2. Click on \"all\" radio button\r\n" + "3. Enter the pending keyword in the search bar.\r\n"
					+ "4. Record should be present as per the entered keyword")

	public void verifyRecordsAreFilteredAccordingToSearchData() throws Exception {
		substorePageInstance = new substore_page(driver);

		Assert.assertTrue(substorePageInstance.verifyRecordsAreFilteredAccordingToSearchData());
	}

	@Test(priority = 15, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module > List Request section \r\n"
					+ "1. Navigate to \" Inventory Requisition\" section \r\n"
					+ "2.  Click on \"View\" button of the specfic record.\r\n"
					+ "3. Click on \"Close\" icon button\r\n"
					+ "4. After Clicking \"View\" button, \"REQUISITION DETAILS PRINT\" page should pop up and by Clicking on close icon, user should navigate back to the Inventory Requisition page ")

	public void verifyPrintModalIsOpenedIfUserSelectsViewButton() throws Exception {
		substorePageInstance = new substore_page(driver);

		Assert.assertTrue(substorePageInstance.verifyPrintModalIsOpenedIfUserSelectsViewButton());
	}

	@Test(priority = 16, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Navigate to the \"Inventory Requisition\" section\r\n"
					+ "2. Click on \"...\" drop down of the specfic record\r\n"
					+ "3.  Select  \"create copy\" from drop down")
	public void verifyPendingRecordCanBeCopied() throws Exception {

		substorePageInstance = new substore_page(driver);
		Assert.assertTrue(substorePageInstance.verifyPendingRecordCanBeCopied());
	}

	@Test(priority = 17, groups = { "sanity" }, description = "Pre condition: User should be logged in \r\n"
			+ "1. Navigate to the \"Inventory\" module\r\n" + "2. Navigate to \"Internal\" sub-module \r\n"
			+ "3. Navigate to \"Requisition\" section\r\n" + "4. Click on \"Direct Dispatch\" button\r\n"
			+ "5. Enter all the required field \r\n"
			+ "( Store -> (it should match with current store of substore module), ItemCategory, ItemName , Dispatched Qty, Remark)\r\n"
			+ "6. Click on the \"Direct Dispatch\" button\r\n" + "7. Click on \"Close\" icon \r\n"
			+ "8. Navigate to \"Substore\" module and click on \"Accounts\" sub-modal\r\n"
			+ "9. Navigate to \"Inventory Requisition\" section of \"Inventory\" sub-module \r\n"
			+ "10. Click on \"Receive item\" of the specfic record\r\n" + "11. Click on the \"Recevie\" butotn\r\n"
			+ "12. Click on  \"Back to Requisition List\" button"
			+ "13. After clicking the \"Receive\" button, the remarks field should disappear, and a success message should appear: \"Success: Items Received Successfully. Stock Updated.\"\r\n")
	public void verifyInventoryModule() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertEquals(substorePageInstance.verifyInventoryModule(),
				substoreExpectedData.get("requisitionGenerationMsg"));
		Assert.assertTrue(substorePageInstance.scrollDownAndClickSubstoreTab());
		Assert.assertEquals(
				substorePageInstance
						.verifyReceiveitemsButtonFunctionality(substoreExpectedData.get("itemsReceivedSuccessMsg")),
				substoreExpectedData.get("itemsReceivedSuccessMsg"));
	}

	@Test(priority = 18, groups = { "sanity" }, description = "Pre condition: User should be logged in\r\n"
			+ "1. Navigate to the \"Inventory\" module\r\n" + "2. Navigate to \"Internal\" sub-module \r\n"
			+ "3. Navigate to \"Requisition\" section\r\n" + "4. Click on \"Direct Dispatch\" button\r\n"
			+ "5. Enter all the required field \r\n"
			+ "( Store -> (it should match with current store of substore module), ItemCategory, ItemName , Dispatched Qty, Remark)\r\n"
			+ "6. Click on the \"Direct Dispatch\" button\r\n" + "7. Click on \"Close\" icon \r\n"
			+ "8. Navigate to \"Substore\" module and click on \"Accounts\" sub-modal\r\n"
			+ "9. Navigate to \"Inventory Requisition\" section of \"Inventory\" sub-module \r\n"
			+ "10. Click on \"Receive item\" of the specfic record\r\n" + "11. Click on the \"Recevie\" butotn\r\n"
			+ "12. Click on  \"Back to Requisition List\" button\r\n" + "13. Navigate to the \"Stock\"section\r\n"
			+ "14. Verify that the available quantity of items has increased in the stock.")
	public void verifyInventoryandStockModule() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertEquals(substorePageInstance.verifyInventoryModule(),
				substoreExpectedData.get("requisitionGenerationMsg"));
		Assert.assertTrue(substorePageInstance.scrollDownAndClickSubstoreTab());
		Assert.assertTrue(substorePageInstance.getSubCategoryAvailabilityCount());
		Assert.assertEquals(
				substorePageInstance
						.verifyReceiveitemsButtonFunctionality(substoreExpectedData.get("itemsReceivedSuccessMsg")),
				substoreExpectedData.get("itemsReceivedSuccessMsg"));
		Assert.assertTrue(substorePageInstance.verifyAvailableQtyCountIsIncreasedInStocks());
	}

	@Test(priority = 19, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on  Substore module\r\n"
					+ "1. Naviagte to the \"Consumption\" section of the \"Inventory\" sub-module\r\n"
					+ "2. Click on \"New Consumption\" \r\n" + "3. Enter all the required field \r\n"
					+ "(Consumption Date ,Item Name,Consumed Qty)\r\n" + "4. Click on \"Save\" button\r\n"
					+ "5. Upon clicking the \"Save\" button, a success message saying \"Consumption completed\" should be displayed, and the data should be accurately reflected in the record.")
	public void verifyConsumptionCreationModule() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertTrue(substorePageInstance.scrollDownAndClickSubstoreTab());
		Assert.assertEquals(
				substorePageInstance
						.verifyConsumptionCreationModule(substoreExpectedData.get("consumptioCompletedMsg")),
				substoreExpectedData.get("consumptioCompletedMsg"));
	}

	@Test(priority = 20, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on  Substore module\r\n"
					+ "1. Naviagte to the \"Reports\" section of the \"Inventory\" sub-module\r\n"
					+ "2. Navigate to \"Consumption Report\" sub-modal \r\n"
					+ "3. Enter all the \"From\" and \"To\" field \r\n" + "4. Click on \"Show Report\" button\r\n"
					+ "5. The 'Date' column data must align with the selected option from the dropdown, and it should display records added in the \"Consumption\" section for that specific date.")
	public void verifyReportModule() throws Exception {
		substorePageInstance = new substore_page(driver);

		Assert.assertTrue(substorePageInstance.verifyReportModule());
	}

	@Test(priority = 21, groups = {
			"sanity" }, description = "Pre condition: User should be logged in and it is on Inventory sub-module\r\n"
					+ "1. Naviagte to the \"Return\" section\r\n" + "2. Click on \"Return Items\" buton\r\n"
					+ "3. Click on \"Return\" button\r\n"
					+ "4. After clicking the \"Return\" button, a error message stating \"Please select inventory for return\" should be displayed. Ensure that the entered data is visible in the \"Return\" section of the \"Inventory\" sub-module.")
	public void verifyReturnModuleErrorMessage() throws Exception {
		substorePageInstance = new substore_page(driver);
		Map<String, String> substoreExpectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "substore");

		Assert.assertEquals(substorePageInstance.verifyReturnModuleErrorMessage(substoreExpectedData.get("returnErrorMessage")),
				substoreExpectedData.get("returnErrorMessage"));

	}
	
	@Test(priority = 22, groups = { "sanity" }, description = "Precondition: Access to JSONPlaceholder API\n"
			+ "1. Send GET request to retrieve post by ID\n" + "2. Verify the response status code is 200\n"
			+ "3. Validate the response body contains the expected post data")
	public void verifyGetPostById() throws IOException {

		// Expected data
		Map<String, Object> expectedData = new HashMap<>();
		expectedData.put("id", 1);
		expectedData.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		expectedData.put("body", "quia et suscipit\n" + "suscipit repellat nihil non omnis\n"
				+ "occaecati quisquam qui autem\n" + "magni et impedit vero fugiat");
		expectedData.put("userId", 1);

		substorePageInstance = new substore_page(driver);
		// Perform GET request
		Response response = substorePageInstance.getPostById(1);
		int responseStatusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		// Validate method's source code
		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getPostById",
				List.of("given", "when", "get", "then", "extract", "response"));

		// Expected endpoint and response for RestAssuredValidator
		String endpoint = "https://jsonplaceholder.typicode.com/posts/1";
		int expectedStatusCode = 200;
		String expectedResponseBody = "{" + "\"userId\": 1," + "\"id\": 1,"
				+ "\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\","
				+ "\"body\": \"quia et suscipit\\n" + "suscipit repellat nihil non omnis\\n"
				+ "occaecati quisquam qui autem\\n" + "magni et impedit vero fugiat\"" + "}";

		String validatedResponse = RestAssuredValidator.validateGetRequest(endpoint, expectedStatusCode,
				expectedResponseBody);

		Assert.assertEquals(isValidationSuccessful
				&& expectedResponseBody.substring(1, 15).contains(validatedResponse.substring(5, 15))
				&& responseStatusCode == 200 && responseBody.contains("\"id\": 1"), true);

	}
	


	@Test(priority = 24, groups = { "sanity" }, description = "Precondition: Access to JSONPlaceholder API\n"
			+ "1. Send PUT request to update an existing post\n" + "2. Verify the response status code is 200\n"
			+ "3. Validate the response body contains the updated post data")
	public void verifyUpdatePost() {

		// Data for updating the post
		int postId = 1;
		String updatedTitle = "Updated Post Title";
		String updatedBody = "This is the updated body of the post.";
		int userId = 1;

		// Instantiate RestAssuredUtils
		substorePageInstance = new substore_page(driver);

		// Perform PUT request using the updatePost() method from RestAssuredUtils
		Response response = substorePageInstance.updatePost(postId, updatedTitle, updatedBody, userId);

		// Extract status code and response body
		int responseStatusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		// Validate status code is 200
		Assert.assertEquals(responseStatusCode, 200, "Expected status code 200 but got " + responseStatusCode);

		// Perform field-level validation using assertTrue
		Assert.assertTrue(
				responseBody.contains("\"title\": \"" + updatedTitle + "\"")
						&& responseBody.contains("\"body\": \"" + updatedBody + "\"")
						&& responseBody.contains("\"userId\": " + userId) && responseBody.contains("\"id\": " + postId),
				"The response does not match the expected updated post data.");
	}

	@Test(priority = 25, groups = { "sanity" }, description = "Precondition: Access to JSONPlaceholder API\n"
			+ "1. Send DELETE request to delete an existing post by ID\n"
			+ "2. Verify the response status code is 200 or 204\n"
			+ "3. Ensure the post is deleted by verifying a GET request returns 404")
	public void verifyDeletePost() {

		// ID of the post to delete
		int postId = 1;

		// Perform DELETE request to remove the post
		substorePageInstance = new substore_page(driver);
		Response deleteResponse = substorePageInstance.deletePost(postId);

		// Verify the status code of the DELETE response (can be 200 or 204 depending on
		// API design)
		int deleteStatusCode = deleteResponse.getStatusCode();
		System.out.println(deleteStatusCode);
		Assert.assertTrue(deleteStatusCode == 200 || deleteStatusCode == 204,
				"Expected status code 200 or 204, but got " + deleteStatusCode);
	}

	@Test(priority = 26, groups = { "sanity" }, description = "Precondition: Access to JSONPlaceholder API\n"
			+ "1. Send GET request to retrieve comments for a post by postId\n"
			+ "2. Verify the response status code is 200\n" + "3. Validate that the response contains comments data")
	public void verifyGetCommentsForPost() {

		// ID of the post for which we want to retrieve comments
		int postId = 1;

		// Perform GET request to retrieve the comments for the post
		substorePageInstance = new substore_page(driver);
		Response getCommentsResponse = substorePageInstance.getCommentsForPost(postId);

		// Verify the status code of the GET response (should be 200 OK)
		int responseStatusCode = getCommentsResponse.getStatusCode();

		// Verify that the response body contains comments (we expect an array of
		// comments)
		String responseBody = getCommentsResponse.getBody().asString();
		Assert.assertTrue(
				responseStatusCode == 200 && responseBody.contains("id") && responseBody.contains("postId")
						&& responseBody.contains("name") && responseBody.contains("body"),
				"The response does not contain expected comments data.");
	}
	


	
	

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}

	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}

}

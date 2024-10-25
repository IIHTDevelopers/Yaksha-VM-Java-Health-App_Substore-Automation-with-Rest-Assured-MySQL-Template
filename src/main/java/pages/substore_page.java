package pages;

import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


import coreUtilities.utils.FileOperations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class substore_page extends StartupPage {
	
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
	private static final String EXCEL_FILE_PATH = "src/main/resources/config.xlsx"; // Path to the Excel file
	private static final String SHEET_NAME = "PostData"; // Sheet name to read data from

	public substore_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath(" ");
	}





	/**
	 * @Test1.1 about this method loginTohealthAppByGivenValidCredetial()
	 * 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in
	 *              button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**
	 * @Test1.2 @Test17.2 @Test18.2 @Test19.1 about this method
	 * scrollDownAndClickMaternityTab()
	 * 
	 * @param : null
	 * @description : verify the Substore tab, scroll to it, and click it
	 * @return : String
	 * @author : YAKSHA
	 */
	public boolean scrollDownAndClickSubstoreTab() throws Exception {
		return false;
	}

	/**
	 * @Test1.3 about this method verifyVerificationPageUrl()
	 * 
	 * @param : null
	 * @description : verify verification page url
	 * @return : String
	 * @author : YAKSHA
	 */

	public String verifySubstorePageUrl() throws Exception {
		return null;
	}

	/**
	 * @Test2 about this method clickFirstCounterIfAvailable
	 * 
	 * @param : null
	 * @description : Clicks Counter modules
	 * @return : Boolean
	 * @throws : YAKSHA
	 */
	public boolean clickFourthCounterIfAvailable() throws Exception {
		return false;
	}

	/**
	 * @Test3 about this method verifyModuleSignoutHoverText()
	 * @param substoreExpectedData : Map<String, String> - Contains expected hover
	 *                             text
	 * @description : This method verifies that the hover text on the "Sign Out"
	 *              module matches the expected value.
	 * @return : boolean - true if the hover text matches the expected value, false
	 *         otherwise.
	 * @throws : Exception - if there is an issue finding the hover text or any
	 *           other operation.
	 * @author : YAKSHA
	 */
	public boolean verifyModuleSignoutHoverText(Map<String, String> substoreExpectedData) throws Exception {
		return false;
	}

	/**
	 * @Test4 about this method verifySubstoreSubModule()
	 * @param substoreExpectedData : Map<String, String> - A map containing expected
	 *                             substore data, such as URLs or other related
	 *                             information.
	 * @description : This method verifies that the substore module's sub-modules
	 *              (e.g., Inventory, Pharmacy) are visible and interactable.
	 * @return : boolean - true if the sub-modules are visible and clickable, false
	 *         otherwise.
	 * @throws : Exception - if there is an issue finding or interacting with the
	 *           sub-modules.
	 * @author : YAKSHA
	 */
	public boolean verifySubstoreSubModule(Map<String, String> substoreExpectedData) throws Exception {
		return false;
	}

	/**
	 * @Test5 about this method subModulePresent()
	 * 
	 * @param moduleName : String - The name of the module to verify.
	 * @description : This method verifies if the specified module's sub-modules are
	 *              present and visible.
	 * @return : boolean - true if the sub-modules are displayed, false otherwise.
	 * @throws : Exception - if there is an issue finding the sub-modules or if no
	 *           elements are found.
	 * @author : YAKSHA
	 */
	public boolean subModulePresent(String moduleName) throws Exception {
		return false;
	}

	/**
	 * @Test6 about this method verifyNavigationBetweenSubmodules()
	 * 
	 * @param : null
	 * @description : This method verifies that the user is able to navigate between
	 *              the sub modules.
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean verifyNavigationBetweenSubmodules() throws Exception {
		return false;
	}

	/**
	 * @Test7 about this method takingScreenshotOfTheCurrentPage()
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		return false;
	}

	/**
	 * @Test8 about this method
	 *        verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot()
	 * 
	 * @param : null
	 * @description : This method verifies the visibility of various UI components
	 *              on the page, including buttons, input fields, dropdowns, and
	 *              checkboxes.
	 * @return : boolean - Returns true if all specified UI components are
	 *         displayed, otherwise false.
	 * @throws : Exception - if there is an issue finding any of the UI components.
	 * @author : YAKSHA
	 */
	public boolean verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot() throws Exception {
		return false;
	}

	/**
	 * @Test9 about this method verifyCreateRequisitionButton()
	 * 
	 * @param : null
	 * @description : This method verifies that the user is able to click the
	 *              Requisition Button.
	 * @return : String - The success message if the requisition is created
	 *         successfully.
	 * @author : YAKSHA
	 */
	public String verifyCreateRequisitionButton() throws Exception {
		return null;
	}

	/**
	 * @Test10.1 about this method applyDateFilter()
	 *
	 * @param : String, String
	 * @description : Applies the date filter with date range
	 * @return : void
	 * @throws : Exception - if there is an issue finding or filling the date fields
	 * @author : YAKSHA
	 */
	public boolean applyDateFilter(String fromDate, String toDate) throws Exception {
		return false;
	}

	/**
	 * @Test10.2 about this method verifyRequisitionDatesAsPerTheDateRange()
	 *
	 * @param : String fromDate, String toDate
	 * @description : Verifies that all requisition dates fall within the specified
	 *              date range.
	 * @return : boolean - true if all dates are within the range, false otherwise.
	 * @throws : Exception - if there is an issue finding or parsing the date
	 *           fields.
	 * @author : YAKSHA
	 */
	public boolean verifyRequisitionDatesAsPerTheDateRange(String fromDate, String toDate) throws Exception {
		return false;
	}

	/**
	 * @Test11.1 about this method VerifyDateRangeButton()
	 * 
	 * @param : null
	 * @description : This method verifies that the user is able to navigate between
	 *              range button
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean VerifyDateRangeButton() throws Exception {
		return false;
	}

	/**
	 * @Test12 about this method verifyFilterByStoreFunctionality()
	 * 
	 * @param : null
	 * @description : This method verifies that the user is able to filter by store
	 *              functionality. It selects "GENERAL-INVENTORY" from a dropdown
	 *              and checks that all elements in the "Requested To" column
	 *              contain "GENERAL-INVENTORY".
	 * @return : boolean - Returns true if the filter functionality works as
	 *         expected, otherwise returns false.
	 * @author : YAKSHA
	 */

	public boolean verifyFilterByStoreFunctionality() {
		return false;
	}

	/**
	 * @Test13 about this method verifyInventoryRequisitionRadioButtonSection()
	 * 
	 * @param : null
	 * @description : This method verifies that all radio buttons in the Inventory
	 *              Requisition section are clickable and visible. It ensures that
	 *              each radio button ("Pending", "Complete", "Cancelled",
	 *              "Withdrawn", "All") can be clicked and is displayed correctly.
	 * @return : boolean - Returns true if all radio buttons are clickable and
	 *         visible, otherwise returns false.
	 * @author : YAKSHA
	 * @throws Exception
	 */

	public boolean verifyInventoryRequisitionRadioButtonSection() throws Exception {
		return false;
	}

	/**
	 * @Test14 about this method verifyRecordsAreFilteredAccordingToSearchData()
	 * 
	 * @param : null
	 * @description : This method verifies that the records displayed on the page
	 *              are filtered according to the search keyword entered into the
	 *              search bar. Specifically, it checks that all records in the
	 *              "Status" column contain the keyword "pending" after the search.
	 * @return : boolean - Returns true if the records are filtered correctly,
	 *         otherwise returns false.
	 * @throws Exception
	 * @throws :         Exception if any error occurs during the verification
	 *                   process.
	 */
	public boolean verifyRecordsAreFilteredAccordingToSearchData() throws Exception {
		return false;
	}

	/**
	 * @Test15 about this method verifyPrintModalIsOpenedIfUserSelectsViewButton()
	 * 
	 * @param : null
	 * @description : This method verifies that the print modal is opened when the
	 *              user selects the "View" button from the dropdown. It also
	 *              verifies that the modal can be closed successfully.
	 * @return : boolean - Returns true if the print modal is opened upon clicking
	 *         the "View" button, otherwise returns false.
	 * @throws : Exception if any error occurs during the verification process.
	 */
	public boolean verifyPrintModalIsOpenedIfUserSelectsViewButton() throws Exception {
		return false;
	}

	/**
	 * @Test16 about this method verifyPendingRecordCanBeCopied()
	 * 
	 * @param : null
	 * @description : This method verifies that records with a status of "Pending"
	 *              can be copied in the Inventory Requisition section. It checks
	 *              that after selecting "Create Copy" from the dropdown, the copied
	 *              record retains the "Pending" status and that the user is
	 *              correctly navigated back to the Inventory Requisition page after
	 *              clicking the "Request" button.
	 * @return : boolean - Returns true if the record is copied successfully and the
	 *         user is navigated back to the Inventory Requisition page, otherwise
	 *         returns false.
	 * @throws : Exception if any error occurs during the verification process.
	 */
	public boolean verifyPendingRecordCanBeCopied() throws Exception {
		return false;
	}

	/**
	 * @Test17.1 @Test18.1 about this method verifyInventoryModule()
	 *
	 * @param : null
	 * @description : This method Verifies that presence of "Receive items" button
	 *              on inventory module.
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public String verifyInventoryModule() throws Exception {
		return null;
	}

	/**
	 * @Test17.3 @Test18.4 about this method verifyReceiveitemsButtonFunctionality()
	 * 
	 * @param : successMsg - The expected success message that should be displayed
	 *          after receiving items.
	 * @description : This method verifies the functionality of the "Receive Items"
	 *              button in the Inventory Requisition section. It ensures that
	 *              clicking the button processes the receipt of items and displays
	 *              the correct success message.
	 * @return : String - Returns the actual success message displayed after the
	 *         items are received.
	 * @throws : Exception if any error occurs during the verification process.
	 */
	public String verifyReceiveitemsButtonFunctionality(String successMsg) throws Exception {
		return null;
	}

	/**
	 * @Test18.3 about this method getSubCategoryAvailabilityCount()
	 * 
	 * @param : null
	 * @description : This method retrieves the available quantity of a specific
	 *              sub-category (in this case, "soap") from the inventory and
	 *              converts it from a String to an int for further processing.
	 * @return : boolean - Returns true if the operation is successful.
	 * @throws : Exception if any error occurs during the process.
	 */
	

	public boolean getSubCategoryAvailabilityCount() throws Exception {
		return false;
	}

	/**
	 * @Test18.5 about this method verifyAvailableQtyCountIsIncreasedInStocks()
	 * 
	 * @param : null
	 * @description : This method verifies that the available quantity of "soap" has
	 *              increased after performing a specific operation. It retrieves
	 *              the available quantity, compares it with a previously recorded
	 *              value, and returns true if the quantity has increased. Logs
	 *              details of the available quantity before and after the
	 *              operation.
	 * @return : boolean - Returns true if the available quantity increased after
	 *         the operation, otherwise returns false.
	 * @throws : Exception if an error occurs while retrieving, processing, or
	 *           comparing the available quantity.
	 */
	public boolean verifyAvailableQtyCountIsIncreasedInStocks() throws Exception {
		return false;
	}

	/**
	 * @Test19.2 about this method verifyConsumptionCreationModule()
	 * 
	 * @param successMsg : Expected success message to validate.
	 * @description : This method verifies the process of creating a new consumption
	 *              record in the Consumption module.
	 * @return : String - The actual success message displayed after the operation.
	 * @throws : Exception if any error occurs during the process.
	 * @author : YAKSHA
	 */
	public String verifyConsumptionCreationModule(String successMsg) throws Exception {
		return null;
	}

	/**
	 * @Test20 about this method verifyReportModule()
	 *
	 * @param : null
	 * @description : This method verifies the functionality of the "Reports"
	 *              section within the "Inventory" module. It clicks on the
	 *              "Reports" section, applies a date filter, generates a report,
	 *              and checks if the report table is displayed with results.
	 * @return : boolean - true if the report table is displayed with results, false
	 *         otherwise.
	 * @throws : Exception - if there is an issue with any of the operations
	 *           performed.
	 * @author : YAKSHA
	 */
	public boolean verifyReportModule() throws Exception {
		return false;
	}

	/**
	 * @Test21 about this method verifyConsumptionModule()
	 *
	 * @param : null
	 * @description : This method Verify and creating the functionality of "Reports"
	 *              section of the "Inventory" module
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public String verifyReturnModuleErrorMessage(String successMsg) throws Exception {
		return null;
	}
	
	/**
	 * @Test22 about this method getCommentsForPost()
	 * 
	 * @param : int postId - The ID of the post to retrieve comments for.
	 * @description : This method sends a GET request to retrieve comments
	 *              associated with a specific post.
	 * @return : Response - The response from the API containing the list of
	 *         comments.
	 */
	public Response getCommentsForPost(int postId) {
		return null;
	}

	/**
	 * @Test23 about this method deletePost()
	 * 
	 * @param : int id - The ID of the post to delete.
	 * @description : This method sends a DELETE request to remove a specific post
	 *              by its ID.
	 * @return : Response - The response from the API after attempting to delete the
	 *         post.
	 */
	public Response deletePost(int id) {
		return null;
	}

	/**
	 * @Test24 about this method updatePost()
	 * 
	 * @param : int id - The ID of the post to update.
	 * @param : String newTitle - The new title to update the post with.
	 * @param : String newBody - The new body content to update the post with.
	 * @param : int userId - The user ID associated with the post.
	 * @description : This method sends a PUT request to update a post with new
	 *              title, body, and user ID.
	 * @return : Response - The response from the API after updating the post.
	 */
	public Response updatePost(int id, String newTitle, String newBody, int userId) {
		return null;
	}



	/**
	 * @Test26 about this method getPostById()
	 * 
	 * @param : int id - The ID of the post to retrieve.
	 * @description : This method sends a GET request to retrieve a specific post by
	 *              its ID.
	 * @return : Response - The response from the API containing the post details.
	 */
	public Response getPostById(int id) {
		return null;
	}
}

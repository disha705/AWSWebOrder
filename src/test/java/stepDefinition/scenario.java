package stepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;

import Setup.ReadExcelData;
import baseClass.driverClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AllOrdersPage;
import pageClass.loginPage;
import pageClass.OrderPage;

public class scenario extends driverClass {

//	@After
//	public void closeBrowser() {
//		driver.quit();
//		driver.close();
//	}
	// --------------- Scenario 1 -----------------------------//

	loginPage lp = new loginPage();
	OrderPage op;
	AllOrdersPage aop;

	@Given("^Navigate to the application$")
	public void Navigate_to_the_application() {
		try {
			invokeBrowser();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openURL("baseURL");
	}

	@Then("^Login page verification$")
	public void Login_page_verification() {
		lp = verifyLoginPage();
		lp.TextboxU("UserName_xpath");
		lp.TextboxP("Password_xpath");
		lp.ButtonB("button_xpath");
	}

	@When("^login using valid credentials$")
	public void login_using_valid_credentials() {
		try {
			Object Object[][]=getCredentialsData();
			String Username = (String) Object[0][0];
			String Password = (String) Object[0][1];
			lp.loginFunction("UserName_xpath",Username);
			lp.loginFunction("Password_xpath",Password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		lp.loginFunction("UserName_xpath", "email");
//		lp.loginFunction("Password_xpath", "password");
		lp.clickfunction("button_xpath");
	}

	@Then("^Verify Username$")
	public void Verify_Username() {
		op = lp.verifyLogin("loginVerify_xpath");
	}

	@When("^Navigate to orders page$")
	public void Navigate_to_orders_page() {
		op.OrderCalculate();
		op.verifyCalculate();
	}
	@Then("^verify Calculate$")
	public void verify_Calculate() {
		op.verifyCalculate();
	}

	@When("^reset button$")
	public void reset_button() {
		op.Reseting();
	}

	@Then("^Verify Reset$")
	public void Verify_Reset() {
		op.VerifyReset();
	}

	@When("^setting order$")
	public void setting_order() {
		op.OrderCalculate();
	}

	@When("^address input$")
	public void address_input() {
		try {
			Object Object[][]=getOrderDeatils();
			
			String Cname = (String) Object[0][0];
			System.out.println("Cname--"+Cname);
			String Street = (String) Object[0][1];
			String city = (String) Object[0][2];
			String state = (String) Object[0][3];
			
			op.addressinput(Cname,Street,city,state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("^credit details$")
	public void credit_details() {
		op.Creditdata();
	}
	@When("^Process Clicked$")
	public void Process_Clicked() {
		op.Process();
	}
	@Then("^verifing confirm message$")
	public void verifing_confirm_message() {
		op.confirm();
	}
	@When("^Navigate to all Orders$")
	public void Navigate_to_all_Orders() {
		aop = op.AllOrders();
	}
	@Then("^verify the created order$")
	public void verify_the_created_order()
	{
		aop.searchCreatedOrder();
	}
	@When("^Edit the Order$")
	public void Edit_the_Order()
	{
		aop.EditOrder();
	}

	@Then("^Verifiy updated order$")
	public void Verifiy_updated_order()
	{
		aop.VerifyEditOrder();
	}
	public Object[][] getCredentialsData() throws IOException
	{
		return ReadExcelData.getData("CredentailsData.xlsx", "AccountCredentials", "Creden");
	}
	public Object[][] getOrderDeatils() throws IOException
	{
		return ReadExcelData.getData("CredentailsData.xlsx", "OrderDetails", "Order");
	}
}

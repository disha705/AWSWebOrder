package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;

import Setup.ReadExcelData;
import baseClass.driverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AllOrdersPage;
import pageClass.OrderPage;
import pageClass.ProductPage;
import pageClass.loginPage;

public class scenario3 extends driverClass {
	loginPage lp = new loginPage();
	OrderPage op;
	ProductPage prp;
	

	@Given("^Navigate to the application3$")
	public void Navigate_to_the_application3() {
		openURL3("baseURL");
	}

	@Then("^Login page verification3$")
	public void Login_page_verification3() {
		lp = verifyLoginPage();
		lp.TextboxU("UserName_xpath");
		lp.TextboxP("Password_xpath");
		lp.ButtonB("button_xpath");
	}

	@When("^login using valid credentials3$")
	public void login_using_valid_credentials3() {
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
		lp.clickfunction("button_xpath");
	}

	@Then("^Verify Username3$")
	public void Verify_Username3() {
		op = lp.verifyLogin("loginVerify_xpath");
	}
	@When("^Navigate to product page$")
	public void Navigate_to_product_page()
	{
		prp=op.ProductP();
		
	}

	@Then("^Verifiy values in the table$")
	public void Verifiy_values_in_the_table()
	{
		try {
			Object Object[][]=gettableDetials();
			String pn1 = (String) Object[0][0];
			String pn2 = (String) Object[1][0];
			String pn3 = (String) Object[2][0];
			String p1 = (String) Object[0][1];
			String p2 = (String) Object[1][1];
			String p3 = (String) Object[2][1];
			String d1 = (String) Object[0][2];
			String d2 = (String) Object[1][2];
			String d3 = (String) Object[2][2];
			
			
			prp.Verifyvalues(pn1,pn2,pn3,p1,p2,p3,d1,d2,d3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("^Logout3$")
	public void Logout3()
	{
		prp.logout2();
	}
	@Then("^close2$")
	public void close2()
	{
		driver.quit();
	}
	public Object[][] getCredentialsData() throws IOException
	{
		return ReadExcelData.getData("CredentailsData.xlsx", "AccountCredentials", "Creden");
	}
	public Object[][] gettableDetials() throws IOException
	{
		return ReadExcelData.getData("CredentailsData.xlsx", "table", "table");
	}
}

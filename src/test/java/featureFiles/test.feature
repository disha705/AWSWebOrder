@Complete
Feature: Case Study
@Case1
Scenario: Create Order
	Given Navigate to the application
	Then Login page verification
	When login using valid credentials
	Then Verify Username
	When Navigate to orders page
	Then verify Calculate
	When reset button
	Then Verify Reset
	When setting order
	When address input
	When credit details
	When Process Clicked
	Then verifing confirm message
	When Navigate to all Orders
	Then verify the created order
	When Edit the Order
	Then Verifiy updated order
@Case2
Scenario: Edit Order
	Given Navigate to the application2
	Then Login page verification2
	When login using valid credentials2
	Then Verify Username2
	When Edit the Order2
	Then Verifiy updated order2
	When Logout2
@Case3
Scenario: Product Page
	Given Navigate to the application3
	Then Login page verification3
	When login using valid credentials3
	Then Verify Username3
	When Navigate to product page
	Then Verifiy values in the table
	When Logout3
	Then close2
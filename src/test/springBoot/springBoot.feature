Feature: Spring Boot Web

	Background: To launch the browser
		Given Launch the browser
		
	Scenario: Create product
		When navigate to spring boot web on the browser
		Then click the create product button
		And fill the description box
		And fill the price box
		And fill the image url box
		Then click the submit button
		And get the product id
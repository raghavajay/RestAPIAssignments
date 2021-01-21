Feature: Validating the feature of country Detail API

  Scenario: Verify the country details app is accessible to users
	When user send a get request,they must get back a valid status code 200

  Scenario: Verify the Service to get and search Country with ISO codes and its name
	When User makes a get call using "/alpha/co"
	Then API returns the response Status Code as 200

  Scenario: Verify the service to get and search currency of a Country
	When User makes a get call using "/currency/cop"
	Then API returns the response Status Code as 200
	And the country details are available in response

  Scenario: Verify the service to get and search Calling code of a Country
	When User makes a get call using "/callingcode/57"
	Then API returns the response Status Code as 200
	And the country details are available in response
package com.files;
public class payload {

	
	public static String AddPlace()
	{
		return  "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
			
	}

	public static String Addbook(String aisle, String isbn) {
		String payload = String.format("""
			{
				\"name\":\"Learn Appium Automation with Java\",
				\"isbn\":\"%s\",
				\"aisle\":\"%s\",
				\"author\":\"John foe\"
				}	
			""",aisle,isbn);

		return payload;
	}
	public static String CoursePrice() {
		String test = """
			{
				\"dashboard\":{
				   \"purchaseAmount\":910,
				   \"website\":\"rahulshettyacademy.com\"
				},
				\"courses\":[
				   {
					  \"title\":\"Selenium Python\",
					  \"price\":50,
					  \"copies\":6
				   },
				   {
					  \"title\":\"Cypress\",
					  \"price\":40,
					  \"copies\":4
				   },
				   {
					  \"title\":\"RPA\",
					  \"price\":45,
					  \"copies\":10
				   }
				]
			 }
				""";
		return test ;
		// return "{\r\n" + 
		// 	"  \"dashboard\": {\r\n" + 
		// 	"    \"purchaseAmount\": 1162,\r\n" + 
		// 	"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
		// 	"  },\r\n" + 
		// 	"  \"courses\": [\r\n" + 
		// 	"    {\r\n" + 
		// 	"      \"title\": \"Selenium Python\",\r\n" + 
		// 	"      \"price\": 50,\r\n" + 
		// 	"      \"copies\": 6\r\n" + 
		// 	"    },\r\n" + 
		// 	"    {\r\n" + 
		// 	"      \"title\": \"Cypress\",\r\n" + 
		// 	"      \"price\": 40,\r\n" + 
		// 	"      \"copies\": 4\r\n" + 
		// 	"    },\r\n" + 
		// 	"    {\r\n" + 
		// 	"      \"title\": \"RPA\",\r\n" + 
		// 	"      \"price\": 45,\r\n" + 
		// 	"      \"copies\": 10\r\n" + 
		// 	"    },\r\n" + 
		// 	"     {\r\n" + 
		// 	"      \"title\": \"Appium\",\r\n" + 
		// 	"      \"price\": 36,\r\n" + 
		// 	"      \"copies\": 7\r\n" + 
		// 	"    }\r\n" + 
		// 	"    \r\n" + 
		// 	"    \r\n" + 
		// 	"    \r\n" + 
		// 	"  ]\r\n" + 
		// 	"}\r\n" + 
		// 	"";
	}

	
	
}

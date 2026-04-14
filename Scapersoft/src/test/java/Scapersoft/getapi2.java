package Scapersoft;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getapi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String token = "c5400bcff1e279004591daaf1ba1ce3b0f1eb5ea";
		
		
		Response response = RestAssured
				.given()	
				.header("Authorization", "Bearer " + token)
				.when()
				.get("https://qa.helloretriever.com/api/v2/device_returns/");
		System.out.println("RAW JSON:");
		System.out.println(response.asPrettyString());
			
			// Count how many times "id" appears (how many rows)
	        List<Object> id = response.jsonPath().getList("id");
	        System.out.println("Total rows in JSON: " + id.size());
				
				
//		System.out.println("API Time: " + response.getTime() + " ms");
//		System.out.println("Status Code: " + response.getStatusCode());
//		
//	
//		if (response.statusCode() == 200){
//		System.out.println("Test passed");
//		}
//		else if (response.statusCode() == 403){
//		System.out.println("token invalid");
//		}
//		else if (response.statusCode() == 500)	{
//		System.out.println("Internal server error");
//		}
//		else System.out.println("Something went wrong");
		

        
                
                
//                String token = "YOUR_BEARER_TOKEN";
//
//                int statusCode = RestAssured
//                        .given()
//                        .header("Authorization", "Bearer " + token)
//                        .when()
//                        .get("https://api.example.com/users/1")
//                        .getStatusCode();
//
//                System.out.println("API Status Code: " + statusCode);
		
		
	}

}

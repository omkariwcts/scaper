package Scapersoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class postapi {

    public static void main(String[] args) {

        // BASE URL
        RestAssured.baseURI = "https://qa.helloretriever.com/";

        // =======================
        // STEP 1: GET CSRF TOKEN
        // =======================
        Response csrfResponse = RestAssured.given()
                .when()
                .get("/api/get-csrf/");   // backend must expose this endpoint

        String csrfToken = csrfResponse.getCookie("csrftoken");
        System.out.println("CSRF Token = " + csrfToken);

        // =======================
        // STEP 2: JSON BODY
        // =======================
        Map<String, Object> body = new HashMap<>();

        body.put("request_charger", true);
        body.put("request_cell_phone", false);
        body.put("device", "laptop");
        body.put("request_disposal", false);
        body.put("request_for_warehouse", false);
        body.put("serial_number", "FVXXF5GXXG1R");
        body.put("ticket_id", "TKT1234567890");
        body.put("legal_hold", 5);
        body.put("note_1", "Internal Note 1");
        body.put("note_2", "Internal Note 2");

        // employee_info object
        Map<String, Object> employeeInfo = new HashMap<>();
        employeeInfo.put("email", "kennethdavis@example.com");
        employeeInfo.put("name", "Kenneth Davis");
        employeeInfo.put("address_line_1", "1734 Steele Street");
        employeeInfo.put("address_line_2", "Apt 10A");
        employeeInfo.put("address_city", "Arlington Heights");
        employeeInfo.put("address_state", "IL");
        employeeInfo.put("address_country", "United States");
        employeeInfo.put("address_zip", "60005-4182");
        body.put("employee_info", employeeInfo);

        // company_info object
        Map<String, Object> companyInfo = new HashMap<>();
        companyInfo.put("return_recipient_name", "Dorothy Buchanan");
        companyInfo.put("return_address_company", "BigCo");
        companyInfo.put("return_address_line_1", "4522 Hanover Street");
        companyInfo.put("return_address_line_2", "Ste 120");
        companyInfo.put("return_address_city", "New York");
        companyInfo.put("return_address_state", "NY");
        companyInfo.put("return_address_country", "United States");
        companyInfo.put("return_address_zip", "10016-1209");
        companyInfo.put("display_name", "BigCo IT");

        List<String> emails = Arrays.asList(
                "it-team@example.com",
                "it-team2@example.com"
        );
        companyInfo.put("notification_emails", emails);

        companyInfo.put("additional_instructions", "additional instructions");

        body.put("company_info", companyInfo);

        // =======================
        // STEP 3: AUTH TOKEN
        // =======================
        String token = "fe18505c2e3edf94aae7b82ed9393f31b17743ee";

        // =======================
        // STEP 4: SEND POST REQUEST
        // =======================
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .header("X-CSRFToken", csrfToken)     // IMPORTANT
                .cookie("csrftoken", csrfToken)       // IMPORTANT
                .body(body)
                .when()
                .post("api/v2/device_returns/")
                .then()
                .extract()
                .response();

        // OUTPUT
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response:");
        System.out.println(response.asPrettyString());
    }
}
/**
 * 
 */
package com.utils;

// import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.enums.ConfigPropertiesEnum;

// import io.restassured.response.Response;

/**
 * Jul 3, 2021
 * 
 * @author Krishanu
 */
public class ELKUtils {

	private ELKUtils() {
	}

	public static void sendDataToElasticSearch(String testName, String status) {
		
		if (PropertiesUtils.get(ConfigPropertiesEnum.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
		
		String baseURI = PropertiesUtils.get(ConfigPropertiesEnum.ELASTICSEARCHURL);

		Map<String, String> reqMap = new HashMap<>();
		reqMap.put("testName", testName);
		reqMap.put("status", status);
		reqMap.put("executionTime", LocalDate.now().toString());
		
//		Response response = given()
//							    .header("Content-Type", "application/json")
//							    .body(reqMap)
//							    .log().all()
//						    .when()
//						        .post(baseURI);
//
//			response.prettyPrint();

		}

	}

}

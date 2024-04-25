//package utils;
//
//import static io.restassured.RestAssured.requestSpecification;
//import static io.restassured.RestAssured.responseSpecification;
//
//import com.zebrunner.carina.utils.config.Configuration;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//
//public class ApiHelper {
//	
//	static long petID;
//
//    public static void reqResBuilder() {
//    	System.out.println("Commaon steps");
//    	RequestSpecBuilder requestSpec = new RequestSpecBuilder();
//		requestSpecification = requestSpec
//				.setBaseUri(Configuration.getRequired("testAPI"))
//				.setContentType(ContentType.JSON)
//				.log(LogDetail.ALL)
//				.addHeader("accept", "application/json")
//				.build();
//
//		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
//		responseSpecification = responseSpec
//				.expectStatusCode(200)
//				.expectContentType(ContentType.JSON)
//				.log(LogDetail.ALL)
//				.build();
//    }
//    
//    public static String buildJsonBody(long petID) {
//    	
//        return "{"
//                + "  \"id\": "+petID+","
//                + "  \"category\": {"
//                + "    \"id\": 0,"
//                + "    \"name\": \"updated string\""
//                + "  },"
//                + "  \"name\": \"doggie name updated\","
//                + "  \"photoUrls\": ["
//                + "    \"string\""
//                + "  ],"
//                + "  \"tags\": ["
//                + "    {"
//                + "      \"id\": 0,"
//                + "      \"name\": \"string updated\""
//                + "    }"
//                + "  ],"
//                + "  \"status\": \"sold\""
//                + "}";
//    }
//    
//}
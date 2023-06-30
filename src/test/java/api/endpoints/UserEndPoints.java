package api.endpoints;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	// refer the swagger doc with url:"https://petstore.swagger.io/#/user/"
	
// username and payload will be send by test cases and validations will be present in test cases itself therefore we have not used "then" statement
// in below code.
//userend point will contain all the request.
public static Response createUser(User payload) 
{
// TODO Auto-generated method stub.

	 Response response=given()
	         .contentType(ContentType.JSON)
	         .accept(ContentType.JSON)
	         .body(payload)
	 .when()
	        .post(Routes.post_url);  
	      
	  return response;
	         
	
}
	
public static Response  getUser(String userName)
{
     Response response=given()
             .pathParam("username", userName)
           
     .when()
            .get(Routes.get_url);
     return response;
     

}

public static Response updateUser(User payload,String userName)
{

	 Response response=given()
	       .accept(ContentType.JSON)
	       .contentType(ContentType.JSON)
	       .pathParam("username", userName)
	       .body(payload)
	       
	 .when()
	       .put(Routes.update_url);
	       
	       return response;
}

public static Response deleteUser(String userName)
{
      Response response=given()
            .pathParam("username", userName)
            
      .when()
             .delete(Routes.delete_url);

             return response;
             


}
}

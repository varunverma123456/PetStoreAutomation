package api.endpoints;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {

	// refer the swagger doc with url:"https://petstore.swagger.io/#/user/"
	
// username and payload will be send by test cases and validations will be present in test cases itself therefore we have not used "then" statement
// in below code.
//userend point will contain all the request.
	           
	      static   ResourceBundle getURL()
	         {
	            // loading the properties file.   	  
	        	// pass  the Routes.properties  file as parameter into getBundle() method. 
	    	  ResourceBundle routes= ResourceBundle.getBundle("Routes");
	        	 
	        	 return routes;
	        	 
	        	 
	        	 
	         }
	
	
	
public static Response createUser(User payload) 
{
// TODO Auto-generated method stub.
    // call getURL() which you have generated earlier which returns routes and on that routes fetch the string and pass name of
	//post_url i.e. key of properties file in getString() method.
	String post_url=getURL().getString("post_url");
	                 
	                   
	 Response response=given()
	         .contentType(ContentType.JSON)
	         .accept(ContentType.JSON)
	         .body(payload)
	 .when()
	       // pass the string generated above i.e. post_url into post method.   
	        .post(post_url);  
	      
	  return response;
	         
	
}
	
public static Response  getUser(String userName)
{
	// call getURL() which you have generated earlier which returns routes and on that routes fetch the string and pass name of
		//get_url i.e. key of properties file in getString() method.
		String get_url=getURL().getString("get_url"); 
	Response response=given()
             .pathParam("username", userName)
           
     .when()
  // pass the string generated above i.e. get_url into get method.
            .get(get_url);
     return response;
     

}

public static Response updateUser(User payload,String userName)
{

	// call getURL() which you have generated earlier which returns routes and on that routes fetch the string and pass name of
		//put_url i.e. key of properties file in getString() method.
		String put_url=getURL().getString("put_url");
		
	 Response response=given()
	       .accept(ContentType.JSON)
	       .contentType(ContentType.JSON)
	       .pathParam("username", userName)
	       .body(payload)
	       
	 .when()
	// pass the string generated above i.e. put_url into put method.
	         .put(put_url);
	       
	       return response;
}

public static Response deleteUser(String userName)
{
	// call getURL() which you have generated earlier which returns routes and on that routes fetch the string and pass name of
		//delete_url i.e. key of properties file in getString() method.
		String delete_url=getURL().getString("delete_url");
      
		Response response=given()
            .pathParam("username", userName)
            
      .when()
   // pass the string generated above i.e. delete_url into delete method.
             .delete(delete_url);

             return response;
             


}
}

package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {

	        
	        @Test(priority =1,dataProvider="Data",dataProviderClass = DataProviders.class)
        public void testPostUser(String UserID,String	UserName,String	FirstName,String LastName,String Email,String	Password,String 	Phone)
       //copy the same fields from excel into "tespostuser" method parameters.
        {
	         // create the object of user pojo  class.
	          User userpayload= new User();
	         
	          // convert the string UserID to integer.
	         userpayload.setId(Integer.parseInt(UserID));
	         userpayload.setUsername(UserName);
	         userpayload.setFirstName(FirstName);
	         userpayload.setLastName(LastName);
	         userpayload.setEmail(Email);
	         userpayload.setPassword(Password);
	         userpayload.setPhone(Phone);
	         
	         Response response=UserEndPoints.createUser(userpayload);
	         
	         AssertJUnit.assertEquals(response.getStatusCode(),200);
	      
	             
        }
	 
	        @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	     public void testDeleteUser(String UserName)
	     {
	       // deleting the created user.     	  
	        	Response response=UserEndPoints.deleteUser(UserName);
	               
	               AssertJUnit.assertEquals(response.getStatusCode(),200);
	                   	  
	            	  
	            	  
	            	  
	            	  
	     }
	
	
}

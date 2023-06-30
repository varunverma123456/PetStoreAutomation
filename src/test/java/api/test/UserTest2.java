package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {

	// replace UserEndPoints with UserEndPoints2.
	
	  Faker faker;
	  User Payload;
// import Logger from org.apache.logging.log4j.Logger;	  
	  public Logger logger;
	  
	      @BeforeClass
	public void setup()
	{
	    	  
	
	 // creating the object of java  faker class.   	  
	 faker= new Faker();

	// creating the object of pojo class i.e. user.
	Payload = new User();
	
	/*
	      int   id;
		  String  username;
		  String  firstName;
		  String lastName;
		  String email;
		  String password;
		  String phone;
		  int userStatus= 0;
	 
	 */
	
       Payload.setId(faker.idNumber().hashCode());
       Payload.setFirstName(faker.name().firstName());
       Payload.setLastName(faker.name().lastName());
       Payload.setUsername(faker.name().fullName());
       Payload.setEmail(faker.internet().emailAddress());
       Payload.setPhone(faker.phoneNumber().cellPhone());
       Payload.setPassword(faker.internet().password());
    
       // take LogManager from log4j.
       logger= LogManager.getLogger(this.getClass());
        	  
	}
	       @Test(priority = 1)
	   public void testPostUser()
	   {
		   logger.info("*******Creating the user****************");
		   Response response=UserEndPoints2.createUser(Payload);
		                     response.then().log().all();
		   
		   AssertJUnit.assertEquals(response.getStatusCode(),200);
		   
		   logger.info("******* User created****************");
		   
		   
	   }
	              @Test(priority=2)
	       public void testGetUser()
	       {
	            	  logger.info("*******reading the user****************"); 	  
	    	  Response response= UserEndPoints2.getUser(Payload.getUsername());
	    	            response.then().log().all();
	    	  
	    	  AssertJUnit.assertEquals(response.getStatusCode(),200);
	    	  logger.info("*******user is read****************");
	    	   
	       }
	          @Test(priority=3)
        public void testUpdateUser()
	   {
		   // updating data using payload.
	        	  logger.info("*******Updating the user****************");
	        	  
	        	  Payload.setFirstName(faker.name().firstName());
	              Payload.setLastName(faker.name().lastName());
	              Payload.setEmail(faker.internet().emailAddress());
	        	  
		   Response response=UserEndPoints2.updateUser(Payload,Payload.getUsername());
		    response.then().log().all();
		   		      AssertJUnit.assertEquals(response.getStatusCode(),200);
		   		   logger.info("*******User updated****************");
		   		      
		            //validating the data after update by using get request.
		   		   Response responseafterupdate= UserEndPoints.getUser(Payload.getUsername());
		   		      AssertJUnit.assertEquals(responseafterupdate.getStatusCode(), 200);
		   
	   }
	            @Test(priority =4)
	          public void testDeleteUser()
	          {
	            	logger.info("*******Deleting the user****************");
	               Response response=UserEndPoints2.deleteUser(Payload.getUsername());
	               
	               AssertJUnit.assertEquals(response.getStatusCode(),200);
	               
	               logger.info("******* User deleted****************");
	                	 
	                	 
	          }
	
	          
	          
	          
}

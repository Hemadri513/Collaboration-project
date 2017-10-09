package com.hema.collaborate.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hema.collaborationbackend.model.Error;
import com.hema.collaborationbackend.model.User;
import com.hema.collaborationbackend.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("user controller");
	}
	
	
	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		if(!userService.isUsernameValid(user.getUsername())) 
		{
			Error error = new Error(2,"Username already exists.. please enter different username");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(!userService.isEmailValid(user.getEmail()))
		{
			Error error=new Error(3,"Email address already exists.. please enter different email");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		
		boolean result=userService.registerUser(user);
		if(result)
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			Error error=new Error(1,"unable to register user details");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST) // each user unique session object will get created
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session)
	{
		User validUser=userService.login(user);
		if(validUser==null) {//invalid username/password
			Error error=new Error(4,"Invalid Username/Password...");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);	// error end callback func
			//resposne.data=error
			//response.status=401
		}
		System.out.println("ONLINE Status is" + validUser.isOnline());
		//update the online status to true
		validUser.setOnline(true);
		try {
		userService.update(validUser);
		}
		catch(Exception e) {
			Error error=new Error(6,"unable to update online status");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Online status after update" + validUser.isOnline());
		session.setAttribute("username", validUser.getUsername());
		// username of logged-in user to an attribute 'username'
		return new ResponseEntity<User>(validUser,HttpStatus.OK);
		//response.data=validuser
		//response.status=200
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		String username=(String)session.getAttribute("username");
		System.out.println("Name of the user is" + username);
		if(username==null) {
			Error error= new Error(5,"Unauthorized access.. please login..");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		User user=userService.getUserByUsername(username);
		user.setOnline(false);
		userService.update(user); //online status is false
		session.removeAttribute("username");
		session.invalidate();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
		
}

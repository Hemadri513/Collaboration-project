/*
 * 
 **/
app.factory('UserService',function($http){
	var userService={}
	var BASE_URL = "http://localhost:8089/CollaborationMiddleware"
	
	userService.registerUser=function(user) {
		
		return $http.post(BASE_URL + "/registeruser",user)
	}
	
	return userService;
})
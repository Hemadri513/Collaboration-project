

app.controller('UserController',function($scope,UserService,$location){
	
	
	$scope.registerUser=function(){
		/*
		 * call user service by passing user data in json format
		 * */
		
		console.log("user data is" + $scope.user)
		UserService.registerUser($scope.user).then(function(response){
		/*
		 * redirect the user to login page with 'registration sucess'
		 * */	
			console.log(response.data)
			console.log(response.status)
			$location.path('/home')
			
		},function(response){
			/*
			 * error condition 
			 * if status is 406 , either username is not valid / email is not valid
			 * display the error message in the registrationform
			 * */
			
			console.log(response.data)
			console.log(response.status)
		})
		
	}
})

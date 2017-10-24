/**
 * 
 */

app.controller('FriendController',function($scope,$location,FriendService){
	function listOfSuggestedUser(){
		FriendService.listOfSuggestedUsers().then(function(response){
			$scope.suggestedUsers=response.data //List<User>
		},function(response){
			if(response.status==401)
				$location.path('/login')
		
		})
	}
	//function call
	listOfSuggestedUser()
})
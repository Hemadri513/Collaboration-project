

var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider) {
	$routeProvider
		.when('/register',{
			templateUrl: 'views/registrationform.html',
			controller:'UserController'
		})
		.when('/home',{
			templateUrl:'views/home.html'
		})
		.when('/login',{
			templateUrl:'views/login.html',
			controller:'UserController'
		})
		.when('/editprofile',{
			templateUrl:'views/editprofile.html',
			controller:'UserController'
		})
		.when('/addblogpost',{
			templateUrl:'views/blogpostform.html',
			controller:'BlogPostController'
		})
		.when('/getblogs',{
			templateUrl:'views/blogslist.html',
			controller:'BlogPostController' // c to v
		})
		.when('/getblogbyid/:id',{ //list of blgs approved
			templateUrl:'views/blogdetails.html', //details of approved blog blogpost + approval form
			controller:'BlogPostDetailController'	//$scope.blogpost = select * from blogpost where id=?
			
		})
		.when('/getapprovalform/:id',{
			templateUrl:'views/blogapprovalform.html', 	//blogpost + textarea
			controller:'BlogPostDetailController'	//$scope.blogpost = select * from blogpost where id=?
		})
		.when('/addjob',{
			templateUrl:'views/jobform.html',
			controller:'JobController'
		})
		.when('/getalljobs',{
			templateUrl:'views/jobslist.html',
			controller:'JobController'
		})
		.when('/uploadprofilepic',{
			templateUrl:'views/profilepicture.html'
		})
		.when('/getsuggestedusers',{
			templateUrl:'views/suggestedusers.html',
			controller:'FriendController'
		})
		.when('/pendingrequests',{
			templateUrl:'views/pendingrequests.html',
			controller:'FriendController'
		})
		.when('/listoffriends',{
			templateUrl:'views/listoffriends.html',
			controller:'FriendController'
		})
		.when('/chat',{
			templateUrl:'views/chat.html',
			controller:'ChatController'
		})
		.otherwise({
			templateUrl:'views/home.html'
		})
})


app.run(function($rootScope,$cookieStore,UserService,$location){
	console.log('entering app.run function')
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get('userDetails')
		
		$rootScope.logout=function(){
		console.log('entering logout function')
		UserService.logout().then(function(response){
			console.log('logout successfully')
			delete $rootScope.currentUser;
			$cookieStore.remove('userDetails')
			$location.path('/login')
		},
		function(response)
		{	
			console.log(response.status)
			if(response.status==401)
			{
				console.log('error in logout')
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails')
				$location.path('/login')
			}
		})
	}
})



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

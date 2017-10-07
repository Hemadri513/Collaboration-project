

var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider) {
	$routeProvider
		.when('/register',{
			templateUrl: 'views/registerationform.html',
			controller:'UserController'
		})
		.when('/home',{
			templateUrl:'views/home.html'
		})
		.otherwise({
			templateUrl:'views/home.html'
		})
})
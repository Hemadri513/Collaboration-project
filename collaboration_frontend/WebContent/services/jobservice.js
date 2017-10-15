/**
 * 
 */

app.factory('JobService',function($http){
	var jobService={}
	var BASE_URL="http://localhost:8089/CollaborationMiddleware"
	
	jobService.addJob=function(job){
		return $http.post(BASE_URL + "/addjob",job)
	}
	
	jobService.getAllJobs=function(job){
		return $http.post(BASE_URL + "/getalljobs",job)
	}
	return jobService;
})
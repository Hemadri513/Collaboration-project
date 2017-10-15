/**
 * 
 */


app.controller('JobController',function($scope,$location,JobService){
	$scope.addJob=function(){
		JobService.addJob($scope.job).then(function(response){
			console.log(response.data)
			console.log(response.status)
			getAllJobs()
			$location.path('/addjob')
		},function(response){
			
			console.log(response.data)
			console.log(response.status)
			$scope.errorMsg=response.data.message
			if(response.status==401)
			{
				
				$location.path('/login')
			}
			else {
				
				$location.path('/addjob')
			}
			
		})
	}
	
	function getAllJobs()
	{
		
		JobService.getAllJobs().then(function(response)
				{
			$scope.jobs=response.data
		},function(response)
		{
			$location.path('/login')
		})
	}
	
	getAllJobs() // this stm gets executed automatically whenever the controller get instaniated
})
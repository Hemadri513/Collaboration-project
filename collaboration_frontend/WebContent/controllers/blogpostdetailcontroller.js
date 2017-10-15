/**
 * 
 */

app.controller('BlogPostDetailController',function($scope,$location,BlogPostService,$routeParams){
	
	var id=$routeParams.id
	
	alert('blogpostdetailcontroller instantiated')
	BlogPostService.getBlogPostById(id).then(function(response) {
		$scope.blogPost=response.data // Blogpost [select * from blogpost where id =?]
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
})
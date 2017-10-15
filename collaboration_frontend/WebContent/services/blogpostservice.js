/**
 * 
 */

app.factory('BlogPostService',function($http){
	var blogPostService={}
	var BASE_URL="http://localhost:8089/CollaborationMiddleware"
	blogPostService.addBlogPost=function(blogPost)
	{
		return $http.post(BASE_URL + "/addblogpost",blogPost)
	}
	blogPostService.blogsWaitingForApproval=function(){
		return $http.get(BASE_URL + "/getblogs/"+0)	//select * from blogpost where approved=0
	}
	blogPostService.blogsApproved=function(){
		return $http.get(BASE_URL + "/getblogs/"+1)	//select * from blogpost where approved=0
	}
	
	blogPostService.getBlogPostById=function(id){
		return $http.get(BASE_URL + "/getblogbyid/"+id)
	}
	/*
	 * to update approved property and rejection reason (approved /reject)
	 * id,blog titlle,blog content 
	 * */
	blogPostService.updateBlogPost=function(blogPost){
		console.log(blogPost)
		return $http.put(BASE_URL + "/update",blogPost)
	}
	
	return blogPostService;
})
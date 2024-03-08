package blog.controllers.post.add;

public record AddPostResponse(
		String title, 
		String author, 
		String content, 
		String date
		) {

}

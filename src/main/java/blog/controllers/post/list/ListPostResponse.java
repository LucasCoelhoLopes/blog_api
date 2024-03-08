package blog.controllers.post.list;

public record ListPostResponse(
		String title, 
		String author, 
		String content, 
		String date
		) {

}

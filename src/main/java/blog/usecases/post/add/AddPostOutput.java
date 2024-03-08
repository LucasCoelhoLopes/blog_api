package blog.usecases.post.add;

public record AddPostOutput( 
		String title, 
		String author, 
		String content, 
		String date
	){
}

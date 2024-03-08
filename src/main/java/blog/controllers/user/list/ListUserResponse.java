package blog.controllers.user.list;

public record ListUserResponse(
		String name, 
		String nickname, 
		String email, 
		String password
		) {

}

package blog.usecases.user.add;

public record AddUserOutput(
		String name, 
		String nickname, 
		String email, 
		String password
		){

}

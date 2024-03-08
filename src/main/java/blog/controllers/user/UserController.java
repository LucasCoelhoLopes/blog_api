package blog.controllers.user;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.controllers.post.list.ListPostResponse;
import blog.controllers.user.add.AddUserResponse;
import blog.domain.post.gateway.PostGateway;
import blog.domain.user.gateway.UserGateway;
import blog.usecases.user.add.AddUserUsecase;
import blog.usecases.user.list.ListUserUsecase;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	private UserGateway userGateway;
	private PostGateway postGateway;
	
	
	public UserController(UserGateway userGateway, PostGateway postGateway) {
		super();
		this.userGateway = userGateway;
		this.postGateway = postGateway;
	}

	@GetMapping("/add")
	public AddUserResponse AddUser(String name, String nickname, String email, String password){
		
		AddUserUsecase obj = new AddUserUsecase(userGateway);
		final var aResult = obj.create(name, nickname, email, password);
		
		
		final var aResponse = new AddUserResponse(
				aResult.name(), 
				aResult.nickname(), 
				aResult.email(), 
				aResult.password());
		
		return aResponse;
	}
	
	@GetMapping("/list")
	public ListPostResponse ListUser(Long id) {
		ListUserUsecase obj = new ListUserUsecase(userGateway);
		final var aResult = obj.findById(id);
		
		final var aResponse = new ListPostResponse(
				aResult.name(),
				aResult.nickname(),
				aResult.email(),
				aResult.password());
		
		return aResponse;
		
	}
	
}









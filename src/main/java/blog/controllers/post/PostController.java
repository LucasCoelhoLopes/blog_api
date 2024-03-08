package blog.controllers.post;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.controllers.post.add.AddPostResponse;
import blog.controllers.post.list.ListPostResponse;
import blog.controllers.user.add.AddUserResponse;
import blog.domain.post.gateway.PostGateway;
import blog.domain.user.gateway.UserGateway;
import blog.usecases.post.add.AddPostUsecase;
import blog.usecases.post.list.ListPostUsecase;
import blog.usecases.user.add.AddUserUsecase;
import blog.usecases.user.list.ListUserUsecase;

@RestController
@RequestMapping("/post")
@Validated
public class PostController {
	
	private UserGateway userGateway;
	private PostGateway postGateway;
	
	public PostController(UserGateway userGateway, PostGateway postGateway) {
		super();
		this.userGateway = userGateway;
		this.postGateway = postGateway;
	}
	
	@GetMapping("/add")
	public AddPostResponse AddPost(String title, String author, String content, String date){
		
		AddPostUsecase obj = new AddPostUsecase(postGateway);
		final var aResult = obj.create(title, author, content, date);
		
		final var aResponse = new AddPostResponse(
				aResult.title(), 
				aResult.author(), 
				aResult.content(), 
				aResult.date();
		
		return aResponse;
	}
	
	@GetMapping("/list")
	public ListPostResponse ListPost(Long id) {
		ListPostUsecase obj = new ListPostUsecase(postGateway);
		final var aResult = obj.findById(id);
		
		final var aResponse = new ListPostResponse(
				aResult.title(),
				aResult.author(),
				aResult.content(),
				aResult.date();
		
		return aResponse;
		
	}

}

package blog.usecases.post.list;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.domain.post.entities.Post;
import blog.domain.post.gateway.PostGateway;
import blog.domain.user.entities.User;
import blog.usecases.user.list.ListUserOutput;

@Service
public class ListPostUsecase {
	
	private PostGateway postGateway;
	
	public ListPostUsecase(PostGateway postGateway) {
		super();
		this.postGateway = postGateway;
	}

	public ListPostOutput findById(Long id) {
		Optional<Post> post = this.postGateway.findById(id); // returns empty instead of null
		
		// retorna
		final var aResult = new ListPostOutput(
			post.getTitle(),
			post.getAuthor(),
			post.getContent();
			post.getDate());
		
		return aResult.orElseThrow(() -> new RuntimeException(
				"Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
				)); // retorns user if not empty
	}
	
		
}
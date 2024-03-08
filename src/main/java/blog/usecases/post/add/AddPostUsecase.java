package blog.usecases.post.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.domain.post.entities.Post;
import blog.domain.post.gateway.PostGateway;
import blog.domain.user.entities.User;
import blog.usecases.user.add.AddUserOutput;
import blog.usecases.user.list.ListUserUsecase;

@Service
public class AddPostUsecase {
	
	private PostGateway postGateway;
	
	public AddPostUsecase(PostGateway postGateway) {
		super();
		this.postGateway = postGateway;
	}

	public AddUserOutput create(String title, String author, String content, String date) {
		Post obj = new Post();
		
		// cria
		obj.setTitle(title);
		obj.setAuthor(author);
		obj.setContent(content);
		obj.setDate(date);	
		
		// persiste
		obj = this.postGateway.save(obj);
		
		// retorna
		final var aResult = new AddUserOutput(
				title, 
				author, 
				content, 
				date);
		
		return aResult;
	}
		
}

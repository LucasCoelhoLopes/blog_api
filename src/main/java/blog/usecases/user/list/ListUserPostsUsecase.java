package blog.usecases.user.list;

import java.util.List;

import org.springframework.stereotype.Service;

import blog.domain.post.entities.Post;
import blog.domain.user.entities.User;

@Service
public class ListUserPostsUsecase {
	
	public static List<Post> list(User obj) {
		ListUserUsecase listUserUsecase = new ListUserUsecase();
		User newObj = listUserUsecase.findById(obj.getUser_id());
		return newObj.getPosts();
	}
		
}








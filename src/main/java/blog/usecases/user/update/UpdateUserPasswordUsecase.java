package blog.usecases.user.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.domain.user.entities.User;
import blog.domain.user.gateway.UserGateway;
import blog.usecases.user.list.ListUserUsecase;

@Service
public class UpdateUserPasswordUsecase {
	
	@Autowired
	private UserGateway userGateway;
	
	@Transactional
	public User update(User obj) {
		ListUserUsecase listUserUsecase = new ListUserUsecase();
		User newObj = listUserUsecase.findById(obj.getUser_id());
		newObj.setPassword(obj.getPassword());
		return this.userGateway.save(newObj);
	}
		
}

package blog.usecases.user.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.domain.user.entities.User;
import blog.domain.user.gateway.UserGateway;

@Service
public class AddUserUsecase {
	
	
	private UserGateway userGateway;
	
	
	
	public AddUserUsecase(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}
	
	public AddUserOutput create(String name, String nickname, String email, String password) {
		User obj = new User();
		
		// cria
		obj.setUser_id(null);
		obj.setName(name);
		obj.setNickname(nickname);
		obj.setEmail(email);
		obj.setPassword(password);	
		
		// persiste
		obj = this.userGateway.save(obj);
		
		// retorna
		final var aResult = new AddUserOutput(
				name, 
				nickname, 
				email, 
				password);
		
		return aResult;
	}
		
}











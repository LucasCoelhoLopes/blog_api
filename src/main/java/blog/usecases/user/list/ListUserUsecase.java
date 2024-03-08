package blog.usecases.user.list;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.domain.user.entities.User;
import blog.domain.user.gateway.UserGateway;
import blog.usecases.user.add.AddUserOutput;

@Service
public class ListUserUsecase {
	
	
	private UserGateway userGateway;
	
	public ListUserUsecase(UserGateway userGateway) {
		super();
		this.userGateway = userGateway;
	}

	public ListUserOutput findById(Long id) {
		Optional<User> user = this.userGateway.findById(id); // returns empty instead of null
		
		// retorna
		final var aResult = new ListUserOutput(
			user.getName(),
			user.getNickname(),
			user.getEmail(),
			user.getPassword());
		
		return aResult.orElseThrow(() -> new RuntimeException(
				"Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
				)); // retorns user if not empty
	}
	
}

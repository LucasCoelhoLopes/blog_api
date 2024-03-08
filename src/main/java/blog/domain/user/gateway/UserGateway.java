package blog.domain.user.gateway;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.domain.user.entities.User;

@Repository
public interface UserGateway extends JpaRepository<User, Long> {
	 
}

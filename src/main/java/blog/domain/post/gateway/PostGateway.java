package blog.domain.post.gateway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.domain.post.entities.Post;

@Repository
public interface PostGateway extends JpaRepository<Post, Long> {
	 
}
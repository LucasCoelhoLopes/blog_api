package blog.domain.user.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
//import com.lucaslopes.todosimple.models.User.CreateUser;
//import com.lucaslopes.todosimple.models.User.UpdateUser;

import blog.domain.post.entities.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
	public interface CreateUser{}
	public interface UpdateUser{}
	
	public static final String TABLE_NAME = "user";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true)
	private Long user_id;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	// validation
	@NotNull(groups = CreateUser.class)
	@NotEmpty(groups = CreateUser.class)
	@Size(groups = CreateUser.class, min = 2, max = 100)
	private String name;
	
	@Column(name = "nickname", length = 50, nullable = false, unique = true)
	// validation
	@NotNull(groups = CreateUser.class)
	@NotEmpty(groups = CreateUser.class)
	@Size(groups = CreateUser.class, min = 2, max = 50)
	private String nickname;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	// validation
	@NotNull(groups = CreateUser.class)
	@NotEmpty(groups = CreateUser.class)
	@Size(groups = CreateUser.class, min = 2, max = 50)
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY) // dosen't return user's password on Json
	@Column(name = "password", length = 60, nullable = false)
	// validation
	@NotNull(groups = {CreateUser.class, UpdateUser.class})
	@NotEmpty(groups = {CreateUser.class, UpdateUser.class})
	@Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<Post>();
	
	public User() {
		super();
	}

	public User(Long user_id,
			@NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 2, max = 100) String username,
			@NotNull(groups = { CreateUser.class, UpdateUser.class }) @NotEmpty(groups = { CreateUser.class,
					UpdateUser.class }) @Size(groups = { CreateUser.class,
							UpdateUser.class }, min = 8, max = 60) String password) {
		super();
		this.user_id = user_id;
		this.nickname = username;
		this.password = password;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Post> getPosts() {
		return posts;
	}
	
	/*
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	*/
	public static String getTableName() {
		return TABLE_NAME;
	}
	
}






















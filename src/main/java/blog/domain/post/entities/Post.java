package blog.domain.post.entities;

import org.springframework.format.annotation.DateTimeFormat;

import blog.domain.post.dateUtil.DateUtil;
import blog.domain.user.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Post.TABLE_NAME)
public class Post {
	public static final String TABLE_NAME = "post";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long post_id;
	
	@ManyToOne // many posts belongs to a user  
	@JoinColumn(name = "user_id", nullable = false, updatable = false) // foreign key
	private User user;
	
	@Column(name = "title", length = 50, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 50) 
	private String title;
	
	@Column(name = "author", length = 50, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 50) 
	private String author;
	
	@Column(name = "content", length = 250, nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 250) 
	private String content;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private String date;
		
	public Post() {
		super();
	}

	public Post(long post_id, User user, @NotNull @NotEmpty @Size(min = 1, max = 50) String title,
			@NotNull @NotEmpty @Size(min = 1, max = 250) String content) {
		super();
		this.post_id = post_id;
		this.user = user;
		this.title = title;
		this.author = user.getNickname();
		this.content = content;
		this.date = DateUtil.getCurrentDate();
	}

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}
		
}

















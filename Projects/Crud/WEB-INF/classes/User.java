public class User {
	
	private String id;
	private String name;
	private String username;
	private String password;
	private String role;

	public void setId(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username=username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setRole(String role) {
		this.role=role;
	}

	public String getRole() {
		return role;
	}
}
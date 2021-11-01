
public class User {
 private long id;
 private String name;
 private String loginId;
 private String loginPassword;
 private String role;
 private java.sql.Timestamp created;
 
public User() {

}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLoginId() {
	return loginId;
}

public void setLoginId(String loginId) {
	this.loginId = loginId;
}

public String getLoginPassword() {
	return loginPassword;
}

public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public java.sql.Timestamp getCreated() {
	return created;
}

public void setCreated(java.sql.Timestamp created) {
	this.created = created;
}



}

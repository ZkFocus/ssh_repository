package cn.zk.springmvc.entities;

public class User {

	private String username;

	private String password;

	private String tel;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public User(String username, String password, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", tel=" + tel + "]";
	}

	

}

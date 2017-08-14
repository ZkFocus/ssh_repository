package cn.zk.springmvc.entity;

public class User {

	private String name;
	private String tel;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", tel=" + tel + ", password=" + password + "]";
	}
	public User() {
		super();
	}
	public User(String name, String tel, String password) {
		super();
		this.name = name;
		this.tel = tel;
		this.password = password;
	}
	
}

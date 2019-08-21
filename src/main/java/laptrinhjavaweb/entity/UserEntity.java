package laptrinhjavaweb.entity;

import laptrinhjavaweb.annotation.Colum;
import laptrinhjavaweb.annotation.Entity;

@Entity
public class UserEntity extends Base{
	@Colum(name="username")
	private  String userName;
	@Colum(name="fullname")
	private  String fullName;
	@Colum(name="password")
	private String password;
	@Colum(name="status")
	private  Integer status;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

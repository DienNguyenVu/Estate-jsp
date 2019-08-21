package laptrinhjavaweb.entity;

import laptrinhjavaweb.annotation.Colum;

public class UserRole extends Base{
	@Colum(name="userid")
	private Long userId;
	@Colum(name="roleid")
	private Long roleId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}

package laptrinhjavaweb.repository.impl;

import laptrinhjavaweb.entity.UserEntity;
import laptrinhjavaweb.repository.IUserReponsitory;

public class UserReponsitory extends AbstractJDBC<UserEntity> implements IUserReponsitory{

	@Override
	public Long insert(UserEntity userEntity) {
		
		return null;
	}

}

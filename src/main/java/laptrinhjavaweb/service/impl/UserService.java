package laptrinhjavaweb.service.impl;
import laptrinhjavaweb.converter.UserConverter;
import laptrinhjavaweb.dto.UserDTO;
import laptrinhjavaweb.entity.UserEntity;
import laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Override
	public UserDTO save(UserDTO newUser) {
		UserConverter converter=new UserConverter();
		@SuppressWarnings("unused")
		UserEntity userEntity=converter.convertToEntity(newUser);
		return null;
	}

}

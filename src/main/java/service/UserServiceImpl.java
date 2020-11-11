package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import model.Login;
import model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}

}
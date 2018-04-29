package cn.photoflash.user.service.imp;

import org.junit.Test;

import cn.photoflash.user.bean.User;
import cn.photoflash.user.dao.UserDao;
import cn.photoflash.user.dao.imp.UserDaoImp;
import cn.photoflash.user.service.UserService;

/**
 * 服务层 依赖dao
 * 
 * @author yishuihan
 * 
 */
public class UserServiceImp implements UserService {

	private UserDao userDao = new UserDaoImp();

	@Override
	// 注册第一步需要判断用户名是否重复
	public void register(User user) {
		userDao.add(user);
	}

	@Override
	public void login(User user) throws UserException {
		User findUser = userDao.find(user);
		if (findUser == null || !(findUser.getPassword().equals(user.getPassword())))
			throw new UserException("用户或者密码错误");
	}

	@Override
	public User find(int id) {
		return userDao.findById(id);
	}

	@Override
	public void update(User user) {
		if (user.getEmail() == null && user.getPhone() != null) {
			userDao.updateByPhone(user);
		}
		if (user.getEmail() != null && user.getPhone() == null) {
			userDao.updateByEmail(user);
		}
	}

	@Test
	public void fun() {
		UserService userService = new UserServiceImp();
		User user = new User();
		user.setUid(3);
		user.setUsername("王五");
		user.setPassword("321");

		System.out.println(userService.find(1));
		// userService.update(user);
		System.out.println("----------------------");

	}

	@Override
	public User find(User user) {
		return userDao.find(user);
	}

	@Override
	/**
	 * 此方法用于校验用户名 邮箱 电话是否被使用 返回true时代表没有注册
	 * 
	 * @param phone
	 * @return
	 */
	public boolean check(User user) {
		User finduser = userDao.findByOthers(user);
		if (finduser == null)
			return true;
		else
			return false;
	}
}

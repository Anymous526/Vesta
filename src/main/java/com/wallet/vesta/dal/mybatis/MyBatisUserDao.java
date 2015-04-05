package com.wallet.vesta.dal.mybatis;

import java.util.List;

import com.wallet.vesta.dal.UserDao;
import com.wallet.vesta.domain.User;

public class IbatisUserDao extends SqlMapClientDaoSupport implements UserDao {
	@Override
	public User getUserById(String userId) {
		return (User) getSqlMapClientTemplate().queryForObject(
				"getUserByUserId", userId);
	}

	@Override
	public User getAuthenticatedUser(String userId, String password) {
		User user = new User();

		user.setUserId(userId);
		user.setPassword(password);

		return (User) getSqlMapClientTemplate().queryForObject(
				"getUserByUserIdAndPassword", user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getUserIdList() {
		return getSqlMapClientTemplate().queryForList("getUserIdList", null);
	}

	@Override
	public void insertUser(User user) {
		getSqlMapClientTemplate().update("insertUser", user);
		getSqlMapClientTemplate().update("insertAccount", user);
		getSqlMapClientTemplate().update("insertProfile", user);
	}

	@Override
	public void updateUser(User user) {
		getSqlMapClientTemplate().update("updateAccount", user);
		getSqlMapClientTemplate().update("updateProfile", user);

		if (!isEmpty(user.getPassword())) {
			getSqlMapClientTemplate().update("updateUser", user);
		}
	}
}

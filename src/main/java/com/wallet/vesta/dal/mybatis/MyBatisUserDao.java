package com.wallet.vesta.dal.mybatis;

import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.wallet.vesta.dal.BaseDao;
import com.wallet.vesta.dal.UserDao;
import com.wallet.vesta.domain.User;

public class MyBatisUserDao extends BaseDao implements UserDao {

	private static final long serialVersionUID = 1149294676276472432L;

	@Override
	public User getUserById(String userId) {
		return getSqlSession().selectOne("getUserByUserId", userId);
	}

	@Override
	public User getAuthenticatedUser(String userId, String password) {

		User user = new User();

		user.setUserId(userId);
		user.setPassword(password);

		return getSqlSession().selectOne("getUserByUserIdAndPassword", user);
	}

	@Override
	public List<String> getUserIdList() {
		return getSqlSession().selectList("getUserIdList");
	}

	@Override
	public void insertUser(User user) {
		getSqlSession().insert("insertUser", user);
		getSqlSession().insert("insertAccount", user);
		getSqlSession().insert("insertProfile", user);
	}

	@Override
	public void updateUser(User user) {
		getSqlSession().update("updateAccount", user);
		getSqlSession().update("updateProfile", user);

		if (StringUtils.isEmpty(user.getPassword())) {
			getSqlSession().update("updateUser", user);
		}
	}
}

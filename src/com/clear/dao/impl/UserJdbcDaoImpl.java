package com.clear.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import com.clear.dao.UserDao;
import com.clear.entity.User;

@Repository
public class UserJdbcDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sqlStr ="insert into user(username,password) values(?,?)";
		Object[] params = new Object[]{user.getUsername(),user.getPassword()};
        jdbcTemplate.update(sqlStr, params);
	}

	public boolean delUser(String id) {
		String sqlStr = "delete User u where u.id = ?";
		return (jdbcTemplate.update(sqlStr, new Object[]{id}) > 0);
	}

	public List<User> getAllUser() {
		String sqlStr = "select username,password from User";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlStr);
		Iterator<Map<String,Object>> iterator = list.iterator();
		List<User> userList = new ArrayList<User>();
		while(iterator.hasNext()){
			Map<String,Object> userMap = iterator.next();
			User user = new User();
			user.setId(Long.valueOf(userMap.get("id").toString()));
			user.setUsername(userMap.get("username").toString());
			user.setPassword(userMap.get("password").toString());
			userList.add(user);
		}
		return userList;
	}

	public boolean updateUser(User user) {
		String sqlStr = "update User u set u.username = ?,u.password=? where u.id = ?";
		return (jdbcTemplate.update(sqlStr, new Object[]{user.getUsername(),user.getPassword(),user.getId()}) > 0);
	}

	public User getUser(Long id) {
		String sqlStr = "select id,username,password from User u where u.id=?";
		final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        });
        return user;
	}
}

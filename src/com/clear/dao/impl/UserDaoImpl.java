package com.clear.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clear.dao.UserDao;
import com.clear.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);

	}

	public boolean delUser(String id) {
		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	public List<User> getAllUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		return list;
	}

	public boolean updateUser(User user) {
		String hql = "update User u set u.username = ?,u.password=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		query.setLong(2, user.getId());
		return (query.executeUpdate() > 0);
	}

	public User getUser(Long id) {
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		return (User) query.uniqueResult();
	}
}

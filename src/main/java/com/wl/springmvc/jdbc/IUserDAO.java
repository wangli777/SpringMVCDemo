package com.wl.springmvc.jdbc;

import com.wl.springmvc.entity.User;

import java.util.List;

public interface IUserDAO {
     void save(User user);
     void delete(int id);
     void update(User user);
     User get(int id);
     List<User> list();
}

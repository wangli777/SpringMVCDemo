package com.wl.springmvc.jdbc;

import com.wl.springmvc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/JdbcTest-context.xml")
public class JdbcTest {
    @Autowired
    private IUserDAO userDAO;
    @Test
    public void save() {
        User user = new User();
        user.setUserName("WangLi");
        user.setPassword("123456");
        userDAO.save(user);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void list() {
    }
}
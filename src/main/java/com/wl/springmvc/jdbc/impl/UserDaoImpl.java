package com.wl.springmvc.jdbc.impl;

import com.wl.springmvc.entity.User;
import com.wl.springmvc.jdbc.IUserDAO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO TUser(name,password) VALUES (?,?)",user.getUserName(),user.getPassword());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM TUSER WHERE ID = ?",id);
    }

    public void update(User user) {
        jdbcTemplate.update("UPDATE TUSER SET name =?,password=? WHERE id = ?",user.getUserName(),user.getPassword(),user.getId());
    }

    public User get(int id) {
        User user = jdbcTemplate.query("select * from TUser where id = ? ", new ResultSetExtractor<User>() {

            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()){
                    User u = new User();
                    u.setUserName(resultSet.getString("name"));
                    u.setPassword(resultSet.getString("password"));
                    u.setId(resultSet.getInt("id"));
                    return u;
                }
                return null;
            }
        },id);
        return user;
    }

    public List<User> list() {
        return null;
    }
}

package com.springmvc.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.User;

@Repository
public class JdbcUserRepository implements UserRepository {
  
  private JdbcOperations jdbc;

  @Autowired
  public JdbcUserRepository(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  public User save(User spitter) {
    jdbc.update(
        "insert into User (username, password, first_name, last_name, email)" +
        " values (?, ?, ?, ?, ?)",
        spitter.getUsername(),
        spitter.getPassword(),
        spitter.getFirstName(),
        spitter.getLastName(),
        spitter.getEmail());
    return spitter; // TODO: Determine value for id
  }

  public User findByUsername(String username) {
    return jdbc.queryForObject(
        "select id, username, null, first_name, last_name, email from User where username=?", 
        new UserRowMapper(), 
        username);
  }
  
  private static class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new User(
          rs.getLong("id"),
          rs.getString("username"),
          null,
          rs.getString("first_name"),
          rs.getString("last_name"),
          rs.getString("email"));
    }
  }

}

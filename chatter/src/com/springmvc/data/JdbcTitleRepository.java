package com.springmvc.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.Title;

@Repository
public class JdbcTitleRepository implements TitleRepository {

  private JdbcOperations jdbc;

  @Autowired
  public JdbcTitleRepository(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  public List<Title> findRecentSpittles() {
    return jdbc.query(
        "select id, message, created_at, latitude, longitude" +
        " from Title" +
        " order by created_at desc limit 20",
        new TitleRowMapper());
  }

  public List<Title> findSpittles(long max, int count) {
    return jdbc.query(
        "select id, message, created_at, latitude, longitude" +
        " from Title" +
        " where id < ?" +
        " order by created_at desc limit 20",
        new TitleRowMapper(), max);
  }

  public Title findOne(long id) {
    return jdbc.queryForObject(
        "select id, message, created_at, latitude, longitude" +
        " from Title" +
        " where id = ?",
        new TitleRowMapper(), id);
  }

  public void save(Title title) {
    jdbc.update(
        "insert into Title (message, created_at, latitude, longitude)" +
        " values (?, ?, ?, ?)",
        title.getMessage(),
        title.getTime(),
        title.getLatitude(),
        title.getLongitude());
  }

  private static class TitleRowMapper implements RowMapper<Title> {
    public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Title(
          rs.getLong("id"),
          rs.getString("message"), 
          rs.getDate("created_at"), 
          rs.getDouble("longitude"), 
          rs.getDouble("latitude"));
    }
  }
  
}

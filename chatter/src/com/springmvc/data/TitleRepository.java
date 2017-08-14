package com.springmvc.data;

import java.util.List;

import com.springmvc.entities.Title;

public interface TitleRepository {

  List<Title> findRecentSpittles();

  List<Title> findSpittles(long max, int count);
  
  Title findOne(long id);

  void save(Title title);

}

package com.springmvc.data;

import com.springmvc.entities.User;

public interface UserRepository {

  User save(User spitter);
  
  User findByUsername(String username);

}

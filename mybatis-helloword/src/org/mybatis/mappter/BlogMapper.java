package org.mybatis.mappter;

import org.apache.ibatis.annotations.Select;
import org.mybatis.entity.Blog;

public interface BlogMapper {
  @Select("SELECT * FROM blog WHERE id = #{id}")
  Blog selectBlog(int id);
}
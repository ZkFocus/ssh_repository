package com.mybatis.demo.dao;

import java.util.List;

import com.mybatis.demo.entity.Order;

public interface OrderMapper {
	public List<Order> getOrderByCustomerId(int id);
}

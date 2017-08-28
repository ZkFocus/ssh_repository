package com.mybatis.demo.dao;

import com.mybatis.demo.entity.Customer;

public interface CustomerMapper {
	
	public Customer getCustomerAndOrdersByName(String name);
	
	public Customer getCustomerByIdStep(Integer id);
}

package com.hibernate.demo.three;
/**
 * N ��
 * @author mbdn
 *
 */
public class Order {
	private Integer id;
	
	private String orderNo; 
	
	//��N�����1�˵�����
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", customer=" + customer + "]";
	}
	
	
}

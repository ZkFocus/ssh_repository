package com.struts2.demo.action;

public class OgnlDeepAction {
	
	private Person person;
	
	public String execute(){
		System.out.println(person.getAddress().getCity());
		return "success";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String sayHello(){
		return "hello ognl from action";
	}
	
}

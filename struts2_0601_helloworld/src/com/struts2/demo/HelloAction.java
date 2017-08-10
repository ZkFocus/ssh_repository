package com.struts2.demo;

public class HelloAction {
	/**
	 * 如果struts.xml 没指定method属性的话 
	 * Struts2默认调用execute方法 
	 * @return
	 */
	public String execute(){
		return "success";
	}
}

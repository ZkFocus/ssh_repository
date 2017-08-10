package com.struts2.action.demo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PrepareAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;

	/*alwaysInvokePrepare ���Ƹ÷�����ִ�� Ĭ��Ϊtrue 
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
		System.out.println("execute after prepareXXX()");
	}

	public String add() {
		System.out.println("add----------");
		return "add";
	}
	/*
	 * firstCallPrepareDo ����ʲôʱ���ִ��prepareDoXXX������ʲôʱ���ִ��prepareXXX����
	 */
	public void prepareDoAdd() {
		System.out.println("prepareDoAdd............");
	}
	public void prepareAdd(){
		System.out.println("prepareAdd........");
	}

	public String update() {
		return "update";
	}

	public void prepareUpdate() {
		System.out.println("prepareUpdate..............");
	}
}

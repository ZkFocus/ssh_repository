package com.ssh.demo.entity;

public class ComponentType {

	private Integer typeId;
	
	private String typeName;

	

	
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public ComponentType(Integer typeId) {
		super();
		this.typeId = typeId;
	}

	public ComponentType() {
		super();
	}
	
	
	
}

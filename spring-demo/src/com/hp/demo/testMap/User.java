package com.hp.demo.testMap;

import java.util.HashMap;
import java.util.Map;

public class User {

	private String name;

	private Map<String,Car> maps=new HashMap<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Car> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Car> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", maps=" + maps + "]";
	}


	
	
}

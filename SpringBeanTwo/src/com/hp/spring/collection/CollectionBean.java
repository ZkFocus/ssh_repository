package com.hp.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {

	private List someList;
	private Set someSet;
	private Map someMap;
	public List getSomeList() {
		return someList;
	}
	public void setSomeList(List someList) {
		this.someList = someList;
	}
	public Set getSomeSet() {
		return someSet;
	}
	public void setSomeSet(Set someSet) {
		this.someSet = someSet;
	}
	public Map getSomeMap() {
		return someMap;
	}
	public void setSomeMap(Map someMap) {
		this.someMap = someMap;
	}
	@Override
	public String toString() {
		return "CollectionBean [someList=" + someList + ", someSet=" + someSet + ", someMap=" + someMap + "]";
	}
	
}

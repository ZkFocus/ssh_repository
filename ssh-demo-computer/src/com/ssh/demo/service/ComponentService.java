package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.entity.Component;
import com.ssh.demo.entity.ComponentType;
import com.ssh.demo.entity.Page;
import com.ssh.demo.repository.ComponentRepository;

public class ComponentService {

	private ComponentRepository componentRepository;

	public void setComponentRepository(ComponentRepository componentRepository) {
		this.componentRepository = componentRepository;
	}

	public List<Component> getPage(int offset, int pageSize) {
		return componentRepository.getPage(offset, pageSize);
	}

	public List<ComponentType> getAll() {
		return componentRepository.getAll();
	}

	public void delete(Integer id) {
		componentRepository.delete(id);
	}

	public void saveOrUpdate(Component component) {
		componentRepository.saveOrUpdate(component);
	}

	public Component get(Integer id) {
		return componentRepository.get(id);
	}

	public Component getComponentById(Integer id){
		return componentRepository.getComponentById(id);
	}
	
	public List<Component> getComponentByTypeId(ComponentType componentType){
		return componentRepository.getComponentByTypeId(componentType);
	}
	
	public List<Component> getAllComponent() {
		return componentRepository.getAllComponent();
	}

	public Page getPages(int pageSize, int page) {
		Page pageBean = new Page();
		//总记录条数
		int allRows = componentRepository.getAllComponent().size();
		//总页数
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		//如果为0 则为第一页，否则为当前页
		int currentPage = pageBean.getCurPage(page);
		//当前页的起始记录号
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

		List<Component> list = getPage(offset, pageSize);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	
	public Component getComponentIdByComponentName(String componentName){
		return componentRepository.getComponentIdByComponentName(componentName);
	}
}

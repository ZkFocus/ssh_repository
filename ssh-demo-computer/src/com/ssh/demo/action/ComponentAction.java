package com.ssh.demo.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.demo.entity.Component;
import com.ssh.demo.entity.Page;
import com.ssh.demo.service.ComponentService;

public class ComponentAction extends ActionSupport implements RequestAware, ModelDriven<Component>, Preparable {
							
	private static final long serialVersionUID = 1L;

	private ComponentService componentService;

	private Map<String, Object> requestMap = null;

	public void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}

	private Integer componentId;

	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	
	private int page;
    

    public void setPage(int page){
        this.page = page;
    }
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;

	}

	public String list() {
		Page pagebean=componentService.getPages(5, page);
		requestMap.put("pageBean", pagebean);
		return "list";
	}

	
	public String delete() {
		componentService.delete(componentId);
		return SUCCESS;

	}

	public String input() {
		requestMap.put("componentTypes", componentService.getAll());
		return "input";
	}

	
	public void prepareInput() {
		if (componentId != null) {
			model = componentService.get(componentId);
		}
	}

	public String save() {
		componentService.saveOrUpdate(model);
		return SUCCESS;
	}
	/**
	 * 可以根据 id 来判断为 save 方法准备的 model 是 new 的还是从数据库获取的!
	 */
	public void prepareSave() {
		if (componentId == null) {
			model = new Component();
		} else {
			model = componentService.get(componentId);
		}
	}

	@Override
	public void prepare() throws Exception {
	}

	private Component model;

	@Override
	public Component getModel() {
		return model;
	}
	private String componentName;
	private String result;
	
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String verify(){
		System.out.println(componentName+"..");
		result="可以使用";
		return "success";
	}
	
}

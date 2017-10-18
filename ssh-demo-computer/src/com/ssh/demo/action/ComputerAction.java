package com.ssh.demo.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.demo.entity.Component;
import com.ssh.demo.entity.ComponentType;
import com.ssh.demo.entity.Computer;
import com.ssh.demo.entity.Page;
import com.ssh.demo.service.ComponentService;
import com.ssh.demo.service.ComputerService;

public class ComputerAction extends ActionSupport implements RequestAware, ModelDriven<Computer>, Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> requestMap = null;
	private ComputerService computerService;
	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	private ComponentService componentService;
	public void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}
	private Integer computerId;

	public void setComputerId(Integer computerId) {
		this.computerId = computerId;
	}
	
	public String input() {
		requestMap.put("componentCPU", componentService.getComponentByTypeId(new ComponentType(1)));
		requestMap.put("componentNC", componentService.getComponentByTypeId(new ComponentType(2)));
		requestMap.put("componentXK", componentService.getComponentByTypeId(new ComponentType(3)));
		requestMap.put("componentYP", componentService.getComponentByTypeId(new ComponentType(4)));
		requestMap.put("componentXSQ", componentService.getComponentByTypeId(new ComponentType(5)));
		if(computerId!=null){
			/**
			 * 用于回显选项值
			 */
			Component component=getComponentId(model.getCpu());
			requestMap.put("cpuValue", component.getComponentId());
			component=getComponentId(model.getDisplay());
			requestMap.put("xsqValue", component.getComponentId());
			component=getComponentId(model.getHdd());
			requestMap.put("ypValue", component.getComponentId());
			component=getComponentId(model.getMemory());
			requestMap.put("ncValue", component.getComponentId());
			component=getComponentId(model.getVideocard());
			requestMap.put("xkValue", model.getComputerId());
		}
		return "input";
	}

	/**
	 * 获取组件ID
	 * @return
	 */
	public Component getComponentId(String componentName){
		return componentService.getComponentIdByComponentName(componentName);
	}
	
	public String list() {
		requestMap.put("computers", computerService.getAllComputer());
		return "list";
	}
	
	public String delete() {
		computerService.delete(computerId);
		return SUCCESS;

	}
	public void prepareInput() {
		if (computerId != null) {
			model=computerService.get(computerId);
		}else{
			model=new Computer();
		}
	}

	public String save() {
		Component component=componentService.getComponentById(Integer.valueOf(model.getCpu()));
		model.setCpu(component.getComponentName());
		component=componentService.getComponentById(Integer.valueOf(model.getDisplay()));
		model.setDisplay(component.getComponentName());
		component=componentService.getComponentById(Integer.valueOf(model.getHdd()));
		model.setHdd(component.getComponentName());
		component=componentService.getComponentById(Integer.valueOf(model.getMemory()));
		model.setMemory(component.getComponentName());
		component=componentService.getComponentById(Integer.valueOf(model.getVideocard()));
		model.setVideocard(component.getComponentName());
		if(computerId!=null){
			model.setComputerId(computerId);
		}
		computerService.saveOrUpdate(model);
		
		return SUCCESS;
	}
	/**
	 * 可以根据 id 来判断为 save 方法准备的 model 是 new 的还是从数据库获取的!
	 */
	public void prepareSave() {
		if (computerId == null) {
			model = new Computer();
		} else {
			model = computerService.get(computerId);
		}
	}
	
	@Override
	public void prepare() throws Exception {
	}

	private Computer model;

	@Override
	public Computer getModel() {
		return model;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;

	}

}

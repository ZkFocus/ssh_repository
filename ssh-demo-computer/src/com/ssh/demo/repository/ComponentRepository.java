package com.ssh.demo.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.Component;
import com.ssh.demo.entity.ComponentType;

public class ComponentRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private ComponentTypeRepository componentTypeRepository;

	public void setComponentTypeRepository(ComponentTypeRepository componentTypeRepository) {
		this.componentTypeRepository = componentTypeRepository;
	}

	public List<ComponentType> getAll() {
		return componentTypeRepository.getAll();
	}
	public List<Component> getPage(int offset,int pageSize){
		Query query=getSession().createQuery("From Component");

		List<Component> components = query.setFirstResult(offset).setMaxResults(pageSize).list();
		return components;
	}
	public List<Component> getAllComponent(){
		String hql="From Component ";
		return getSession().createQuery(hql).list();
	}
	public List<Component> getComponentByTypeId(ComponentType componentType){
		String hql="From Component c where c.componentType = ?";
		return getSession().createQuery(hql).setParameter(0, componentType).list();
	}
	
	public Component getComponentById(Integer id){
		String hql="From Component c where c.id = ?";
		return (Component) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}
	
	public void delete(Integer id){
		String hql = "DELETE FROM Component  WHERE id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	
	public void saveOrUpdate(Component component){
		getSession().saveOrUpdate(component);
	}
	
	
	public Component get(Integer id){
		return (Component) getSession().get(Component.class, id);
	}
	
	public Component getComponentIdByComponentName(String componentName){
		String hql=" From Component c where c.componentName = ?";
		return (Component) getSession().createQuery(hql).setParameter(0, componentName).uniqueResult();
				
	}
	
}

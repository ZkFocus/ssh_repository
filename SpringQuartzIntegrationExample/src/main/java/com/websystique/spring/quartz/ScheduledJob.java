package com.websystique.spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.websystique.spring.scheduling.AnotherBean;

public class ScheduledJob extends QuartzJobBean{

	
	private AnotherBean anotherBean; 
	
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		anotherBean.printAnotherMessage();
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}
}

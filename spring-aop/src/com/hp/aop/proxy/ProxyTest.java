package com.hp.aop.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Performance prPerformance=new Guitar();
		Performance perform=new PerformanceProxy(prPerformance).getLogProxy();
		perform.perform();
		
	}
}

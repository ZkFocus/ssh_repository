package com.spring.now;

import com.spring.old.CHello;
import com.spring.old.EHello;
import com.spring.old.IHello;

public class BeanFactory {

	public static IHello getInstance(String type) {
		if (type.equals("chinese")) {
			return new CHello();
		} else if (type.equals("english")) {
			return new EHello();
		} else {
			return null;
		}
	}
}

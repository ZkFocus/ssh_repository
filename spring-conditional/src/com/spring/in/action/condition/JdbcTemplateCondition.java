package com.spring.in.action.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JdbcTemplateCondition implements Condition {

	/**
	 * 类路径下如果存在org.springframework.jdbc.core.JdbcTemplate类的时候
	 * 条件为true
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

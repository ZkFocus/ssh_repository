package cn.zk.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 处理异常
 * @author mbdn
 *@ResponseStatus 处理响应码
 *			code 	响应码
 *			reason 	错误信息
 */
@ResponseStatus(
		code=HttpStatus.INTERNAL_SERVER_ERROR,
		reason="没有该用户")
public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

}

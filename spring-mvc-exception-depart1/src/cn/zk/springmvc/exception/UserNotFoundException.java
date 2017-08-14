package cn.zk.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus 处理HTTP请求的响应码
 * 			value  用于映射响应码
 * 			reason 用于映射原因
 * @author mbdn
 *
 */
@ResponseStatus(
		value=HttpStatus.INTERNAL_SERVER_ERROR,
		reason="该用户不存在")	
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;


}

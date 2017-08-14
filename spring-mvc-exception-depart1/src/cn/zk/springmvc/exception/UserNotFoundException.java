package cn.zk.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus ����HTTP�������Ӧ��
 * 			value  ����ӳ����Ӧ��
 * 			reason ����ӳ��ԭ��
 * @author mbdn
 *
 */
@ResponseStatus(
		value=HttpStatus.INTERNAL_SERVER_ERROR,
		reason="���û�������")	
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;


}

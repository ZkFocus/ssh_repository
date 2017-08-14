package cn.zk.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @ResponseStatus
 * �����������϶�����ʹ��
 * @author mbdn
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="User Not Found")
public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

}

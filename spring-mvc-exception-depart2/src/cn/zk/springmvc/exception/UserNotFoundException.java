package cn.zk.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * �����쳣
 * @author mbdn
 *@ResponseStatus ������Ӧ��
 *			code 	��Ӧ��
 *			reason 	������Ϣ
 */
@ResponseStatus(
		code=HttpStatus.INTERNAL_SERVER_ERROR,
		reason="û�и��û�")
public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

}

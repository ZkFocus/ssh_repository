package com.atguigu.spring.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookShopService {

	@Autowired
	private BookShopRepository bookShopRepository;
	
	
	
	//�������ע��
	//1.ʹ�� propagation ָ������Ĵ�����Ϊ, ����ǰ�����񷽷�������һ�����񷽷�����ʱ
	//���ʹ������, Ĭ��ȡֵΪ REQUIRED, ��ʹ�õ��÷���������
	//REQUIRES_NEW: �����Լ�������, ���õ����񷽷������񱻹���. 
	//2.ʹ�� isolation ָ������ĸ��뼶��, ��õ�ȡֵΪ READ_COMMITTED
	//3.Ĭ������� Spring ������ʽ��������е�����ʱ�쳣���лع�. Ҳ����ͨ����Ӧ��
	//���Խ�������. ͨ�������ȥĬ��ֵ����. 
	//4.ʹ�� readOnly ָ�������Ƿ�Ϊֻ��. ��ʾ�������ֻ��ȡ���ݵ�����������, 
	//�������԰������ݿ������Ż�����. �������һ��ֻ��ȡ���ݿ�ֵ�ķ���, Ӧ���� readOnly=true
	//5.ʹ�� timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��.  
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={UserAccountException.class})
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)

	public void purchase(String username, String isbn) {
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}*/
		
		//1. ��ȡ��ĵ���
		int price = bookShopRepository.findBookPriceByIsbn(isbn);
		
		//2. �������Ŀ��
		bookShopRepository.updateBookStock(isbn);
		
		//3. �����û����
		bookShopRepository.updateUserAccount(username, price);
	}

}

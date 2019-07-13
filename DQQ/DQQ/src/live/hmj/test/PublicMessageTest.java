package live.hmj.test;

import live.hmj.dal.PublicMessageDal;
import live.hmj.entity.PublicMessage;

public class PublicMessageTest {
	public static void main(String[] args) {
		PublicMessageDal dal=new PublicMessageDal();
		PublicMessage message=new PublicMessage();
		message.setUserName("黄茂俊");
		message.setDate("1949-10-01");
		message.setMessage("祝贺新中国成立，毛主席万岁！");
		dal.insertPublicMessage(message);
	}
}

package live.hmj.test;

import live.hmj.dal.PublicMessageDal;
import live.hmj.entity.PublicMessage;

public class PublicMessageTest {
	public static void main(String[] args) {
		PublicMessageDal dal=new PublicMessageDal();
		PublicMessage message=new PublicMessage();
		message.setUserName("��ï��");
		message.setDate("1949-10-01");
		message.setMessage("ף�����й�������ë��ϯ���꣡");
		dal.insertPublicMessage(message);
	}
}

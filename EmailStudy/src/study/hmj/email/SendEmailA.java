package study.hmj.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailA {
	public static void testJavaMail() throws Exception{
	    //1.设置邮件的一些信息
        Properties props = new Properties();
        //发送邮件的服务器地址
//        props.put("mail.smtp.host", "smtp.qq.com");//  stmp.qq.com   smtp.sina.com stmp.163.com
        props.put("mail.smtp.host", "smtp.163.com");//  stmp.qq.com   smtp.sina.com stmp.163.com
        //设置发送邮件使用的传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        //并且要设置使用验证：
        props.setProperty("mail.smtp.auth", "true");
        //使用 STARTTLS安全连接:
        props.setProperty("mail.smtp.starttls.enable","true"); 
        // 开启debug模式，能够在控制台看到发送邮件的过程
    	props.setProperty("mail.debug", "true");
 
        //2.创建Session对象
        Session session =Session.getInstance(props);
 
        //3.创建出MimeMessage，邮件的消息对象
        MimeMessage message = new MimeMessage(session);
 
        //4.设置发件人
//        Address fromAddr = new InternetAddress("3220837922@qq.com");
        Address fromAddr = new InternetAddress("hmj38385438@163.com");
        message.setFrom(fromAddr);
 
        //5.设置收件人
//        Address toAddr = new InternetAddress("hmj38385438@163.com");//hmj38385438@163.com
        Address toAddr = new InternetAddress("3220837922@qq.com");
        message.setRecipient(RecipientType.TO, toAddr);
 
        //6.设置邮件的主题
        message.setSubject("DQQ验证码");
 
        //7.设置邮件的正文
//        message.setText("您好，欢迎注册DQQ公共聊天室！您的注册验证码为666666，打死你也不要告诉别人哦~");//您好，欢迎注册DQQ公共聊天室！您的注册验证码为666666，打死你也不要告诉别人哦~   
        message.setText("hello! welcome to register DQQ online website and your Verification Code is 123456.");
//        message.setText("123");
        //8.得到传输对象
        Transport transport = session.getTransport();
        //连接SMTP服务器
        //第一个参数是你用来发送邮件的邮箱的SMTP服务器地址，第二个是你的邮箱地址，第三个是授权码
//        transport.connect("smtp.qq.com", "3220837922@qq.com", "这是QQ邮箱的授权码");
        transport.connect("smtp.163.com", "hmj38385438@163.com", "这是163邮箱的授权码");
        //设置需要发送的信息以及收件人地址，第二个参数是个Address数组：Address[]
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("关闭");
	 }
     public static void main(String[] args) {
		try {
			testJavaMail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

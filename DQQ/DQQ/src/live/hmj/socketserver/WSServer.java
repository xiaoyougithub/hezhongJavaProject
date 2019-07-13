package live.hmj.socketserver;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import live.hmj.dal.PublicMessageDal;
import live.hmj.entity.PublicMessage;
import live.hmj.util.PresentTime;

@ServerEndpoint("/ws")
public class WSServer 
{	
    //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�  
    private static int onlineCount = 0;  

    private static ConcurrentHashMap<MySession, WSServer> ssMap= new ConcurrentHashMap<MySession, WSServer>();

    //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������  
    private MySession mySession=new MySession();  
    private  PublicMessageDal dal=new PublicMessageDal();
	private PublicMessage publicMessage=new PublicMessage();
	private List<PublicMessage> list=null;

    /** 
     * 	���ӽ����ɹ����õķ��� 
     * @param session  ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷������� 
     */  
    @OnOpen  
    public void onOpen(Session session){
        this.mySession.setSession(session);  
        ssMap.put(mySession, this);
        addOnlineCount();           //��������1  
//      System.out.println(session.getRequestURI());//��Դ·��
//      System.out.println(session.getBasicRemote());
        System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());  
        try {
			list=dal.getList();
			for(PublicMessage publicMessage:list) {
				ssMap.get(mySession).sendMessage(publicMessage.getUserName()+"("+publicMessage.getDate()+"):"+publicMessage.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /** 
     * 	���ӹرյ��õķ��� 
     */  
    @OnClose  
    public void onClose(){  
        ssMap.remove(mySession);
        subOnlineCount();           //��������1  
        System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());  
    }  
    /** 
     * 	�յ��ͻ�����Ϣ����õķ��� 
     * @param message �ͻ��˷��͹�������Ϣ 
     * @param session ��ѡ�Ĳ��� 
     */
    @OnMessage  
    public void onMessage(String message, Session Ssession){  
        System.out.println("���Կͻ��˵�Ⱥ����Ϣ:"+message); 
        String messages[]=message.split(":");
        if(messages[0].equals("username")) {
        	try {
//        		mySession.setUsername(messages[1]);
//				ssMap.get(mySession).sendMessage(messages[1]+"����Ⱥ�ģ�");
        		 for(MySession s:ssMap.keySet()) {
                 		ssMap.get(s).sendMessage(messages[1]+"�����ˣ��б�����������~");
                 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if (messages[0].equals("departure")) {
        	try {
//        		mySession.setUsername(messages[1]);
//				ssMap.get(mySession).sendMessage(messages[1]+"����Ⱥ�ģ�");
        		 for(MySession s:ssMap.keySet()) {
                 		ssMap.get(s).sendMessage(messages[1]+"�����ˣ����ǻ��������~");
                 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
        	//Ⱥ����Ϣ,��Ⱥ���󱣴浽���ݿ���
            for(MySession s:ssMap.keySet()) {
            	try {
    				ssMap.get(s).sendMessage(messages[1]+"("+PresentTime.getPresentTime()+"):"+messages[2]);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
            publicMessage.setUserName(messages[1]);
    		publicMessage.setDate(PresentTime.getPresentTime());
    		publicMessage.setMessage(messages[2]);
    		dal.insertPublicMessage(publicMessage);
		}        
//        WSServer tmp = ssMap.get(session);
//        try {
//            tmp.sendMessage(message);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
    }  

    /** 
     * 	��������ʱ���� 
     * @param session 
     * @param error 
     */  
    @OnError  
    public void onError(Session session, Throwable error) {
        System.out.println("��������");  
        error.printStackTrace();  
    }  
    /** 
     * 	������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ����� 
     * @param message 
     * @throws IOException 
     */  
    public void sendMessage(String message) throws IOException{  
        this.mySession.getSession().getBasicRemote().sendText(message);  
        //this.session.getAsyncRemote().sendText(message);  
    }
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
    public static synchronized void addOnlineCount() {  
        WSServer.onlineCount++;  
    }  
    public static synchronized void subOnlineCount() {
        WSServer.onlineCount--;  
    }
}
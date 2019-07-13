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
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。  
    private static int onlineCount = 0;  

    private static ConcurrentHashMap<MySession, WSServer> ssMap= new ConcurrentHashMap<MySession, WSServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据  
    private MySession mySession=new MySession();  
    private  PublicMessageDal dal=new PublicMessageDal();
	private PublicMessage publicMessage=new PublicMessage();
	private List<PublicMessage> list=null;

    /** 
     * 	连接建立成功调用的方法 
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据 
     */  
    @OnOpen  
    public void onOpen(Session session){
        this.mySession.setSession(session);  
        ssMap.put(mySession, this);
        addOnlineCount();           //在线数加1  
//      System.out.println(session.getRequestURI());//资源路径
//      System.out.println(session.getBasicRemote());
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());  
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
     * 	连接关闭调用的方法 
     */  
    @OnClose  
    public void onClose(){  
        ssMap.remove(mySession);
        subOnlineCount();           //在线数减1  
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());  
    }  
    /** 
     * 	收到客户端消息后调用的方法 
     * @param message 客户端发送过来的消息 
     * @param session 可选的参数 
     */
    @OnMessage  
    public void onMessage(String message, Session Ssession){  
        System.out.println("来自客户端的群发消息:"+message); 
        String messages[]=message.split(":");
        if(messages[0].equals("username")) {
        	try {
//        		mySession.setUsername(messages[1]);
//				ssMap.get(mySession).sendMessage(messages[1]+"加入群聊！");
        		 for(MySession s:ssMap.keySet()) {
                 		ssMap.get(s).sendMessage(messages[1]+"上线了，有本事你就来怼我~");
                 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if (messages[0].equals("departure")) {
        	try {
//        		mySession.setUsername(messages[1]);
//				ssMap.get(mySession).sendMessage(messages[1]+"加入群聊！");
        		 for(MySession s:ssMap.keySet()) {
                 		ssMap.get(s).sendMessage(messages[1]+"下线了，我们会想念你的~");
                 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
        	//群发消息,先群发后保存到数据库中
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
     * 	发生错误时调用 
     * @param session 
     * @param error 
     */  
    @OnError  
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");  
        error.printStackTrace();  
    }  
    /** 
     * 	这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。 
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
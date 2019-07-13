package live.hmj.socketserver;
import javax.websocket.Session;

public class MySession {
	private String username;
	private Session session;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}

package javaBefore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SimpleJavaFX extends Application{

	public void start(Stage stage) throws Exception {
/*      	
 * 		1��һ��javaFX������Ҫ�̳�Application�࣬���Ҹ�дstart������
 * 		2��start������һ�㴴��һ����̨���ٴ���������Ҫ�ĸ���UI�ؼ����ٴ���һ�����������峡���Ĺ���Լ��ѿؼ����õ��������У�
 * 		3���������̨��������
*/		Button button=new Button("ok");
		Scene scene=new Scene(button,600,450);
		stage.setScene(scene);
		stage.setTitle("title");
		stage.show();
//		Stage stage2=new Stage();
//		stage2.setTitle("��ï��д�漯2");
//		stage2.setScene(new Scene(new Button("��ï��2"),200,200));
//		stage2.show();stage2.setResizable(false);
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

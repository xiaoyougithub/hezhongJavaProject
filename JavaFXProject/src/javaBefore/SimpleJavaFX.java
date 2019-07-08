package javaBefore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SimpleJavaFX extends Application{

	public void start(Stage stage) throws Exception {
/*      	
 * 		1、一个javaFX程序需要继承Application类，并且覆写start方法；
 * 		2、start方法中一般创建一个舞台，再创建场景需要的各种UI控件，再创建一个场景，定义场景的规格以及把控件布置到场景当中；
 * 		3、最后让舞台亮起来。
*/		Button button=new Button("ok");
		Scene scene=new Scene(button,600,450);
		stage.setScene(scene);
		stage.setTitle("title");
		stage.show();
//		Stage stage2=new Stage();
//		stage2.setTitle("黄茂俊写真集2");
//		stage2.setScene(new Scene(new Button("黄茂俊2"),200,200));
//		stage2.show();stage2.setResizable(false);
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

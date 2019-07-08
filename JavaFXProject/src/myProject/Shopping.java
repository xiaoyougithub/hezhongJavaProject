package myProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Shopping extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FlowPane pane=new FlowPane();
		pane.setVgap(20);
		pane.setHgap(10);
		Label name=new Label("please input name:");
		TextField nameTextField=new TextField();
		Label password=new Label("please input psaaword:");
		TextField passwordTextFiled=new TextField("password");
		Button button=new Button("ok");		
		pane.getChildren().addAll(name,nameTextField,password,passwordTextFiled,button);
		Scene scene=new Scene(pane, 200, 300);
		stage.setScene(scene);
		stage.setTitle("ÎÖ¶ûÂê×ÔÖú¹ºÎïµÇÂ¼Ð¡³ÌÐò");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

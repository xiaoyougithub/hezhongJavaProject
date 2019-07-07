package javaBefore;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.control.Alert;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Chess extends Application {

	HBox pane = new HBox();
	GridPane grid = new GridPane();
	GridPane right = new GridPane();

	private int TotStep = 0;	// 总步数
	private long startTime;
	private Text totTimeText = new Text("0");
	private Text currentTimeText = new Text("0");
	private Text totStepText = new Text("0");
	private int GridSize = 20;		// 网格的数量大小	20*20
	private int[][] G = new int[GridSize][GridSize];
	private Circle cir = new Circle(40);	// 当前的棋子

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// java.util.Arrays.fill(G, -1);
		Application.launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		startTime = System.currentTimeMillis();		// 获取程序开始时的时间，以便算出运行时间
		EventHandler<ActionEvent> even = new EventHandler<ActionEvent>() {	// 每秒更新游戏时间

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				long time = System.currentTimeMillis();	//	获取当前时间，用 （当前时间-开始时间）便是毫秒单位的运行时间
				totTimeText.setText(String.valueOf((time - startTime) / 1000));
			}
		};

		Timeline tl;
		tl = new Timeline(new KeyFrame(Duration.millis(1000), even));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();

		init(tl);	// 初始化
		// G;

		Text text1 = new Text("总时间：");
		Text text2 = new Text("当前时间：");
		Text text3 = new Text("总步数：");
		Text text4 = new Text("当前选手：");

		right.add(text1, 0, 0); // 显示 总时间
		right.add(totTimeText, 1, 0);

		// right.add(text2, 0, 1); //显示 当前时间
		// right.add(currentTimeText, 1, 1);

		right.add(text3, 0, 2); // 显示 总步数
		right.add(totStepText, 1, 2);

		right.add(text4, 0, 3); // 显示 当前玩家
		right.add(cir, 1, 3);

		pane.getChildren().addAll(grid, right);
		right.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 900, 900);
		stage.setScene(scene);
		stage.setTitle("五子棋");
		stage.show();

	}

	private void init(final Timeline tl) {	// 初始化每个格子
		for (int i = 0; i < GridSize; i++) {
			for (int j = 0; j < GridSize; j++) {
				G[i][j] = -1;
				Button bt = new Button();
				bt.setPrefSize(45, 45);
				bt.setOnAction(new EventHandler<ActionEvent>() {	// 每个格子对应按钮的事件监听、处理

					@Override
					public void handle(ActionEvent e) {
						// TODO 自动生成的方法存根

						Circle c = new Circle(17);
						Object obj = e.getSource();
						TotStep++;
						totStepText.setText("" + TotStep);
						int x = grid.getColumnIndex((Node) obj);
						int y = grid.getRowIndex((Node) obj);
						Color currentColor = null;
						G[x][y] = TotStep % 2;
						if (TotStep % 2 == 0) {
							currentColor = Color.BLACK;
							c.setFill(currentColor);
							cir.setFill(currentColor);

						} else {
							currentColor = Color.WHITE;
							c.setFill(currentColor);
							cir.setFill(currentColor);
						}
						grid.add(c, x, y);

						checkWinner(tl, x, y, currentColor);
					}

					private void checkWinner(Timeline tl, int x, int y, Color currentColor) {	// 检查游戏是否结束
						int h = 1;
						int v = 1;
						int o = 1;
						int o2 = 1;
						for (int i = 1; i < 5; i++) { // 下
							if (y + i < 0 || y + i >= GridSize || G[x][y + i] != TotStep % 2)
								break;
							if (G[x][y + i] == TotStep % 2)
								v++;
						}
						for (int i = 1; i < 5; i++) { // 上
							if (y - i < 0 || y - i >= GridSize || G[x][y - i] != TotStep % 2)
								break;
							if (G[x][y - i] == TotStep % 2)
								v++;
						}
						for (int i = 1; i < 5; i++) { // 右
							if (x + i < 0 || x + i >= GridSize || G[x + i][y] != TotStep % 2)
								break;
							if (G[x + i][y] == TotStep % 2)
								h++;
						}
						for (int i = 1; i < 5; i++) { // 左
							if (x - i < 0 || x - i >= GridSize || G[x - i][y] != TotStep % 2)
								break;
							if (G[x - i][y] == TotStep % 2)
								h++;
						}
						for (int i = 1; i < 5; i++) { // 左上
							if (x - i < 0 || x - i >= GridSize || y - i < 0 || y - i >= GridSize
									|| G[x - i][y - i] != TotStep % 2)
								break;
							if (G[x - i][y - i] == TotStep % 2)
								o++;
						}
						for (int i = 1; i < 5; i++) { // 右下
							if (x + i < 0 || x + i >= GridSize || y + i < 0 || y + i >= GridSize
									|| G[x + i][y + i] != TotStep % 2)
								break;
							if (G[x + i][y + i] == TotStep % 2)
								o++;
						}
						for (int i = 1; i < 5; i++) { // 左下
							if (x - i < 0 || x - i >= GridSize || y + i < 0 || y + i >= GridSize
									|| G[x - i][y + i] != TotStep % 2)
								break;
							if (G[x - i][y + i] == TotStep % 2)
								o2++;
						}
						for (int i = 1; i < 5; i++) { // 右上
							if (x + i < 0 || x + i >= GridSize || y - i < 0 || y - i >= GridSize
									|| G[x + i][y - i] != TotStep % 2)
								break;
							if (G[x + i][y - i] == TotStep % 2)
								o2++;
						}

						if (h >= 5 || v >= 5 || o >= 5 || o2 >= 5) {	//	如果已连成五子
							
							tl.stop();			//停止计时
							
							System.out.println(currentColor + " win!");
							
							Alert alert = new Alert(Alert.AlertType.INFORMATION);// 弹出对话框
							String winner;
							if (TotStep % 2 == 1)
								winner = "白色方";
							else
								winner = "黑色方";
							
							alert.setTitle("游戏结束");		
							alert.setHeaderText(winner + "获胜");
							alert.setContentText("游戏总时间：" + totTimeText.getText() + "秒\n" + "游戏总步数：" + TotStep + "步");		//显示该局游戏信息
							alert.showAndWait();
							System.exit(0);		// 结束游戏并退出程序
						}
					}
				});
				grid.add(bt, i, j);
			}
		}
	}

}
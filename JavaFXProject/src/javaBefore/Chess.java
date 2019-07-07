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

	private int TotStep = 0;	// �ܲ���
	private long startTime;
	private Text totTimeText = new Text("0");
	private Text currentTimeText = new Text("0");
	private Text totStepText = new Text("0");
	private int GridSize = 20;		// �����������С	20*20
	private int[][] G = new int[GridSize][GridSize];
	private Circle cir = new Circle(40);	// ��ǰ������

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// java.util.Arrays.fill(G, -1);
		Application.launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		startTime = System.currentTimeMillis();		// ��ȡ����ʼʱ��ʱ�䣬�Ա��������ʱ��
		EventHandler<ActionEvent> even = new EventHandler<ActionEvent>() {	// ÿ�������Ϸʱ��

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				long time = System.currentTimeMillis();	//	��ȡ��ǰʱ�䣬�� ����ǰʱ��-��ʼʱ�䣩���Ǻ��뵥λ������ʱ��
				totTimeText.setText(String.valueOf((time - startTime) / 1000));
			}
		};

		Timeline tl;
		tl = new Timeline(new KeyFrame(Duration.millis(1000), even));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();

		init(tl);	// ��ʼ��
		// G;

		Text text1 = new Text("��ʱ�䣺");
		Text text2 = new Text("��ǰʱ�䣺");
		Text text3 = new Text("�ܲ�����");
		Text text4 = new Text("��ǰѡ�֣�");

		right.add(text1, 0, 0); // ��ʾ ��ʱ��
		right.add(totTimeText, 1, 0);

		// right.add(text2, 0, 1); //��ʾ ��ǰʱ��
		// right.add(currentTimeText, 1, 1);

		right.add(text3, 0, 2); // ��ʾ �ܲ���
		right.add(totStepText, 1, 2);

		right.add(text4, 0, 3); // ��ʾ ��ǰ���
		right.add(cir, 1, 3);

		pane.getChildren().addAll(grid, right);
		right.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 900, 900);
		stage.setScene(scene);
		stage.setTitle("������");
		stage.show();

	}

	private void init(final Timeline tl) {	// ��ʼ��ÿ������
		for (int i = 0; i < GridSize; i++) {
			for (int j = 0; j < GridSize; j++) {
				G[i][j] = -1;
				Button bt = new Button();
				bt.setPrefSize(45, 45);
				bt.setOnAction(new EventHandler<ActionEvent>() {	// ÿ�����Ӷ�Ӧ��ť���¼�����������

					@Override
					public void handle(ActionEvent e) {
						// TODO �Զ����ɵķ������

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

					private void checkWinner(Timeline tl, int x, int y, Color currentColor) {	// �����Ϸ�Ƿ����
						int h = 1;
						int v = 1;
						int o = 1;
						int o2 = 1;
						for (int i = 1; i < 5; i++) { // ��
							if (y + i < 0 || y + i >= GridSize || G[x][y + i] != TotStep % 2)
								break;
							if (G[x][y + i] == TotStep % 2)
								v++;
						}
						for (int i = 1; i < 5; i++) { // ��
							if (y - i < 0 || y - i >= GridSize || G[x][y - i] != TotStep % 2)
								break;
							if (G[x][y - i] == TotStep % 2)
								v++;
						}
						for (int i = 1; i < 5; i++) { // ��
							if (x + i < 0 || x + i >= GridSize || G[x + i][y] != TotStep % 2)
								break;
							if (G[x + i][y] == TotStep % 2)
								h++;
						}
						for (int i = 1; i < 5; i++) { // ��
							if (x - i < 0 || x - i >= GridSize || G[x - i][y] != TotStep % 2)
								break;
							if (G[x - i][y] == TotStep % 2)
								h++;
						}
						for (int i = 1; i < 5; i++) { // ����
							if (x - i < 0 || x - i >= GridSize || y - i < 0 || y - i >= GridSize
									|| G[x - i][y - i] != TotStep % 2)
								break;
							if (G[x - i][y - i] == TotStep % 2)
								o++;
						}
						for (int i = 1; i < 5; i++) { // ����
							if (x + i < 0 || x + i >= GridSize || y + i < 0 || y + i >= GridSize
									|| G[x + i][y + i] != TotStep % 2)
								break;
							if (G[x + i][y + i] == TotStep % 2)
								o++;
						}
						for (int i = 1; i < 5; i++) { // ����
							if (x - i < 0 || x - i >= GridSize || y + i < 0 || y + i >= GridSize
									|| G[x - i][y + i] != TotStep % 2)
								break;
							if (G[x - i][y + i] == TotStep % 2)
								o2++;
						}
						for (int i = 1; i < 5; i++) { // ����
							if (x + i < 0 || x + i >= GridSize || y - i < 0 || y - i >= GridSize
									|| G[x + i][y - i] != TotStep % 2)
								break;
							if (G[x + i][y - i] == TotStep % 2)
								o2++;
						}

						if (h >= 5 || v >= 5 || o >= 5 || o2 >= 5) {	//	�������������
							
							tl.stop();			//ֹͣ��ʱ
							
							System.out.println(currentColor + " win!");
							
							Alert alert = new Alert(Alert.AlertType.INFORMATION);// �����Ի���
							String winner;
							if (TotStep % 2 == 1)
								winner = "��ɫ��";
							else
								winner = "��ɫ��";
							
							alert.setTitle("��Ϸ����");		
							alert.setHeaderText(winner + "��ʤ");
							alert.setContentText("��Ϸ��ʱ�䣺" + totTimeText.getText() + "��\n" + "��Ϸ�ܲ�����" + TotStep + "��");		//��ʾ�þ���Ϸ��Ϣ
							alert.showAndWait();
							System.exit(0);		// ������Ϸ���˳�����
						}
					}
				});
				grid.add(bt, i, j);
			}
		}
	}

}
package javaBefore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class RandomTest {
	public static void main(String[] args) throws IOException {
		new test();
	}
}

	class test extends JFrame implements ActionListener {
		private JTextArea text = new JTextArea("Welcom");
		private JPanel panel = new JPanel();
	private JButton _start;
	private JButton _stop;
	private boolean flag = false;
	private Container c = getContentPane();
	private String[] str = { "»ÆÃ¯ÖÇ", "»ÆÃ¯Íû", "ÁõÎª¾ü", "Áõ°®Ó¢", "ÁõÑÞ·Ò", "»ÆÊ©", "»ÆæÃ",
	"»ÆÓêÇç", "»ÆÐÀìÏ", "»ÆÐÀâù", "»ÆÓêºç", "»ÆÃ¯Ç¿", "Áõè÷¿¡", "Íôº­", "¹ÙÇÙ", "¹ÙÑÐ", "¹Ù¾¸",
	"¸µÀöÇå", "»ÆÃ¯¿¡", "¸µìÇ±ó", "Àî³¿êØ", "Ã«Ã«" };
	private int count = 0;

	public test() throws IOException {
	setSize(400, 400);
	text.setFont(new Font("",Font.BOLD,50));
	_start = new JButton("start");
	_stop = new JButton("stop");
	_stop.setEnabled(false);
	text.setEnabled(false);
	panel.add(_start);
	panel.add(_stop);
	_start.addKeyListener(new KeyListener() {
	public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_SPACE)
	count++;
	if (count % 2 == 0) {
	_start.setEnabled(true);
	_stop.setEnabled(false);
	_start.setFocusable(true);
	_stop.setFocusable(false);
	flag = false;
	} else if (count % 2 == 1) {
	_start.setEnabled(false);
	_stop.setEnabled(true);
	_stop.setFocusable(true);
	_start.setFocusable(false);
	flag = true;
	}
}

public void keyReleased(KeyEvent arg0) {
}

public void keyTyped(KeyEvent arg0) {
}
});
_stop.addKeyListener(new KeyListener() {
public void keyPressed(KeyEvent e) {
if (e.getKeyCode() == KeyEvent.VK_SPACE)
count++;
if (count % 2 == 0) {
_start.setEnabled(true);
_stop.setEnabled(false);
_start.setFocusable(true);
_stop.setFocusable(false);
flag = false;
} else if (count % 2 == 1) {
_start.setEnabled(false);
_stop.setEnabled(true);
_stop.setFocusable(true);
_start.setFocusable(false);
flag = true;
}
}

public void keyReleased(KeyEvent arg0) {
}

public void keyTyped(KeyEvent arg0) {
}
});
_start.addActionListener(this);
_stop.addActionListener(this);
c.add(text, BorderLayout.NORTH);
c.add(panel, BorderLayout.SOUTH);
this.setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLocation(300, 300);
RUN();
}

public void actionPerformed(ActionEvent event) {
Object obj = event.getSource();
if (obj == _start) {
flag = true;
_start.setEnabled(false);
_stop.setEnabled(true);
text.setEnabled(false);
_start.setFocusable(false);
_stop.setFocusable(true);
} else if (obj == _stop) {
flag = false;
_start.setEnabled(true);
_stop.setEnabled(false);
text.setEnabled(false);
_start.setFocusable(true);
_stop.setFocusable(false);
}
}

public void RUN() {
while (true) {
if (flag == true) {
Random ran = new Random();
String ss = str[Math.abs(ran.nextInt()) % 22];
text.setText(ss);
text.setFont(new Font("",Font.BOLD,50));
}
try {
Thread.sleep(1);
} catch (InterruptedException e) {
e.printStackTrace();
}
;
}
}
}

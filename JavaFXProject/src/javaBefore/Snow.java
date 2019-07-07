package javaBefore;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class Snow{
    public static void main(String[] args){
          Frame w = new Frame();//创建一个面板
          w.setSize(800, 600);//设置面板大小
          w.setBackground(Color.black);//设置背景颜色
          MyJPanel p = new MyJPanel();//创建了一个画布对象
          w.add(p);
          Thread t = new Thread(p);//创建一个线程
          t.start();//启动线程
          w.setVisible(true);//显示面板

    }
}
class MyJPanel extends Panel implements Runnable{
    int[] x = new int[100];
    int[] y = new int[100];
    int[] y1 = new int[100];
    public MyJPanel(){
        for(int i=0;i<100;i++){
            x[i]=this.randomNum(800);
            y[i]=this.randomNum(600);
        }

}

    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(600, 70, 130, 130);
        g.setColor(Color.black);
        g.fillOval(550, 50, 130, 130);
        g.setColor(Color.white);
        for(int i =0;i<=100;i++){
            g.drawString("*", x[i], y[i]);
            for (int j = -1; j < y1[i]; j++) {
                g.drawString("*", x[i], 600-j*3);
            }
        }
    } 

    public void run(){
        while(true){
            for (int i = 0; i < y.length; i++) {
                if(y[i]<=600){
                    y[i]++;
                }else{
                    y1[i]++;
                    y[i] = 0;
                }
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //随机数生成
    public int randomNum(int a){
        return (int)(Math.random()*a);
    }
}
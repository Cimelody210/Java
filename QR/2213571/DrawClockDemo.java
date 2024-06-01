package TH6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawClockDemo extends JPanel implements ActionListener{

    Timer timer;
    public DrawClockDemo() {
        timer = new Timer(1000, this);
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        LocalTime time = LocalTime.now();
        int h = time.getHour();
        int m = time.getMinute();
        int s = time.getSecond();
        g.drawString("Hour: "+h+" Minute: "+m+" Second: "+s+"",190, 340);
        
        int xCenter = 260; int yCenter = 200;
        int R = 100;
        g.drawOval(xCenter - R, yCenter - R, 2*R, 2*R);
        
        g.drawString("12", xCenter - 10, yCenter - R + 15);
        g.drawString("3", xCenter + R - 15, yCenter);
        g.drawString("6", xCenter - 5, yCenter + R - 10);
        g.drawString("9", xCenter - R + 5, yCenter);
        
        int xEnd, yEnd;
        xEnd = xCenter + (int)((R-10)*Math.sin((double)s*2*Math.PI/60.0));
        yEnd = yCenter - (int)((R-10)*Math.cos((double)s*2*Math.PI/60.0));
        g.drawLine(xCenter, yCenter, xEnd, yEnd);
        
        g.setColor(Color.green);
        xEnd = xCenter + (int)((R-20)*Math.sin((double)(m+(double)s/60.0)*2*Math.PI/60.0));
        yEnd = yCenter - (int)((R-20)*Math.cos((double)(m+(double)s/60.0)*2*Math.PI/60.0));
        g.drawLine(xCenter, yCenter, xEnd, yEnd);
        
        g.setColor(Color.blue);
        xEnd = xCenter + (int)((R-30)*Math.sin((double)(h+(double)m/60.0+(double)s/3600.0)*2*Math.PI/12.0));
        yEnd = yCenter - (int)((R-30)*Math.cos((double)(h+(double)m/60.0+(double)s/3600.0)*2*Math.PI/12.0));
        g.drawLine(xCenter, yCenter, xEnd, yEnd);        
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Clock");
        DrawClockDemo clockDemo = new DrawClockDemo();
        frame.add(clockDemo);
        frame.setSize(520,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
}
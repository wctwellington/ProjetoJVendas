package controller;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Splash extends JWindow{
	public Splash() throws InterruptedException{
		int w = this.getToolkit().getDefaultToolkit().getScreenSize().width;
		int h = this.getToolkit().getDefaultToolkit().getScreenSize().height;
		int x = (w - 521) / 2;
		int y = (h - 335) / 2;
		
		JLabel img = new JLabel(new ImageIcon("images/logo_programa2.png"));
		img.setLocation(new Point(0,0));
		img.setSize(521, 315);
		
		this.setLayout(null);
		this.setLocation(new Point(x,y));
		this.setSize(512, 335);
		this.setVisible(true);
		
		JProgressBar barradeprogresso = new JProgressBar();
		barradeprogresso.setBackground(new Color(0,255,0));
		barradeprogresso.setBounds(3, 315, 521, 20);
		barradeprogresso.setStringPainted(true);
		this.add(img);
		this.add(barradeprogresso);
		
		new Thread(){
			public void run(){
				for(int progress = 0;progress < 101;progress++){
					try{
						
						barradeprogresso.setValue(progress);
					sleep(80);
					}	catch (InterruptedException e1){
							e1.printStackTrace();
					}
					
				}
			}
		}.start();
		Thread.sleep(9500);
		
		this.setVisible(false);

	}


}

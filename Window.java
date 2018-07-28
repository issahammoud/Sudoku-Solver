import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Window extends JWindow{

	public Thread t;
	public Background B=new Background();
	public JProgressBar bar;
	public JPanel pan=new JPanel();
	public Window(){
		
		this.setSize(600,600);
		this.setLocationRelativeTo(null);

		bar=new JProgressBar();
		bar.setMaximum(7);
		bar.setMinimum(0);
		bar.setStringPainted(true);
		
		t = new Thread(new Traitement());
		t.start();
	
		
		pan.setBackground(Color.white);
		pan.setPreferredSize(new Dimension(this.getWidth(),30));
		
		this.getContentPane().add(bar,BorderLayout.SOUTH);
		this.getContentPane().add(B, BorderLayout.CENTER);
		this.getContentPane().add(pan, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	class Traitement implements Runnable{
		
		public int random;
		Font font=new Font("Century Gothic",Font.CENTER_BASELINE,14);
		public void run(){
			
			
			bar.setFont(font);
			bar.setString("Sudoku v2.0");
			
			for(int i=0;i<=7;i++){
				
				bar.setValue(i);
				
			do{
				B.b=(int)(Math.random()*1000000)%9;
				
				B.c=(int)(Math.random()*1000000)%9;
			
			}while(B.b==B.c);
				
				
			
				try{
				Thread.sleep(350);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
				B.rect=false;
				B.repaint();
				
					
				try{
					Thread.sleep(350);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				B.rect=true;
				B.repaint();
				
				
		}
			
			
			B.bool=true;
			B.repaint();
			
			
			for(int i=0;i<600;i+=50){
				
			try{
				t.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			B.z=i;
			B.repaint();
			
	}
			setVisible(false);
			new Frame();
}
	}
}

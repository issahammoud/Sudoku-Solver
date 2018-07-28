import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{

	public AutoThread auto=new AutoThread();
	public Thread t=new Thread(auto);
	
	public Button b[]=new Button[4];
	public JPanel panB[]=new JPanel[4];
	public JPanel pan=new JPanel();
	
	public Panel1 pan1=new Panel1();

	public CardLayout cl=new CardLayout();
	public String listLayout[]={"solve a game","about","back"};
	
	public Background backg=new Background();
	
	public JPanel center=new JPanel();
	
	public Panel2 pan2=new Panel2();
	public About about=new About();
	
	public JPanel space=new JPanel();

	public Frame(){
		
		this.setSize(600,600);
		this.setTitle("The Sudoku Solver");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		b[0]=new Button("Solve a game",true,"Enter your game to solve it");
		b[1]=new Button("About",true,"About Soduko V 2.0");
		b[2]=new Button("Back",true,"Back to default panel");
		b[3]=new Button("Exit",true,"Exit");
		b[2].setEnabled(false);
		
		pan.setLayout(new GridLayout(1,3,10,0));
		
		for(int i=0;i<4;i++)
		{
			panB[i]=new JPanel();
			panB[i].add(b[i]);
			pan.add(panB[i]);
		}
		

		
		b[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.show(center, listLayout[0]);
				b[0].setEnabled(false);
				b[1].setEnabled(false);
				b[2].setEnabled(true);
			}
		});
		
		b[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.show(center, listLayout[1]);
				b[0].setEnabled(false);
				b[1].setEnabled(false);
				b[2].setEnabled(true);
				about.x=550;
				t=new Thread(auto);
				t.start();
			}
		});
	
		b[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.show(center, listLayout[2]);
				b[0].setEnabled(true);
				b[1].setEnabled(true);
				b[2].setEnabled(false);
				
			}
		});
		b[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			System.exit(EXIT_ON_CLOSE);	
			}
			});
		center.setLayout(cl);
		center.add(backg,listLayout[2]);
		center.add(pan2,listLayout[0]);
		center.add(about,listLayout[1]);
		
		space.setBackground(Color.white);
		space.setPreferredSize(new Dimension(this.getWidth(),30));
		
		this.getContentPane().add(pan, BorderLayout.SOUTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.getContentPane().add(space, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	class AutoThread implements Runnable{
		public void run(){
			
			about.bool=true;
		//	about.setname=false;
			while(about.x+650!=0){
			
			try{
				Thread.sleep(20);
			
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(about.x%50==0 && about.x<-300 && about.x>-600 && about.pos+4<=0)
				about.pos+=4;
			if(about.x%50==0 && about.x<0 && about.x>-300 && about.pos-4>-12)
				about.pos-=4;
			if(about.x%50==0 && about.x<300 && about.x>0 && about.pos-4>=0)
				about.pos-=4;
			if(about.x%50==0 && about.x>300 && about.pos+4<12)
				about.pos+=4;
			
			
			
			about.x--;
			about.repaint();
			
		}
			
			about.x=549;
			about.pos=0;
			about.bool=false;
		//	about.setname=true;
			about.repaint();
			
		}
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends JPanel{

	public TextField jtf[][]=new TextField[9][9];
	public TextField list[]=new TextField[9];
	public TextField level=new TextField();
	public int Nb;
	public int table[][]=new int[9][9];

	
	public JPanel panM=new JPanel();
	
	public Button b[]=new Button[6];
	public JPanel panL=new JPanel();
	public JPanel panR=new JPanel();
	
	
	public JLabel timer=new JLabel();
	public Panel1 panT;
	public String time="";
	public Font timerF=new Font("BankGothic Md BT",Font.CENTER_BASELINE,14);
	public boolean terminated=false;
	
	public JLabel screen=new JLabel();
	public JPanel panS=new JPanel();
	public Font font =new Font("Century Gothic",Font.ROMAN_BASELINE,20);
	
	public  int hour=0,min=0,sec=0;
	public Thread th;
	
	public boolean bool=true;
	
	public Panel1(boolean bool){
		this.bool=bool;
	}
	
	public Panel1(){
		
		panT=new Panel1(false);
		
	//	if(bool){
			
		
		panM.setLayout(new GridLayout(10,9));
	
			for(int i=0;i<9;i++){
			
			list[i]=new TextField();
			list[i].setText(String.valueOf(i+1));
			list[i].setEditable(false);
			panM.add(list[i]);
		}
	
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
			{
				jtf[i][j]=new TextField();
				
				if(i<3 && j<3 ||(i>=3 && j>=3 && i<6 && j<6 )|| (i>=6 && j>=6 && i<9 && j<9))
					jtf[i][j].setBackground(Color.GREEN);
				else	if(i>=3 && i<6 && j<3 || (j>=3 && j<6 && i>=6 && i<9) || (j>=6 && j<9 && i<3))
					jtf[i][j].setBackground(Color.YELLOW);
				else 
					jtf[i][j].setBackground(Color.CYAN);
				
							panM.add(jtf[i][j]);
				
			}
		

		
		b[0]=new Button("<html><i>P<br>l<br>a<br>y</i></html>",false,"Begin a new game");
		b[1]=new Button("<html><i>Show<br>one</i></html>",false,"Open a clicked closed case");
		b[2]=new Button("<html><i>Show<br>All</i></html>",false,"Show the solution");
		b[3]=new Button("<html><i>C<br>h<br>e<br>c<br>k</i></html>",false,"Check your solution");
		b[4]=new Button("<html><i>R<br>e<br>s<br>e<br>t</i></html>",false,"Replay with the same numbers");
		b[5]=new Button("<html><h2>Go</html>",false,"Generate the numbers");
		
		timer.setText("<html>00 h <br><br> 00 m <br><br> 00 s </html>");
		timer.setFont(timerF);
		timer.setHorizontalAlignment(JLabel.CENTER);
		
		b[1].setEnabled(false);
		b[2].setEnabled(false);
		b[3].setEnabled(false);
		b[4].setEnabled(false);
		
		b[0].addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				
				terminated=true;
				
				level.setPreferredSize(new Dimension(35,35));
				level.setText("");
				panS.add(level);
				panS.add(b[5]);
				screen.setText("How much numbers you want to generate?");
				level.setVisible(true);
				b[5].setVisible(true);
				for(int i=0;i<9;i++)
					for(int j=0;j<9;j++)
					{
						if(i<3 && j<3 ||(i>=3 && j>=3 && i<6 && j<6 )|| (i>=6 && j>=6 && i<9 && j<9))
							jtf[i][j].setBackground(Color.GREEN);
						else	if(i>=3 && i<6 && j<3 || (j>=3 && j<6 && i>=6 && i<9) || (j>=6 && j<9 && i<3))
							jtf[i][j].setBackground(Color.YELLOW);
						else 
							jtf[i][j].setBackground(Color.CYAN);
						
					}
				for(int i=0;i<9;i++){
					
					list[i].setVisible(true);
					for(int j=0;j<9;j++)
					{
						table[i][j]=0;
						jtf[i][j].setText("");
								
					}
				}
				b[5].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						terminated=false;
						
						
						if(isInteger(level.getText()))
						{
							Nb=Integer.parseInt(level.getText());
							if(Nb<18 || Nb>80)
							{
								Nb=0;
								screen.setText("Invalid Number! it could be between 18 and 80");
								level.setText("");
							}
							
							else {
								//generate
								
								level.setVisible(false);
								b[5].setVisible(false);
								b[1].setEnabled(true);
								b[2].setEnabled(true);
								b[3].setEnabled(true);
								b[4].setEnabled(true);
								screen.setText("Enjoy with your game");
								
								th=new Thread(new TimeThread("Thread "));
								th.start();
							}
						}
						else {
							screen.setText("Invalid Input");
							level.setText("");
						}
						
						
					
						
						b[1].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
								
								
								new Resolve(table);
								
								
							}
						});
						
						b[2].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
								for(int i=0;i<9;i++){
									list[i].setVisible(false);
									for(int j=0;j<9;j++)
										if(table[i][j]!=0)	
											jtf[i][j].setBackground(Color.GREEN);
										
										else jtf[i][j].setBackground(Color.WHITE);
										
								}
								new Resolve(table);
								b[0].setEnabled(true);
								b[1].setEnabled(false);
								b[2].setEnabled(false);
								b[3].setEnabled(false);
								
								for(int i=0;i<9;i++)
									for(int j=0;j<9;j++)
										jtf[i][j].setText(String.valueOf(table[i][j]));
								
								screen.setText("<html>Press Play to begin another game<br>Reset for the same game</html>");
							}
						});
						
						b[3].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
								 
							}
						});
						
						b[4].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
							
							terminated=true;
							
							th=new Thread(new TimeThread("thread1"));
							th.start();
							
							
							b[1].setEnabled(true);
							b[2].setEnabled(true);
							b[3].setEnabled(true);
							

								for(int i=0;i<9;i++){
									
									list[i].setVisible(true);
										for(int j=0;j<9;j++)
									
									{
										
										if(table[i][j]!=0)
											jtf[i][j].setText(String.valueOf(table[i][j]));
										
										if(i<3 && j<3 ||(i>=3 && j>=3 && i<6 && j<6 )|| (i>=6 && j>=6 && i<9 && j<9))
											jtf[i][j].setBackground(Color.GREEN);
										else	if(i>=3 && i<6 && j<3 || (j>=3 && j<6 && i>=6 && i<9) || (j>=6 && j<9 && i<3))
											jtf[i][j].setBackground(Color.YELLOW);
										else 
											jtf[i][j].setBackground(Color.CYAN);
									

									}
							}
							}
						});
					}
				});
				
				
			}
		});
		

		
		panT.setLayout(new BorderLayout());
		panT.add(timer,BorderLayout.CENTER);
		panR.add(panT);
		
		screen.setText("Press Play to begin a game");
		screen.setFont(font);
		screen.setHorizontalAlignment(JLabel.CENTER);
		panS.setLayout(new FlowLayout());
		panS.add(screen);
		

			
		panL.setLayout(new GridLayout(3,0));
		panR.setLayout(new GridLayout(3,0));
		
		for(int i=0;i<5;i++)
			
			if(i<3)
				panL.add(b[i]);
			
			else panR.add(b[i]);
		
	
		this.setLayout(new BorderLayout());
		this.add(panM,BorderLayout.CENTER);
		this.add(panL, BorderLayout.WEST);
		this.add(panR, BorderLayout.EAST);
		this.add(panS, BorderLayout.NORTH);
		
		
	}
	//}
/*	@Override
	public void paintComponent(Graphics g){
		
		if(!bool){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	
		}
		
	}
	*/
	public boolean isInteger(String str){
		
		try{
			Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	class TimeThread implements Runnable{
		
		Color C[]={Color.BLACK,Color.BLUE,Color.DARK_GRAY,Color.GRAY,Color.RED};
		String thread;
		public TimeThread(String thread){
			this.thread=thread;
		}
		public void run(){
			time="";
			
			if(terminated)
			{	try{
				
				
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
		
			while(true){
				terminated=false;
			try{
				
				
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		System.out.println(thread);
			sec++;
			
			if(sec>=60)
			{
				sec=0;
				min++;
			}
			if(min>=60){
				min=0;
				hour++;
			}
			
			timer.setForeground(C[min%5]);
			
			time="<html>";
			time+=(hour>9) ? String.valueOf(hour)+" h ": " 0"+String.valueOf(hour) +" h ";
			time+="<br><br>";
			time+=(min>9) ? String.valueOf(min)  +" m " : " 0"+String.valueOf(min)  +" m ";
			time+="<br><br>";
			time+=(sec>9) ? String.valueOf(sec) +" s " : " 0"+String.valueOf(sec) +" s " ;
			time+="</html>";
			timer.setText(time);
			
			
			if(terminated){
				
			

				timer.setText("<html>00 h <br><br> 00 m <br><br> 00 s </html>");
				sec=min=hour=0;
				terminated=false;
				
				break;
			}
			}
			
			
		}
	}

}

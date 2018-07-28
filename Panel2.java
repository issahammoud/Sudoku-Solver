import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel2 extends JPanel{

	
	public int table[][]=new int[9][9];
	public int temp[][]=new int [9][9];
	
	public String str;
	
	public TextField list[]=new TextField[9];
	public TextField jtf[][]=new TextField[9][9];

	public JPanel panM=new JPanel();
	public JPanel panB=new JPanel();
	
	public Font font =new Font("Century Gothic",Font.BOLD,18);
	
	public Button b[]=new Button[3];
	
	public JLabel lab=new JLabel();
	public JPanel panL=new JPanel();
	
	public Font font1=new Font("Century Gothic",Font.ROMAN_BASELINE,22);
	
	public Panel2(){
		
		
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
		
			b[0]=new Button("Submit",false,"Submit your entered numbers");
			b[1]=new Button("Solve",false,"Solve the game");
			b[2]=new Button("Reset",false,"Clear all");
			
			b[1].setEnabled(false);
			
			lab.setFont(font1);
			lab.setHorizontalAlignment(JLabel.CENTER);
			lab.setText("Test the Drag'n Drop option ;)");
			
			b[0].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				for(int i=0;i<9;i++)
					for(int j=0;j<9;j++){
						str=jtf[i][j].getText();
							if(isInteger(str)){
								if(Integer.parseInt(str)>=1 && Integer.parseInt(str)<=9)
									{
									table[i][j]=Integer.parseInt(str);
									
									}
								else {
									str="";
									jtf[i][j].setText(str);
									table[i][j]=0;
								}
							}
							else {
								str="";
								jtf[i][j].setText(str);
								table[i][j]=0;
							}

						}
					
					if(NbofNb(table)<18){
						
						lab.setFont(font1);
						lab.setHorizontalAlignment(JLabel.CENTER);
						lab.setText("A minimum of 18 numbers are required.");
						
					}
					
					else{
						lab.setText("Press Solve to solve it.");
						b[1].setEnabled(true);
						b[0].setEnabled(false);
					
					}
					
				}
			});
					b[1].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							
							b[1].setEnabled(false);
							lab.setText("Press Reset to clear all.");
					
							for(int i=0;i<9;i++){
								
							list[i].setVisible(false);
								for(int j=0;j<9;j++){
									str=jtf[i][j].getText();
									jtf[i][j].setEditable(false);
									if(isInteger(str)){
										if(Integer.parseInt(str)>=1 && Integer.parseInt(str)<=9)
											{
											table[i][j]=Integer.parseInt(str);
											jtf[i][j].setBackground(Color.GREEN);
											}
										else {
											str="";
											jtf[i][j].setText(str);
											table[i][j]=0;
											jtf[i][j].setBackground(Color.WHITE);
										}
									}
									else {
										str="";
										jtf[i][j].setText(str);
										table[i][j]=0;
										jtf[i][j].setBackground(Color.WHITE);
									}

								}
								
							}
							
						
							
							Resolve R=new Resolve(table);
						if(NbofNb(table)!=81 || !R.isResolved )
							{
							lab.setText("This game can't be resolved");
							for(int i=0;i<9;i++)
								for(int j=0;j<9;j++)
									table[i][j]=0;
								
							}
						
						else
										for(int i=0;i<9;i++)
											for(int j=0;j<9;j++)
											{
												if(!isInteger(jtf[i][j].getText()) || Integer.valueOf(jtf[i][j].getText())==0)
											
											 jtf[i][j].setForeground(Color.GREEN);
										else jtf[i][j].setForeground(Color.BLUE);
										
										jtf[i][j].setText(String.valueOf(table[i][j]));
										
											}	
								
							
						
						}
					});
					
					
			
			
			
			b[2].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					lab.setText("Test the Drag'n Drop option ;)");
					
					for(int i=0;i<9;i++){
						
						list[i].setVisible(true);
						for(int j=0;j<9;j++)
						{
							
							jtf[i][j].setText("");
							table[i][j]=0;
							jtf[i][j].setEditable(true);
							
							if(i<3 && j<3 ||(i>=3 && j>=3 && i<6 && j<6 )|| (i>=6 && j>=6 && i<9 && j<9))
								jtf[i][j].setBackground(Color.GREEN);
							else	if(i>=3 && i<6 && j<3 || (j>=3 && j<6 && i>=6 && i<9) || (j>=6 && j<9 && i<3))
								jtf[i][j].setBackground(Color.YELLOW);
							else 
								jtf[i][j].setBackground(Color.CYAN);
						}
					}
					b[0].setEnabled(true);
					b[1].setEnabled(false);
				}
				
			});
			
			panB.setLayout(new GridLayout(3,0));
			for(int i=0;i<3;i++)
				panB.add(b[i]);
			
		this.setLayout(new BorderLayout());	
		panL.add(lab);
		this.add(panL,BorderLayout.NORTH);
		this.add(panB, BorderLayout.WEST);
		this.add(panM, BorderLayout.CENTER);
	}
		
	
		@Override
	public void paintComponent(Graphics g){
	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		
	}
		

		public boolean isInteger(String str){
			
			try{
				Integer.parseInt(str);
			}
			catch(NumberFormatException e){
				return false;
			}
			
			return true;
		}
		
		public int NbofNb(int table[][]){
			
			int count=0;
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					if(table[i][j]!=0)
						count++;
			
			return count;
					
		}
		
	public void Reset(TextField jtf[][])
	{
		for(int i=0;i<9;i++)
			for(int j=9;j<9;j++)
				jtf[i][j].setText("");
	}
	
	}
	


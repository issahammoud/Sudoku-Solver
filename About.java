import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class About extends JPanel{
	
	public int x=550,pos=0;
	public String str[]=new String[14];
	boolean bool=true,setname=false;
		public About(){
		
		str[0]="Sudoku V 2.0";
		str[1]="Powered by Java";
		str[2]="Compiled on Eclipse";
		str[3]="GUI with :";
		str[4]="java.awt & javax.swing";
		str[5]="developed by :";
		str[6]="Issa Hammoud";
		str[7]="student engineer @";
		str[8]="Electrical and Electronics Department";
		str[9]="Lebanese University";
		str[10]="Faculty of Engineering-III";
		str[11]="contact me @";
		str[12]="issa.hammoud@outlook.com";
		str[13]="for more info";
	}
	public void paintComponent(Graphics g){
		
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		

		g.setColor(Color.LIGHT_GRAY);
			for(int x=getWidth(),y=getHeight();x>=0 || y>=0;x-=7+(pos+10),y-=7+(pos+10))
				g.drawLine(x,getHeight(), 0, y);
			
		g.setColor(Color.LIGHT_GRAY);
			for(int x=0,y=0;x<=getWidth() || y<=getHeight();x+=7+(pos+10),y+=7+(pos+10))
				g.drawLine(x,0, getWidth(), y);	
	
			if(bool)
	{
		g.setColor(Color.BLACK);
		g.drawOval(this.getWidth()/2 -26, this.getHeight()/2-26,52,52);
	
		g.setColor(Color.DARK_GRAY);
		g.fillOval(this.getWidth()/2 -13-pos, this.getHeight()/2-13-pos, 26, 26);
	}
		g.setColor(Color.BLUE);
		g.setFont(new Font("Century Gothic",Font.BOLD,24));
		
			g.drawString(str[0], 205, x);
			g.drawString(str[1], 185, x+50);
			g.drawString(str[2], 172, x+100);
			g.drawString(str[3], 235, x+150);
			g.drawString(str[4], 162, x+200);
			g.drawString(str[5], 193, x+250);
			g.drawString(str[6], 200, x+300);
			g.drawString(str[7], 185, x+350);
			g.drawString(str[9], 178, x+400);
			g.drawString(str[10],152, x+450);
			g.drawString(str[8], 95,  x+500);
			g.drawString(str[13], 205,x+550);
			g.drawString(str[11],205, x+600);
			g.drawString(str[12],135, x+650);
			
			
	/*		if(setname){
				
				g.setColor(Color.GREEN);
				g.drawString("Thank you to use my program", 80, 200);
				g.setFont(new Font("Edwardian Script ITC",Font.CENTER_BASELINE,24));
				g.setColor(Color.RED);
				g.drawString("Issa Hammoud",320,250);
			}
		*/
		
	}
	
	
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Background extends JPanel{

	public Color C[]={Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,Color.MAGENTA,Color.LIGHT_GRAY,Color.ORANGE,Color.PINK,Color.RED};
	public int b=1,c=0,z=0;
	public boolean bool=false,rect=true;
	
	public Background(){
		
		
	}

	@Override
	public void paintComponent(Graphics g){
		
		Font font=new Font("Century Gothic",Font.ROMAN_BASELINE,54);
		g.setFont(font);
		
		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, this.getWidth(), this.getHeight(),true);
		
		
		for(int y=50;y<=this.getHeight();y+=100)
				for(int x=25;x<=this.getWidth();x+=100)
					{
						if(rect){		
						
					g.setColor(C[b]);
					g.fill3DRect(x,y-50,50,50,false);
					if(y<this.getHeight()-50 && x<this.getWidth()-75)
					{
						g.setColor(C[c]);
						g.drawRect(x+50,y,50,50);
					}
					g.setColor(C[b]);
					g.drawString("S u d o k u",145,195);
					}
						else 
						{
							g.setColor(C[b]);
							g.drawOval(x,y-50,50,50);
							if(y<this.getHeight()-50 && x<this.getWidth()-75)
							{
								g.setColor(C[c]);
								g.fillOval(x+50,y,50,50);
							}
							
						
						}
					}
		
			
			
			
		if(bool)
		{	
			rect=false;
			repaint();
			font=new Font("MV Boli",Font.BOLD,60);
			g.setFont(font);
			g.setColor(Color.GREEN);
			g.drawString("S  u  d  o  k  u",30,45+z);
			
			 
		}
		
		
		
		
	}

}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class TextField extends JTextField  implements MouseListener{

	
	public Font font =new Font("Century Gothic",Font.BOLD,20);
	public static boolean bool=false;
	public static int nb;
	public TextField(){
		
//		this.setPreferredSize(new Dimension(50,50));
		this.setFont(font);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLUE);
		this.setDragEnabled(true);
		this.addMouseListener(this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		this.selectAll();	
		if(bool)
			{
			this.setText(String.valueOf(nb));
			bool=false;
			
			}
			
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.selectAll();
		this.setForeground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
			this.setForeground(Color.BLUE);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

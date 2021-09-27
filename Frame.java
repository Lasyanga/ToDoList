package Todo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.Border;

public class Frame extends JFrame{
	public Frame(){

	}

	private void initialized(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(400, 300));
		this.setTitle("To do");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
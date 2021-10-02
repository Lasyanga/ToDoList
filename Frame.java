package Todo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Frame extends JFrame implements MouseListener{
	private JScrollPane scroll;
	private JTextArea txt_area;
	private JPanel panelTop, panel_ListCenter;
	private JLabel menulbl, addtask, savelbl, tasklist;
	private Timer tick;
	private List<String> list = new ArrayList<String>();
	

	public Frame(){
		initialized();
	}

	private void initialized(){
		Border border = BorderFactory.createLineBorder(Color.red, 1);
		GridLayout layout = new GridLayout(10, 1);
		layout.setVgap(5);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(300, 400));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("To do");

		panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(100, 40));
		panelTop.setLayout(null);
		panelTop.setBackground(Color.blue);

		menulbl = new JLabel("Task List");
		menulbl.setFont(new Font("Consolas", Font.PLAIN, 16));
		menulbl.setLocation(new Point(0, 0));
		menulbl.setSize(new Dimension(100, 40));
		menulbl.setForeground(Color.white);
		menulbl.setHorizontalAlignment(JLabel.CENTER);
		menulbl.addMouseListener(this);
		

		addtask = new JLabel("+");
		addtask.setLocation(new Point(240, 0));
		addtask.setSize(new Dimension(40, 40));
		addtask.setFont(new Font("Consolas", Font.PLAIN, 24));
		addtask.setForeground(Color.white);
		addtask.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addtask.setHorizontalAlignment(JLabel.CENTER);
		addtask.setToolTipText("Add new task");
		addtask.addMouseListener(this);		

		panelTop.add(menulbl);
		panelTop.add(addtask);

		panel_ListCenter = new JPanel();
		panel_ListCenter.setLayout(layout);
		panel_ListCenter.setBorder(border);

		tasklist = new JLabel();
		tasklist.setForeground(Color.black);
		tasklist.setOpaque(true);		
		
		txt_area = new JTextArea();
		txt_area.setFont(new Font("Consolas", Font.PLAIN, 16));
		txt_area.setForeground(Color.BLACK);
		txt_area.setWrapStyleWord(true);
		txt_area.setLineWrap(true);
		txt_area.setBorder(border);

		scroll = new JScrollPane();
		scroll.setViewportView(txt_area);
		scroll.setVisible(false);

		savelbl = new JLabel("Add Task");
		savelbl.setHorizontalAlignment(JLabel.CENTER);
		savelbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		savelbl.setForeground(Color.white);
		savelbl.setOpaque(true);
		savelbl.setBackground(Color.blue);
		savelbl.setFont(new Font("Consolas", Font.PLAIN, 16));
		savelbl.setPreferredSize(new Dimension(100, 40));
		savelbl.addMouseListener(this);
		savelbl.setVisible(false);

		this.add(panelTop, BorderLayout.NORTH);		
		this.add(panel_ListCenter, BorderLayout.CENTER);
		this.add(savelbl, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	@Override
	public void mouseClicked(MouseEvent e){
		if(e.getSource() == savelbl){
			if(!txt_area.getText().isEmpty()){
				String task = txt_area.getText();
				list.add(task);
				System.out.println("Size: "+list.size());
				ListIterator<String> listIterator = list.listIterator();
				txt_area.setText("");

				if(list.size() > 0 ){
					panel_ListCenter.removeAll();
				}

				while(listIterator.hasNext()){
					panel_ListCenter.add(new JLabel(listIterator.next().trim()));					
				}
				
				scroll.setVisible(false);
				savelbl.setVisible(false);
				addtask.setVisible(true);
				menulbl.setText("Task List");
				
				panel_ListCenter.setVisible(true);
			}
		}

		if(e.getSource() == addtask){
			menulbl.setText("View Task");
			addtask.setVisible(false);
			scroll.setVisible(true);
			savelbl.setVisible(true);
			panel_ListCenter.setVisible(false);
			this.add(scroll, BorderLayout.CENTER);
		}

		if(e.getSource() == menulbl){
			if(menulbl.getText().equals("View Task")){
				txt_area.setText("");				
				scroll.setVisible(false);
				savelbl.setVisible(false);
				addtask.setVisible(true);
				menulbl.setText("Task List");
				panel_ListCenter.setVisible(true);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e){
		if(e.getSource() == addtask){
			addtask.setForeground(Color.green);
		}

		if(e.getSource() == menulbl){
			addtask.setForeground(Color.green);
		}
	}

	@Override
	public void mouseExited(MouseEvent e){
		if(e.getSource() == addtask){
			addtask.setForeground(Color.white);
		}

		if(e.getSource() == menulbl){
			addtask.setForeground(Color.white);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e){
		
	}

	@Override
	public void mouseReleased(MouseEvent e){
		
	}

}
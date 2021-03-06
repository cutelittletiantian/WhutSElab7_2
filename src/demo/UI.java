package demo;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {

	private JFrame frame;
	Checkerboard checkerboard= new Checkerboard(20, 20);
	int [][] gird1;
	JButton jb[][];
	JButton btnNewButton=new JButton();
	int statu=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Checkerboard checkerboard = new Checkerboard(10, 15);
		int row1 =checkerboard.GetRow();
		int column1=checkerboard.GetColumn();
		 gird1=checkerboard.GetGird();
		 jb=new JButton[row1][column1];
		
		
		frame = new JFrame("生命游戏");
		frame.setBounds(100, 100,(column1+1)*21,(row1+2)*22);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setSize(column1*20,(row1+1)*20);//棋盘长宽：column*50,row*50
		frame.getContentPane().setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 0, frame.getContentPane().getWidth(), row1*20);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(row1,column1,0,0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, row1*20, frame.getContentPane().getWidth(), 40);
		frame.getContentPane().add(panel_1);
		
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("迭代");
		time t=new time();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(statu==0) {
					statu=1;
				   t.start();
				}
				else t.resume();
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("暂停");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					t.suspend();;
				
			}
		}); 
		panel_1.add(btnNewButton_2);
		
		for(int i=0;i<row1;i++) {
			for(int j=0;j<column1;j++) {
				jb[i][j]=new JButton();
				panel.add(jb[i][j]);
			}
		}
		Draw_color(row1,column1);	
	}
	
	
	//为活的细胞着白色、死的着黑色
	public void Draw_color(int row,int column) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(gird1[i+1][j+1]==0) {
					jb[i][j].setBackground(Color.white);
				}
				else {
					jb[i][j].setBackground(Color.black);
				}
			}
		}
		btnNewButton.setText("第"+checkerboard.GetNowGeneration()+"次迭代");
	}
	
	
//线程
 class time extends Thread{
	public void run() {
		for(int i=1;i>0;i++)
		{
		  checkerboard.Transfer();
		  Draw_color(checkerboard.GetRow(),checkerboard.GetColumn());		 
		try {
			this.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
 
}
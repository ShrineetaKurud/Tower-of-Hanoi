package com.project;
import javax.swing.JFrame;
import java.awt.EventQueue;

@SuppressWarnings("serial")

public class fGame extends JFrame{
	
		public static void main(String args[]){
			
		EventQueue.invokeLater(new Runnable(){
			
			public void run()
			{
				try{
					fGame f=new fGame();
					f.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
		
	public fGame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,300);
		setTitle("TOWER OF HANOI");
		setContentPane(new GamePlay());
		setResizable(false);
	}
}

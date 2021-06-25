package com.project;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Home{
	
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Home(){
		initialize();
	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("Home");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.setBounds(100,100,500,300);
		frame.setLayout(null);
		
		JLabel name= new JLabel(" TOWER OF HANOI         ");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setBounds(130, 0, 900, 100);
		frame.getContentPane().add(name);
		
		JLabel name1= new JLabel("ENTER YOUR NAME   : ");
		name1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name1.setBounds(40, 120, 160, 30);
		frame.getContentPane().add(name1);
		
		JTextField nametf = new JTextField();
		nametf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nametf.setBounds(200, 120, 200, 30);
		frame.getContentPane().add(nametf);
		
		JButton bttn = new JButton("START GAME");
		bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=nametf.getText();
				fGame f=new fGame();
				f.setVisible(true);
				System.out.print("Name : " + userName + "\n");
				frame.setVisible(false);
			}
		});
	
		bttn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bttn.setBounds(230, 200, 180, 30);
		frame.getContentPane().add(bttn);
	
	}
}
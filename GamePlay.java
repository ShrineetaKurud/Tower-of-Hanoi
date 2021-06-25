package com.project;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

@SuppressWarnings("serial")

public class GamePlay extends JPanel{
	
	Stack tower1=new Stack();
	Stack tower2=new Stack();
	Stack tower3=new Stack();
	
	boolean isSelectedtower1=true;
	boolean isSelectedtower2=false;
	boolean isSelectedtower3=false;
	
	Block carriedBlock = null;
	
	public GamePlay(){
		
		addKeyListener(new ControlAdapter());
		setFocusable(true);
		
		tower1.push(new Block(90));
		tower1.push(new Block(70));
		tower1.push(new Block(50));
		tower1.push(new Block(30));
	}
	
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.fillRect(70,40,20,160);
		g.fillRect(230,40,20,160);
		g.fillRect(390,40,20,160);
		
		tower1.drawblocks(g,30);
		tower2.drawblocks(g,190);
		tower3.drawblocks(g,350);
		
		if(carriedBlock != null){
			int xPos =0;

			if(isSelectedtower1){
				xPos = 30+ (100 - carriedBlock.getLength())/2;
			}
			else if(isSelectedtower2){
				xPos = 190+ (100 - carriedBlock.getLength())/2;
			}
			else if(isSelectedtower3){
				xPos = 350+ (100 - carriedBlock.getLength())/2;
			}
			
			g.fillRect(xPos, 20, carriedBlock.getLength(), 19);
				
		}
		
		g.setColor(Color.red);
		
		if(isSelectedtower1){
			g.drawRect(1,20,158,190);
		}
		else if(isSelectedtower2){
			g.drawRect(161,20,158,190);
		}
		else if(isSelectedtower3){
			g.drawRect(321,20,158,190);
		}
		
	}
	

	private void checkMove() {
		if(tower2.count()==4 || tower3.count()==4 ){
			JOptionPane.showMessageDialog(GamePlay.this, "YOU WIN !!");
		}
		
	}
	
	public class ControlAdapter extends KeyAdapter{
	
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT){
				if(isSelectedtower1){
					isSelectedtower2=true;
					isSelectedtower1=false;
				}else if(isSelectedtower2){
					isSelectedtower3=true;
					isSelectedtower2=false;
				}
			}
			
			if(key == KeyEvent.VK_LEFT){
				if(isSelectedtower2){
					isSelectedtower1=true;
					isSelectedtower2=false;
				}else if(isSelectedtower3){
					isSelectedtower2=true;
					isSelectedtower3=false;
				}
			}
			
			if(key == KeyEvent.VK_UP){
				if(carriedBlock == null){
					if(isSelectedtower1){
						carriedBlock =tower1.pop();
					}
					else if(isSelectedtower2){
						carriedBlock =tower2.pop();
					}
					else if(isSelectedtower3){
						carriedBlock =tower3.pop();
					}
				
				}
			}
			
			if(key == KeyEvent.VK_DOWN){
				if(carriedBlock != null){
					if(isSelectedtower1){
						if(tower1.peek()==null || tower1.peek().getLength() > carriedBlock.getLength()){
							tower1.push(carriedBlock);
							carriedBlock = null;
						}
					}
					else if(isSelectedtower2){
						if(tower2.peek()==null || tower2.peek().getLength() > carriedBlock.getLength()){
							tower2.push(carriedBlock);
							carriedBlock = null;
						}
					}
					else if(isSelectedtower3){
						if(tower3.peek()==null || tower3.peek().getLength() > carriedBlock.getLength()){
							tower3.push(carriedBlock);
							carriedBlock = null;
						}				
					}
				}
				checkMove();
			}
			
			repaint();	 
		}
	}
}



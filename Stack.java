
package com.project;

import java.awt.Color;
import java.awt.Graphics;

public class Stack{
	
	private Block headblock;
		
	public Block getheadblock(){
		return headblock;
	}
	
	public void setheadblock(Block headblock){
		this.headblock=headblock;
	}
	
	public void push(Block block){
		
		if(headblock==null){
			headblock=block;
		}else{
			Block currentblock=headblock;
				while(currentblock.getNext()!=null){
					currentblock=currentblock.getNext();
				}
			currentblock.setNext(block);
		}
	}
	
	public Block pop(){
		Block popblock=null;
		
		if(count()==1){
			popblock=headblock;
			headblock=null;
		}else if(count()>1){
			Block currentblock=headblock;
			for(int i=1;i<count()-1;i++)
				currentblock=currentblock.getNext();

				popblock=currentblock.getNext();
				currentblock.setNext(null);
		}	
			return popblock;
	}
	
	public Block peek(){
		
		if(count()>0){
			Block currentblock=headblock;
			while(currentblock.getNext()!=null){	
				currentblock=currentblock.getNext();
			}
			return currentblock;
		}else{
			return null;
		}
	}
	
	
	public int count(){
	
		int ctr=0;
		Block currentblock=headblock;
		while(currentblock!=null){
			ctr++;
			currentblock=currentblock.getNext();	
		}
		System.out.println("Count="+ctr);
		return ctr;
	}
	
	
	public void drawblocks(Graphics g,int x){	
		Block currentblock=headblock;
		
		for(int i=0;i<count();i++){
			int xpos=x+(100-currentblock.getLength())/2;
			int ypos=180-(i*20);
			g.setColor(Color.blue);
			g.fillRect(xpos,ypos,currentblock.getLength(),19);
			currentblock=currentblock.getNext();
		}
	}
}

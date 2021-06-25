package com.project;

class Block{
	
	private int length;
	public Block next;
	
	public Block(int length){
		
		super();
		this.length=length;
		this.next=null;
	}	
	
	public int getLength(){
		return length;
	}
	
	public void setLength(int length){
		this.length=length;
	}
	
	public Block getNext(){
		return next;
	}
	
	public void setNext(Block next){
		this.next=next;
	}	
}

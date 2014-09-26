package com.hpeng2.todolist;

/* This this the interface of Listener contain a update() method and will be called
 * after the list operation to ensure that the list view will updated immediately 
 * after user add or remove the event from list*/

public interface Listener {
	
	public void update();

}
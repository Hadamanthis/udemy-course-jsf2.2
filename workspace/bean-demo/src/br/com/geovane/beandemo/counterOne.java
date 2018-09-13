package br.com.geovane.beandemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class counterOne {
	
	private int value = 0;
	
	// No-args constructor
	public counterOne() {
		
	}
	
	public String increment() {
		value++;
		
		return "counter_one";
	}
	
	// Getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

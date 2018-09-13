package br.com.geovane.beandemo;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class counterTwo {
	
	private int value = 0;
	
	// No-args constructor
	public counterTwo() {
		
	}
	
	public String increment() {
		value++;
		
		return "counter_two";
	}
	
	// Getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

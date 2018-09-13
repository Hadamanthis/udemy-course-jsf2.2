package br.com.geovane.beandemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class counterThree {
	
	private int value = 0;
	
	// No-args constructor
	public counterThree() {
		
	}
	
	public String increment() {
		value++;
		
		return "counter_three";
	}
	
	// Getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

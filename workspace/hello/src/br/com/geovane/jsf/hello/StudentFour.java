package br.com.geovane.jsf.hello;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentFour {

	private String firstName;
	private String lastName;
	private String[] favoriteLanguages;
	
	// no-args constructor
	public StudentFour() {
		
	}

	// Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getFavoriteLanguages() {
		return favoriteLanguages;
	}

	public void setFavoriteLanguages(String[] favoriteLanguages) {
		this.favoriteLanguages = favoriteLanguages;
	}
	
}

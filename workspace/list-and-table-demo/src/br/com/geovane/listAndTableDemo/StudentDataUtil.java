package br.com.geovane.listAndTableDemo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class StudentDataUtil {

	private List<Student> students;
	
	// No-args constructor
	public StudentDataUtil() {
		loadSampleData();
	}

	public void loadSampleData() {
		students = new ArrayList<>();
		
		students.add(new Student("Mary", "Public", "mary@luv2code.com"));
		students.add(new Student("John", "Doe", "john@luv2code.com"));
		students.add(new Student("Ajay", "Rao", "ajay@luv2code.com"));
	}
	
	// Getters and setters
	public List<Student> getStudents() {
		return students;
	}
	
}

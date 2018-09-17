package br.com.geovane.jsf.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudentController {
	
	private List<Student> students;
	private StudentDbUtil studentDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Initializes students list and the DAO
	public StudentController() throws Exception {
		students = new ArrayList<>();
		
		studentDbUtil = StudentDbUtil.getInstance();
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void loadStudents() {
		
		logger.info("Loading students");
		
		students.clear();
		
		try {
			// Get all students from database
			students = studentDbUtil.getStudents();
		} catch (Exception exc) {
			// Send this to servers logs
			logger.log(Level.SEVERE, "Error loading students", exc);
			
			// Add error message for JSF page
			addErrorMessage(exc);
		}
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
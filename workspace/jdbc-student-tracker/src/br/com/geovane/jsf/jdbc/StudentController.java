package br.com.geovane.jsf.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped
public class StudentController {
	
	private List<Student> students;
	private String searchText;
	
	private StudentDbUtil studentDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// initializes students list and the DAO
	public StudentController() throws Exception {
		students = new ArrayList<>();
		
		studentDbUtil = StudentDbUtil.getInstance();
	}
	
	public void loadStudents(ComponentSystemEvent event) {
		
		logger.info("Loading students");
		
		logger.info("searchText: " + searchText);
		
		students.clear();
		
		try {
			if (searchText != null && searchText.trim().length() > 0) {
				// search for students by name
				students = studentDbUtil.getStudents(searchText);
			} else {
				// get all students from database
				students = studentDbUtil.getStudents();
			}
		} catch (Exception exc) {
			// send this to servers logs
			logger.log(Level.SEVERE, "Error loading students", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	
	public String addStudent(Student theStudent) {
		
		logger.info("Adding student: " + theStudent);
		
		try {
			// add student to the database
			studentDbUtil.addStudent(theStudent);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding students", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "student_list?faces-redirect=true";
	}
	
	public String loadStudent(int studentId) {
		
		logger.info("loading student: " + studentId);
		
		try {
			// get student from database
			Student theStudent = studentDbUtil.getStudent(studentId);
			
			// put in the request attribute .. so we can use it on
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("student", theStudent);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading student id" + studentId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "student_update_form";
	}
	
	public String updateStudent(Student theStudent) {
		
		logger.info("updating student: " + theStudent);
		
		try {
			// update student in the database
			studentDbUtil.updateStudent(theStudent);
		} catch (Exception exc) {
			// send this to server log
			logger.log(Level.SEVERE, "Error updating student: " + theStudent, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "student_list?faces-redirect=true";
	}
	
	public String deleteStudent(int studentId) {
		
		logger.info("deleting student: " + studentId);
		
		try {
			studentDbUtil.deleteStudent(studentId);
		} catch (Exception exc) {
			// send this to server log
			logger.log(Level.SEVERE, "Error deleting student: " + studentId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "student_list?faces-redirect=true";
	}
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
}

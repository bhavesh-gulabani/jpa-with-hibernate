package EmployeeManagement;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String projectName;
	private String details;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	// Constructors
	public Project() {
		
	}
	
	public Project(int projectId, String projectName, String details, Set<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.details = details;
		this.employees = employees;
	}
	
	public Project(int projectId, String projectName, String details) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.details = details;
	}
	
	public Project(String projectName, String details) {
		this.projectName = projectName;
		this.details = details;
	}

	// Getters and setters
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	// toString
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", details=" + details
				+ ", employees=" + employees + "]";
	}
}



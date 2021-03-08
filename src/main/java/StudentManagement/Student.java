package StudentManagement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")	// Optional to give the table name
public class Student {
	
	@Id
	private int studentId;
	private String name;
	private String email;
	
//	@OneToOne
//	private Batch batch;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
	
	// Constructors
	public Student() {
		super();
	}
	
	public Student(int studentId, String name, String email, Batch batch) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.batch = batch;
	}

	// Getters and Setters
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	// toString
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", batch=" + batch + "]";
	}
}

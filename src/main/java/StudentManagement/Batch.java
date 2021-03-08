package StudentManagement;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Batch")
public class Batch {
	
	@Id
	private int batchId;
	private String batchTitle;
	private LocalDate startDate;
	private LocalDate endDate;

//	@OneToOne(mappedBy = "batch")
//	private Student student;

	// This setting where class is taking a backseat in managing
	// the association between Batch and Student
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "batch", cascade = CascadeType.ALL)
	Set<Student> students = new HashSet<>();
	
	public Batch(int batchId, String batchTitle, LocalDate startDate, LocalDate endDate) {
		super();
		this.batchId = batchId;
		this.batchTitle = batchTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Batch() {
		super();
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchTitle() {
		return batchTitle;
	}

	public void setBatchTitle(String batchTitle) {
		this.batchTitle = batchTitle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchTitle=" + batchTitle + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

	
	
}

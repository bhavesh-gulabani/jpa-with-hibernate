package StudentManagement.apps;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import StudentManagement.Batch;
import StudentManagement.Student;

public class StudentMain {
	public static void main(String[] args) {
		
		// This factory instance is a thread safe instance
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo1");
		
		// Creating a new session with db
		EntityManager entityManager = factory.createEntityManager();
		
		// Create instance of object to be persisted
		// Student student = new Student(101, "John", "john@gmail.com");
		Batch batch = new Batch(1101, "Angular", LocalDate.of(2021, 02, 11), LocalDate.of(2021, 04, 30));
		Student studentOne = new Student(101, "Jonh", "john@gmail.com", batch);
		
		Student studentTwo = new Student(102, "Jane", "jane@gmail.com", null);
		Student studentThree = new Student(103, "David", "david@gmail.com", null);
		Student studentFour = new Student(104, "Snow", "snow@gmail.com", null);
		
		// Fetching batch
		Batch angularBatch = entityManager.find(Batch.class, 1101);
		
		// Alloting same batch to these students
//		studentTwo.setBatch(angularBatch);
//		studentThree.setBatch(angularBatch);
//		studentFour.setBatch(angularBatch);
		
		// Running in transaction mode
//		entityManager.getTransaction().begin();
		
		// ALREADY DONE...
		// entityManager.persist(batch);
		// entityManager.persist(studentOne);
		
//		entityManager.persist(studentTwo);
//		entityManager.persist(studentThree);
//		entityManager.persist(studentFour);
		
//		entityManager.getTransaction().commit();
		
		System.out.println("Student objects saved on to Student table in Oracle db");
		
		// Querying the table....
		// To list out the student object...
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		query.getResultList().forEach(System.out::println);
		
		entityManager.close();
		
		//----------------------------------------------------
		EntityManager em2 = factory.createEntityManager();
		Query q1 = em2.createQuery("SELECT s1 FROM Student s1 WHERE s1.name LIKE 'J%'");
		System.out.println(q1.getResultList());
		
		em2.close();
		
	}
}

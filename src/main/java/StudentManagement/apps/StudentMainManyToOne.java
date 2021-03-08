package StudentManagement.apps;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Transaction;

import StudentManagement.Batch;
import StudentManagement.Student;

public class StudentMainManyToOne {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo1");
		EntityManager entityManager = factory.createEntityManager();
		
		Student studentOne = new Student(101, "John", "john@gmail.com", null);
		Student studentTwo = new Student(102, "Jane", "jane@gmail.com", null);
		Student studentThree = new Student(103, "David", "david@gmail.com", null);
		Student studentFour = new Student(104, "Snow", "snow@gmail.com", null);
		
		Batch batchOne = new Batch(1101, "Angular", LocalDate.of(2021, 02, 11), LocalDate.of(2021, 04, 30));
		Batch batchTwo = new Batch(1102, "React", LocalDate.of(2021, 02, 11), LocalDate.of(2021, 04, 30));
		
		studentOne.setBatch(batchOne);
		studentTwo.setBatch(batchOne);
		
		studentThree.setBatch(batchTwo);
		studentFour.setBatch(batchTwo);
		
		Transaction trx = (Transaction) entityManager.getTransaction();
		
		trx.begin();
		
		// Batch objects will be persisted first
		entityManager.persist(batchOne);
		entityManager.persist(batchTwo);
		
		// Then student objects will be persisted
		entityManager.persist(studentOne);
		entityManager.persist(studentTwo);
		entityManager.persist(studentThree);
		entityManager.persist(studentFour);
		
		trx.commit();
		entityManager.close();
	
		System.out.println("Done!");
	}

}

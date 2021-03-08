package StudentManagement.apps;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Transaction;

import StudentManagement.Batch;
import StudentManagement.Student;

public class StudentMainBidirectional {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo1");
		EntityManager entityManager = factory.createEntityManager();
		
		Student studentOne = new Student(101, "John", "john@gmail.com", null);
		Student studentTwo = new Student(102, "John", "john@gmail.com", null);
		
		Batch batchOne = new Batch(1101, "Angular", LocalDate.of(2021, 02, 11), LocalDate.of(2021, 04, 30));
		Batch batchTwo = new Batch(1102, "React", LocalDate.of(2021, 02, 11), LocalDate.of(2021, 04, 30));
		
		// Do not set studenId in batch as it will cause circular dependency, leave that attribute
		// empty in batch table
		
		studentOne.setBatch(batchOne);
		studentTwo.setBatch(batchTwo);
		
		Transaction trx = (Transaction) entityManager.getTransaction();
		
		trx.begin();
		
		// Batch objects will be persisted first
		entityManager.persist(batchOne);
		entityManager.persist(batchTwo);
		
		// Then student objects will be persisted
		entityManager.persist(studentOne);
		entityManager.persist(studentTwo);
		
		trx.commit();
		entityManager.close();
	
		System.out.println("Done!");
	}

}

package EmployeeManagement.apps;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Transaction;

import EmployeeManagement.Employee;
import EmployeeManagement.Project;

public class EmpMain {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo1");
		EntityManager entityManager = factory.createEntityManager();
		
		Employee employeeOne = new Employee("John", 20000);
		Employee employeeTwo= new Employee("Jane", 20000);
		Employee employeeThree = new Employee("David", 20000);
		Employee employeeFour = new Employee("Snow", 20000);
		Employee employeeFive = new Employee("Robin", 20000);
		Employee employeeSix = new Employee("Val", 20000);

		Project projectOne = new Project("Migration", "Migration details");
		Project projectTwo = new Project("Salesforce", "Salesforce details");
	
		Set <Project> setOfProjects = new HashSet<>();
		setOfProjects.add(projectOne);
		setOfProjects.add(projectTwo);
		
		employeeOne.setProjects(setOfProjects);
		employeeTwo.setProjects(setOfProjects);
		employeeThree.setProjects(setOfProjects);
		
		Project projectThree = new Project("Dev", "Dev details");
		Project projectFour = new Project("Support", "Support details");
	
		Set <Project> setOfProjectsTwo = new HashSet<>();
		setOfProjectsTwo.add(projectThree);
		setOfProjectsTwo.add(projectFour);
		
		employeeFour.setProjects(setOfProjectsTwo);
		employeeFive.setProjects(setOfProjectsTwo);
		employeeSix.setProjects(setOfProjectsTwo);
	
		
		Transaction trx = (Transaction) entityManager.getTransaction();
		
		trx.begin();
		
		entityManager.persist(employeeOne);
		entityManager.persist(employeeTwo);
		entityManager.persist(employeeThree);
		entityManager.persist(employeeFour);
		entityManager.persist(employeeFive);
		entityManager.persist(employeeSix);
		

		
		trx.commit();
		entityManager.close();
	
		System.out.println("Done!");

	}
	
}

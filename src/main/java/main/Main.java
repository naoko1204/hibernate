package main;

import entities.Address;
import entities.Car;
import entities.Student;
import enums.Color;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Student student = Student.builder()
                .fullName("Egor Egorov")
                .build();

        Address address = Address.builder()
                .city("Chisinau")
                .street("Puskin")
                .student(student)
                .build();

        student.setAddress(address);

        entityManager.persist(student);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

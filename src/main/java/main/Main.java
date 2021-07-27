package main;

import embeddable.Address;
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

        Student student = Student.builder()
                .fullName("Oleg Olegov")
                .city("London")
                .street("Street1")
                .build();
        Student student2 = Student.builder()
                .fullName("Vladimir Vladimirov")
                .city("New-York")
                .street("Street2")
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(student);
        entityManager.persist(student2);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

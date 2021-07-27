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

        Address address = Address.builder()
                .street("Tighina")
                .city("Chisinau")
                .student(Student.builder()
                        .fullName("Alexandr Alexandrov")
                        .build())
                .build();
        entityManager.persist(address);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

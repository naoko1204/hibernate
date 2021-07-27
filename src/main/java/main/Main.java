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

        Address address = Address.builder()
                .city("Moscow")
                .street("Some street")
                .build();

        Student student = Student.builder()
                .fullName("Ivan Ivanov")
                .address(address)
                .build();

        Student student2 = Student.builder()
                .fullName("Petea Petrov")
                .address(address)
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(student);
        entityManager.persist(student2);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

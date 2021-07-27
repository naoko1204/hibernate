package main;

import entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Car car1 = Car.builder()
                .model("Lada")
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(car1);

        entityManager.getTransaction().commit();
    }
}

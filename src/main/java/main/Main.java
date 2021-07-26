package main;

import entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Car car1 = new Car();
        car1.setId(1);
        car1.setModel("Audi");
        car1.setColor("white");
        car1.setMileage(500_000);
        car1.setProdYear(LocalDate.of(2005, 10, 1));

        Car car2 = Car.builder()
                .id(2)
                .model("Porsche")
                .color("Black")
                .mileage(100_000)
                .prodYear(LocalDate.of(2021, 1, 30))
                .build();

        entityManager.getTransaction().begin();

        entityManager.persist(car1);
        entityManager.persist(car2);

        entityManager.getTransaction().commit();
    }
}

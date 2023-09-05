package ru.mikhailov.coffeemaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mikhailov.coffeemaker.model.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query("SELECT c FROM Coffee c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:nameCoffee), '%') ORDER BY c.id ASC")
    List<Coffee> findFirstCoffeeByNameCoffee(String nameCoffee);
}

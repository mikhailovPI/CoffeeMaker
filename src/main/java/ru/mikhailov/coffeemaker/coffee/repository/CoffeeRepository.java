package ru.mikhailov.coffeemaker.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;
import ru.mikhailov.coffeemaker.config.PageRequestOverride;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query("SELECT c FROM Coffee c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:nameCoffee), '%')")
    List<Coffee> findCoffeeByName(@Param("nameCoffee") String nameCoffee, PageRequestOverride pageRequest);

    @Query("SELECT c FROM Coffee c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:nameCoffee), '%')")
    Coffee findCoffeeByName(@Param("nameCoffee") String nameCoffee);

}

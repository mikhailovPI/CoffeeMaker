package ru.mikhailov.coffeemaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.coffeemaker.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}

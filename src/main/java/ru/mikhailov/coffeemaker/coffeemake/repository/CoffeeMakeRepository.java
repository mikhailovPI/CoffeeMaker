package ru.mikhailov.coffeemaker.coffeemake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.coffeemaker.coffeemake.model.CoffeeMake;

public interface CoffeeMakeRepository extends JpaRepository<CoffeeMake, Long> {
}

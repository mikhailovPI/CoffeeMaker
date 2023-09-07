package ru.mikhailov.coffeemaker.coffeemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;

public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Long> {
}

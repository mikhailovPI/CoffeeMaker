package ru.mikhailov.coffeemaker.coffeemachine.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;

@Service
public interface CoffeeMachineService {

    void turnOn(Long id);

    void turnOff(Long id);

    CoffeeMachineDto createCoffeeMachine(CoffeeMachineDto coffeeMachineDto);

    void makeCoffee(Long coffeeMachineId, Long coffeeId);

    CoffeeMachineDto createMachine(CoffeeMachineDto coffeeMachineDto);
}

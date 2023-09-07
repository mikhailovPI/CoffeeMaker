package ru.mikhailov.coffeemaker.coffeemachine.mapper;

import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;

public class CoffeeMachineMapper {

    public static CoffeeMachine toCoffeeMachine(CoffeeMachineDto coffeeMachineDto) {
        return new CoffeeMachine(
                coffeeMachineDto.getId(),
                coffeeMachineDto.getName(),
                false);
    }

    public static CoffeeMachineDto toCoffeeMachineDto(CoffeeMachine coffeeMachine) {
        return new CoffeeMachineDto(
                coffeeMachine.getId(),
                coffeeMachine.getName());
    }
}

package ru.mikhailov.coffeemaker.config;

import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;
import ru.mikhailov.coffeemaker.exception.ValidationException;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;

public class Validation {

    public static void validationBodyCoffee(Coffee coffee) {
        if (coffee.getName().isBlank()) {
            throw new ValidationException("Имя не должно быть пустым.");
        }
    }

    public static void validationBodyCoffeeMachine(CoffeeMachine coffeeMachine) {
        if (coffeeMachine.getName().isBlank()) {
            throw new ValidationException("Имя не должно быть пустым.");
        }
    }
}
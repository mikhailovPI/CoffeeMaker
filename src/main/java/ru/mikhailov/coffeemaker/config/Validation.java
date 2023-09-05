package ru.mikhailov.coffeemaker.config;

import ru.mikhailov.coffeemaker.exception.ValidationException;
import ru.mikhailov.coffeemaker.model.Coffee;

public class Validation {

    public static void validationBodyCoffee(Coffee coffee) {
        if (coffee.getName() == null) {
            throw new ValidationException("E-mail не должен быть пустым.");
        }
    }
}
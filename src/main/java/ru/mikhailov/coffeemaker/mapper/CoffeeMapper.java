package ru.mikhailov.coffeemaker.mapper;

import ru.mikhailov.coffeemaker.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.model.Coffee;

public class CoffeeMapper {

    public static Coffee toCoffee(CoffeeDto coffeeDto) {
        return new Coffee(
                coffeeDto.getId(),
                coffeeDto.getName()
        );
    }

    public static CoffeeDto toCoffeeDto(Coffee coffee) {
        return new CoffeeDto(
                coffee.getId(),
                coffee.getName()
        );
    }

    public static Coffee toCoffee(CoffeeUpdateDto coffeeUpdateDto) {
        return new Coffee(
                null,
                coffeeUpdateDto.getName()
        );
    }

    public static CoffeeUpdateDto toCoffeeUpdateDto(Coffee coffee) {
        return new CoffeeUpdateDto(
                coffee.getName()
        );
    }
}

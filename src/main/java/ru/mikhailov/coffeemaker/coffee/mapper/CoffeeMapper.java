package ru.mikhailov.coffeemaker.coffee.mapper;

import ru.mikhailov.coffeemaker.coffee.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;

public class CoffeeMapper {

    public static Coffee toCoffee(CoffeeDto coffeeDto) {
        return new Coffee(
                coffeeDto.getId(),
                coffeeDto.getName(),
                coffeeDto.getCoffeeVolume(),
                coffeeDto.getCoffeeVolume());
    }

    public static CoffeeDto toCoffeeDto(Coffee coffee) {
        return new CoffeeDto(
                coffee.getId(),
                coffee.getName(),
                coffee.getMilkVolume(),
                coffee.getCoffeeVolume());
    }

    public static Coffee toCoffee(Long id, CoffeeUpdateDto coffeeUpdateDto) {
        return new Coffee(
                id,
                coffeeUpdateDto.getName(),
                coffeeUpdateDto.getMilkVolume(),
                coffeeUpdateDto.getCoffeeVolume());
    }

    public static CoffeeUpdateDto toCoffeeUpdateDto(Coffee coffee) {
        return new CoffeeUpdateDto(
                coffee.getName(),
                coffee.getMilkVolume(),
                coffee.getCoffeeVolume());
    }
}

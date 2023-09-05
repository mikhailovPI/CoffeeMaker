package ru.mikhailov.coffeemaker.coffee.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeUpdateDto;

import java.util.List;

@Service
public interface CoffeeService {
    List<CoffeeDto> getAllCoffee(int from, int size);

    CoffeeDto getCoffeeById(Long id);

    List<CoffeeDto> searchCoffeeByName(String nameCoffee, int from, int size);

    CoffeeDto createCoffee(CoffeeDto coffee);

    CoffeeDto patchCoffee(Long id, CoffeeUpdateDto coffee);

    void deleteCoffeeById(Long id);
}

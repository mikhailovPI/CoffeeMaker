package ru.mikhailov.coffeemaker.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.coffeemaker.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.model.Coffee;

import java.util.List;

@Service
public interface CoffeeService {
    List<CoffeeDto> getAllCoffee(int from, int size);

    CoffeeDto getCoffeeById(Long id);

    List<CoffeeDto> searchCoffeeByName(String nameCoffee);

    CoffeeDto createCoffee(CoffeeDto coffee);

    CoffeeDto patchCoffee(Long id, CoffeeUpdateDto coffee);

    void deleteCoffeeById(Long id);
}

package ru.mikhailov.coffeemaker.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.coffeemaker.model.Coffee;

import java.util.List;

@Service
public interface CoffeeService {
    List<Coffee> getAllCoffee();

    Coffee getCoffeeById(Long id);

    List<Coffee> searchCoffeeByName(String nameCoffee);

    Coffee createCoffee(Coffee coffee);

    Coffee patchCoffee(Long id, Coffee coffee);

    void deleteCoffeeById(Long id);
}

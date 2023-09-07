package ru.mikhailov.coffeemaker.coffeemachine.service;

import org.springframework.stereotype.Service;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;

@Service
public interface CoffeeMachineService {

    //public void makeCoffee(String nameCoffee);
    public void makeCoffee(CoffeeMachineDto coffeeMachineDto);
}

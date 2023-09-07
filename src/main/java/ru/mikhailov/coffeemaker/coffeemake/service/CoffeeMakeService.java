package ru.mikhailov.coffeemaker.coffeemake.service;

import org.springframework.stereotype.Service;

@Service
public interface CoffeeMakeService {

    void makeCoffee(Long coffeeMachineId, Long coffeeId);
}

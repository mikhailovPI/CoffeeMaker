package ru.mikhailov.coffeemaker.coffeemake.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;
import ru.mikhailov.coffeemaker.coffee.repository.CoffeeRepository;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;
import ru.mikhailov.coffeemaker.coffeemachine.repository.CoffeeMachineRepository;
import ru.mikhailov.coffeemaker.coffeemake.model.CoffeeMake;
import ru.mikhailov.coffeemaker.coffeemake.repository.CoffeeMakeRepository;
import ru.mikhailov.coffeemaker.exception.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeMakeServiceImpl implements CoffeeMakeService {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeRepository coffeeRepository;
    private final CoffeeMakeRepository coffeeMakeRepository;

    @Override
    @Transactional
    public void makeCoffee(Long coffeeMachineId, Long coffeeId) {
        CoffeeMachine coffeeMachine = coffeeMachineRepository.findById(coffeeMachineId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данная кофемашина c id %s не существует!", coffeeMachineId)));
        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Кофе  c id %s не существует!", coffeeId)));
        if (coffeeMachine.getPower()) {
            CoffeeMake coffeeMake = new CoffeeMake(
                    1L,
                    coffeeMachine,
                    coffee);
            coffeeMakeRepository.save(coffeeMake);
        } else {
            throw new NotFoundException(String.format(
                    "Кофемашина %s не включена!", coffeeMachine.getName()));
        }
    }
}

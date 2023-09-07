package ru.mikhailov.coffeemaker.coffeemachine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.coffeemaker.coffee.repository.CoffeeRepository;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;
import ru.mikhailov.coffeemaker.coffeemachine.repository.CoffeeMachineRepository;
import ru.mikhailov.coffeemaker.exception.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeRepository coffeeRepository;

    @Override
    @Transactional
    public void makeCoffee(CoffeeMachineDto coffeeMachineDto) {
/*        if (true) {
            CoffeeMachine coffeeMachine = new CoffeeMachine(
                    coffeeRepository.findCoffeeByName(coffeeMachineDto.getCoffee().getName()));
            coffeeMachineRepository.save(coffeeMachine);
        } else {
            throw new NotFoundException(
                    String.format("Кофеварка выключена. Включите кофеварку и получайте удовольствие от кофе!:)"));
        }*/
    }

/*    @Override
    @Transactional
    public void makeCoffee(String nameCoffee) {
            CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeRepository.findCoffeeByName(nameCoffee));
            coffeeMachineRepository.save(coffeeMachine);
    }*/
}

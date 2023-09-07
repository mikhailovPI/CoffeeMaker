package ru.mikhailov.coffeemaker.coffeemachine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;
import ru.mikhailov.coffeemaker.coffee.repository.CoffeeRepository;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;
import ru.mikhailov.coffeemaker.coffeemachine.repository.CoffeeMachineRepository;
import ru.mikhailov.coffeemaker.exception.NotFoundException;

import static ru.mikhailov.coffeemaker.coffeemachine.mapper.CoffeeMachineMapper.toCoffeeMachine;
import static ru.mikhailov.coffeemaker.coffeemachine.mapper.CoffeeMachineMapper.toCoffeeMachineDto;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeRepository coffeeRepository;

    @Override
    @Transactional
    public void turnOn(Long id) {
        CoffeeMachine coffeeMachine = getCoffeeMachine(id);
        coffeeMachine.setPower(true);
        coffeeMachineRepository.save(coffeeMachine);
    }

    @Override
    @Transactional
    public void turnOff(Long id) {
        CoffeeMachine coffeeMachine = getCoffeeMachine(id);
        coffeeMachine.setPower(false);
        coffeeMachineRepository.save(coffeeMachine);
    }

    @Override
    @Transactional
    public CoffeeMachineDto createCoffeeMachine(CoffeeMachineDto coffeeMachineDto) {
//        Coffee coffee = coffeeRepository.findById(coffeeMachineDto.getCoffee())
//                .orElseThrow();
        CoffeeMachine coffeeMachine = toCoffeeMachine(coffeeMachineDto);
        //coffeeMachine.setCoffee(coffee);
        coffeeMachineRepository.save(coffeeMachine);
        return toCoffeeMachineDto(coffeeMachine);
    }

    @Override
    @Transactional
    public void makeCoffee(Long coffeeMachineId, Long coffeeId) {
        CoffeeMachine coffeeMachine = getCoffeeMachine(coffeeMachineId);
    }

    @Override
    @Transactional
    public CoffeeMachineDto createMachine(CoffeeMachineDto coffeeMachineDto) {
        CoffeeMachine coffeeMachine = toCoffeeMachine(coffeeMachineDto);
        coffeeMachineRepository.save(coffeeMachine);
        return toCoffeeMachineDto(coffeeMachine);
    }

    private CoffeeMachine getCoffeeMachine(Long id) {
        return coffeeMachineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данная кофемашина c id %s не существует!", id)));
    }
}

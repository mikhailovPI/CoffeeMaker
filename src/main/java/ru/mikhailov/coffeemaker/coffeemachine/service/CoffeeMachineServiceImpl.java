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

import static ru.mikhailov.coffeemaker.coffeemachine.mapper.CoffeeMachineMapper.toCoffeeMachine;
import static ru.mikhailov.coffeemaker.coffeemachine.mapper.CoffeeMachineMapper.toCoffeeMachineDto;
import static ru.mikhailov.coffeemaker.config.Validation.validationBodyCoffeeMachine;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;

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
        CoffeeMachine coffeeMachine = toCoffeeMachine(coffeeMachineDto);
        validationBodyCoffeeMachine(coffeeMachine);
        coffeeMachineRepository.save(coffeeMachine);
        return toCoffeeMachineDto(coffeeMachine);
    }

    private CoffeeMachine getCoffeeMachine(Long id) {
        return coffeeMachineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данная кофемашина c id %s не существует!", id)));
    }
}

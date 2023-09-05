package ru.mikhailov.coffeemaker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.coffeemaker.config.PageRequestOverride;
import ru.mikhailov.coffeemaker.exception.NotFoundException;
import ru.mikhailov.coffeemaker.model.Coffee;
import ru.mikhailov.coffeemaker.repository.CoffeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public List<Coffee> getAllCoffee(int from, int size) {
        PageRequestOverride pageRequest = PageRequestOverride.of(from, size);
        return coffeeRepository.findAll(pageRequest)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данный кофе %s не существует!", id)));
    }

    @Override
    public List<Coffee> searchCoffeeByName(String nameCoffee) {
        return coffeeRepository.findFirstCoffeeByNameCoffee(nameCoffee);
    }

    @Override
    @Transactional
    public Coffee createCoffee(Coffee coffee) {
        return null;
    }

    @Override
    @Transactional
    public Coffee patchCoffee(Long id, Coffee coffee) {
        return null;
    }

    @Override
    @Transactional
    public void deleteCoffeeById(Long id) {

    }
}

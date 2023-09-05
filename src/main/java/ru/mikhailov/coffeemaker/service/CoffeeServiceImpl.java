package ru.mikhailov.coffeemaker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ru.mikhailov.coffeemaker.config.PageRequestOverride;
import ru.mikhailov.coffeemaker.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.exception.NotFoundException;
import ru.mikhailov.coffeemaker.exception.ValidationException;
import ru.mikhailov.coffeemaker.mapper.CoffeeMapper;
import ru.mikhailov.coffeemaker.model.Coffee;
import ru.mikhailov.coffeemaker.repository.CoffeeRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.mikhailov.coffeemaker.config.Validation.validationBodyCoffee;
import static ru.mikhailov.coffeemaker.mapper.CoffeeMapper.toCoffee;
import static ru.mikhailov.coffeemaker.mapper.CoffeeMapper.toCoffeeDto;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public List<CoffeeDto> getAllCoffee(int from, int size) {
        PageRequestOverride pageRequest = PageRequestOverride.of(from, size);
        return coffeeRepository.findAll(pageRequest)
                .stream()
                .map(CoffeeMapper::toCoffeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public CoffeeDto getCoffeeById(Long id) {
        return toCoffeeDto(coffeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данный кофе %s не существует!", id))));
    }

    @Override
    public List<CoffeeDto> searchCoffeeByName(String nameCoffee) {
        return coffeeRepository.findFirstCoffeeByNameCoffee(nameCoffee)
                .stream()
                .map(CoffeeMapper::toCoffeeDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CoffeeDto createCoffee(CoffeeDto coffee) {
        validationBodyCoffee(toCoffee(coffee));
        if (coffeeRepository.findAll()
                .stream()
                .noneMatch(c -> c.getName().equals(coffee.getName()))) {
            return toCoffeeDto(coffeeRepository.save(toCoffee(coffee)));
        } else {
            throw new ValidationException(String.format("Название кофе %s уже существует. Напишите новое название!:)",
                    coffee.getName()));
        }
    }

    @Override
    @Transactional
    public CoffeeDto patchCoffee(Long id, CoffeeUpdateDto coffee) {
        Coffee coffeeDataBase = coffeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Данный кофе %s не существует!", id)));
        if (!coffeeDataBase.getName().equals(coffee.getName())) {
            coffeeDataBase.setName(coffee.getName());
            return toCoffeeDto(coffeeRepository.save(coffeeDataBase));
        } else {
            throw new ValidationException(String.format("Название кофе %s уже существует. Напишите новое название!:)",
                    coffee.getName()));
        }
    }

    @Override
    @Transactional
    public void deleteCoffeeById(Long id) {
        if (coffeeRepository.findById(id).isPresent()) {
            coffeeRepository.deleteById(id);
        } else {
            throw new NotFoundException(
                    String.format("Данный кофе %s не существует!", id));
        }
    }
}

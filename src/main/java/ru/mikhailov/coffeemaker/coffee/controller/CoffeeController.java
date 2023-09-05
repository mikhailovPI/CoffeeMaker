package ru.mikhailov.coffeemaker.coffee.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.coffee.service.CoffeeService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeController.URL_COFFEE)
public class CoffeeController {

    public static final String URL_COFFEE = "/coffeemaker";
    private final CoffeeService coffeeService;

    @GetMapping
    public List<CoffeeDto> getAllCoffee(
            @RequestParam(name = "from", defaultValue = "0") int from,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return coffeeService.getAllCoffee(from, size);
    }

    @GetMapping(path = "/{id}")
    public CoffeeDto getCoffeeById(@PathVariable Long id) {
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping(path = "/name")
    public List<CoffeeDto> searchCoffeeByName(
            @RequestParam(name = "nameCoffee", required = false) String nameCoffee,
            @RequestParam(name = "from", defaultValue = "0") int from,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return coffeeService.searchCoffeeByName(nameCoffee, from, size);
    }

    @PostMapping
    public CoffeeDto createCoffee(@RequestBody CoffeeDto coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @PatchMapping(path = "/{id}")
    public CoffeeDto patchCoffee(
            @PathVariable Long id,
            @RequestBody CoffeeUpdateDto coffee) {
        return coffeeService.patchCoffee(id, coffee);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCoffeeById(@PathVariable Long id) {
        coffeeService.deleteCoffeeById(id);
    }
}

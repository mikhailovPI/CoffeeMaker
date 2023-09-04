package ru.mikhailov.coffeemaker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.model.Coffee;
import ru.mikhailov.coffeemaker.service.CoffeeService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeController.URL_COFFEE)
public class CoffeeController {

    public static final String URL_COFFEE = "/coffeemaker";
    private final CoffeeService coffeeService;

    @GetMapping
    public List<Coffee> getAllCoffee () {
        return coffeeService.getAllCoffee();
    }

    @GetMapping(path = "/{id}")
    public Coffee getCoffeeById (@PathVariable Long id) {
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping(path = "/name" )
    public List<Coffee> searchCoffeeByName (
            @RequestParam(name = "nameCoffee", required = false) String nameCoffee) {
        return coffeeService.searchCoffeeByName(nameCoffee);
    }

    @PostMapping
    public Coffee createCoffee (@RequestBody Coffee coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @PatchMapping(path = "/{id}")
    public Coffee patchCoffee(
            @PathVariable Long id,
            @RequestBody Coffee coffee) {
        return coffeeService.patchCoffee(id, coffee);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCoffeeById (@PathVariable Long id) {
        coffeeService.deleteCoffeeById(id);
    }
}

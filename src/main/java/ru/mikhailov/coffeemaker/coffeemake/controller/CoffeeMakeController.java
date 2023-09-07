package ru.mikhailov.coffeemaker.coffeemake.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.coffeemake.service.CoffeeMakeService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeMakeController.URL_COFFEE_MAKE)
public class CoffeeMakeController {

    public static final String URL_COFFEE_MAKE = "/coffee_make";

    private final CoffeeMakeService coffeeMakeService;

    @PostMapping( path = "/{coffeeMachineId}/make/{coffeeId}")
    public void makeCoffee(
            @PathVariable Long coffeeMachineId,
            @PathVariable Long coffeeId) {
        log.info("PostMapping/Приготовление кофе/makeCoffee");
            coffeeMakeService.makeCoffee(coffeeMachineId, coffeeId);
    }
}